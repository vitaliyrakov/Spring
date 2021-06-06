package com.geekbrains.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> repository = new ArrayList<>();

    public List<Product> getList() {
        return repository;
    }

    public Product getById(int id) {
        return repository.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }

    public void save(Product product) {
        product.setId();
        repository.add(product);
    }

    public boolean isEmpty() {
        return repository.isEmpty();
    }

}