package com.mspr_kawa.clients.main.fakerdata;


import com.github.javafaker.Faker;
import com.mspr_kawa.clients.main.model.*;
import com.mspr_kawa.clients.main.repository.CustomerRepository;
import com.mspr_kawa.clients.main.repository.OrderRepository;
import com.mspr_kawa.clients.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FakeDataMain {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final Faker faker;

    @Autowired
    public FakeDataMain(Faker faker, CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.faker = faker;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.initDB();
    }

    private void initDB() {

        for (int i = 0; i < 100; i++) {
            Customer customer = this.customerRepository.save(this.generateFakeCustomer());
            for (int j = 0; j < 3; j++) {
                Order order = this.generateFakeOrder(customer);
                for (int k = 0; k < 5; k++) {
                    Product product = this.productRepository.save(this.generateFakeProduct());
                    order.addProduct(product);
                }
            }
        }
    }

    private Customer generateFakeCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setUsername(faker.name().username());
        customer.setName(customer.getFirstName() + " " + customer.getLastName());

        Adress address = new Adress();
        address.setPostalCode(faker.address().zipCode());
        address.setCity(faker.address().city());
        customer.setAdress(address);

        Company company = new Company();
        company.setCompanyName(faker.company().name());
        customer.setCompany(company);

        ProfileCustomer profile = new ProfileCustomer();
        profile.setFirstName(faker.name().firstName());
        profile.setLastName(faker.name().lastName());
        customer.setProfile(profile);

        return customer;
    }

    private Product generateFakeProduct() {

        Details details = new Details();
        details.setDescription(faker.lorem().characters(50, 200));
        details.setColor(faker.commerce().color());
        details.setPrice((float) faker.number().randomDouble(2, 0, 1000));

        Product product = new Product();
        product.setName(faker.commerce().productName());
        product.setStock(faker.random().nextInt(10, 1000));
        product.setDetails(details);
        return product;
    }

    private Order generateFakeOrder(Customer customer) {
        Order order = new Order();
        order.setCustomer(customer);
        return order;
    }
}
