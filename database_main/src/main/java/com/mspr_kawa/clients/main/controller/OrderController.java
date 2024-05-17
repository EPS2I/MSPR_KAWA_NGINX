package com.mspr_kawa.clients.main.controller;

import com.mspr_kawa.clients.main.model.Order;
import com.mspr_kawa.clients.main.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint pour récupérer une liste des orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> Orders = orderService.getAllOrders();
        return ResponseEntity.ok(Orders);
    }

    // Endpoint pour récupérer un client par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        Order Order = orderService.getOrderById(id);
        if (Order != null) {
            return ResponseEntity.ok(Order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour créer un nouveau order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order Order) {
        Order createdOrder = orderService.createOrder(Order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    // Endpoint pour mettre à jour un client existant
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order Order) {
        Order updatedOrder = orderService.updateOrder(id, Order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        boolean deleted = orderService.deleteOrder(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
