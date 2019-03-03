package com.interview.task.domain;

import java.util.UUID;

public class Car {
    private String uuid;
    private Brand brand;
    private BodyType bodyType;
    private int yearOfProduction;
    private float engineCapacity;
    private FuelType fuelType;
    private Transmission transmission;
    private int bhp;
    private ClassType classType;

    public Car(String uuid,
               Brand brand,
               BodyType bodyType,
               int yearOfProduction,
               float engineCapacity,
               FuelType fuelType,
               Transmission transmission,
               int bhp,
               ClassType classType) {
        this.uuid = uuid;
        this.brand = brand;
        this.bodyType = bodyType;
        this.yearOfProduction = yearOfProduction;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.bhp = bhp;
        this.classType = classType;
    }

    public Car(Brand brand,
               BodyType bodyType,
               int yearOfProduction,
               float engineCapacity,
               FuelType fuelType,
               Transmission transmission,
               int bhp,
               ClassType classType) {
        this.uuid = UUID.randomUUID().toString();
        this.brand = brand;
        this.bodyType = bodyType;
        this.yearOfProduction = yearOfProduction;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.bhp = bhp;
        this.classType = classType;
    }

    public String getUuid() {
        return uuid;
    }

    public Brand getBrand() {
        return brand;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public int getBhp() {
        return bhp;
    }

    public ClassType getClassType() {
        return classType;
    }

    @Override
    public String toString() {
        return "{" +
                "brand=" + brand +
                ", bodyType=" + bodyType +
                ", yearOfProduction=" + yearOfProduction +
                ", engineCapacity=" + engineCapacity +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                ", bhp=" + bhp +
                ", classType=" + classType +
                '}';
    }
}
