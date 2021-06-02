package ru.gb.demo;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> list = new ArrayList<>();

    public void add(Product product) {
        list.add(product);
    }

    public List<Product> getList() {
        return list;
    }

    public Product getProductById(int id) {
        return list.stream().filter(it-> it.getId()==id).findFirst().orElse(null);
    }

    @PostConstruct
    public void fill() {
        list.add(new Product(1, "хлеб", 50));
        list.add(new Product(2, "молоко", 60));
        list.add(new Product(3, "масло", 200));
        list.add(new Product(4, "крупа", 40));
        list.add(new Product(5, "соль", 20));
    }

}
