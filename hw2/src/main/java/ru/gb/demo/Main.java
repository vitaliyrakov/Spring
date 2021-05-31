package ru.gb.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.demo");
//        ProductRepository pr = new ProductRepository();
//        pr.add(new Product(1, "Product " + 1, new Random().nextInt(10000) / 100.0));
//        pr.add(new Product(2, "Product " + 2, new Random().nextInt(10000) / 100.0));
//        pr.add(new Product(3, "Product " + 3, new Random().nextInt(10000) / 100.0));
//        pr.add(new Product(4, "Product " + 4, new Random().nextInt(10000) / 100.0));
//        pr.add(new Product(5, "Product " + 5, new Random().nextInt(10000) / 100.0));
        System.out.println(context);
    }
}
