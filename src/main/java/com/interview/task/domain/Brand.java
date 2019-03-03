package com.interview.task.domain;

public final class Brand {
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}
