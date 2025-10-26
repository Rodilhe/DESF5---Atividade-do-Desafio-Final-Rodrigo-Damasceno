package com.desafio.rodrigo_damasceno.controller;


import com.desafio.rodrigo_damasceno.model.Product;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
public interface ProductController {
    @PostMapping
    ResponseEntity<Product> create (@RequestBody Product product);
    @GetMapping
    ResponseEntity<List<Product>> findAll();
    @GetMapping("/count")
    ResponseEntity<Long> count();
    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable Long id);
    @GetMapping("/search")
    ResponseEntity<List<Product>> findByName(@RequestParam String name);
    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
