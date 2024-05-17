package com.mspr_kawa.clients.main.repository;

import com.mspr_kawa.clients.main.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product,UUID> {
}
