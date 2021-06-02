package ru.gb.demo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private final List<Product> list = new ArrayList<>();

    public void add(Product product) {
        list.add(product);
    }
    public void addAll(List<Product> listProduct) {
        list.addAll(listProduct);
    }

    public void remove(Product product) {
        list.remove(product);
    }
    public void removeAll() {
        list.removeAll(list);
    }

    public List<Product> getList(){
        return list;
    }
}
