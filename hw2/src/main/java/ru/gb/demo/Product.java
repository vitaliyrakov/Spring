package ru.gb.demo;

import org.springframework.stereotype.Component;

//@Component
public class Product {
    private int id;
    private String title;
    private double cost;

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s, cost: %.2f$", id, title, cost);
    }

}
