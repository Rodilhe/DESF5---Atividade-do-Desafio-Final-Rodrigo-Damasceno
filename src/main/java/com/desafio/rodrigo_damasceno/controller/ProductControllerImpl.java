package com.desafio.rodrigo_damasceno.controller;

import com.desafio.rodrigo_damasceno.model.Product;
import com.desafio.rodrigo_damasceno.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController{
    private final ProductService service;

    public ProductControllerImpl(ProductService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<Product> create(Product product) {
        Product productCreated = service.create(product);
        return ResponseEntity.created(URI.create("/api/product/" + productCreated.getId())).body(productCreated);
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

    @Override
    public ResponseEntity<Product> findById(Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Product>> findByName(String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @Override
    public ResponseEntity<Product> update(Long id, Product product) {
        try {
            Product productUpdated = service.update(id, product);
            return ResponseEntity.ok(productUpdated);
        } catch (IllegalArgumentException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
