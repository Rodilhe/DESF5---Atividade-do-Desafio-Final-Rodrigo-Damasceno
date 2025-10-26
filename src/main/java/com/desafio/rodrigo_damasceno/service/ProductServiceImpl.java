package com.desafio.rodrigo_damasceno.service;

import com.desafio.rodrigo_damasceno.model.Product;
import com.desafio.rodrigo_damasceno.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product create(Product product) {
        return repo.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public Product update(Long id, Product product) {
        return repo.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            return repo.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}