package com.desafio.rodrigo_damasceno.service;
import com.desafio.rodrigo_damasceno.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByName(String name);
    long count();
    Product update(Long id, Product product);
    void delete(Long id);
}