package ru.gb.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {
    List<Product> list;

    public void add(Product pr){
        list.add(pr);
    }

    public List<Product> getList() {
        return list;
    }

    public void getProduct(int id){
//        return list.;
    }


}
