package com.geekbrains.model;

public class Product {
    private static int counter;
    private int id;
    private String name;
    private double cost;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setId() {
        id = ++counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s, cost: %.2f$", id, name, cost);
    }

}
