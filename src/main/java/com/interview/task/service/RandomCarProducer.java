package com.interview.task.service;

import com.interview.task.domain.*;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public final class RandomCarProducer {
    private RandomCarProducer() {}

    private static final int minYearOfProduction;
    private static final int maxYearOfProduction;
    private static final int minBhp;
    private static final int maxBhp;

    private static final Random random;

    private static final List<Brand> brands;
    private static final List<Float> engineCapacities;
    private static final List<BodyType> bodyTypes;
    private static final List<FuelType> fuelTypes;
    private static final List<Transmission> transmissions;
    private static final List<ClassType> classTypes;

    static  {
        random = new Random(System.currentTimeMillis());
        minYearOfProduction = 1970;
        maxYearOfProduction = Calendar.getInstance().get(Calendar.YEAR);
        minBhp = 60;
        maxBhp = 800;

        brands = asList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Citroen", "Daewoo", "Dodge", "Ferrari", "FIAT", "Ford", "Geely", "Hummer", "Hyundai", "Infiniti", "Jaguar", "Jeep", "KIA", "Lamborghini", "Land Rover", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Opel", "Peugeot", "Pontiac", "Porsche", "Renault", "Rolls-Royce", "Saab", "Skoda", "Smart", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo").stream()
                                .map(Brand::new).collect(Collectors.toList());
        engineCapacities = asList(1.2f, 1.3f, 1.4f, 1.8f, 2.0f, 2.2f, 3.0f, 4.0f, 4.8f, 6.0f);
        fuelTypes = asList(FuelType.values());
        bodyTypes = asList(BodyType.values());
        transmissions = asList(Transmission.values());
        classTypes = asList(ClassType.values());
    }

    public static Car produce() {
        Brand brand = getRandomElement(brands);
        BodyType bodyType = getRandomElement(bodyTypes);
        int yearOfProduction = getRandomInRange(minYearOfProduction, maxYearOfProduction);
        Float engineCapacity = getRandomElement(engineCapacities);
        FuelType fuelType = getRandomElement(fuelTypes);
        Transmission transmission = getRandomElement(transmissions);
        int bhp = getRandomInRange(minBhp, maxBhp);
        ClassType classType = getRandomElement(classTypes);
        return new Car(brand, bodyType, yearOfProduction, engineCapacity, fuelType, transmission, bhp, classType);
    }

    private static <T> T getRandomElement(List<T> data) {
        int index = random.nextInt(data.size());
        return data.get(index);
    }

    private static int getRandomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
