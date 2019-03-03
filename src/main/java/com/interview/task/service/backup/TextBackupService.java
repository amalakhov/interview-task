package com.interview.task.service.backup;

import com.interview.task.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TextBackupService implements BackupService {
    private static final Logger logger = LoggerFactory.getLogger(TextBackupService.class);

    private static final String DELIMITER = "|";
    private static final String NEW_LINE = "\r\n";

    @Override
    public boolean store(Collection<Car> cars, Path path) {
        String data = cars.stream()
                .map(this::toString)
                .collect(Collectors.joining(NEW_LINE));

        try {
            Files.write(path, data.getBytes(Charset.forName("UTF-8")), StandardOpenOption.CREATE_NEW);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return false;
        }
    }

    @Override
    public Collection<Car> restore(Path path) {
        try {
            return Files.readAllLines(path).stream()
                                           .map(this::parse)
                                           .collect(Collectors.toList());

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException("restore by path = '" + path + "' failed");
        }
    }

    private Car parse(String line) {
        String[] parts = line.split("\\" + DELIMITER);

        String uuid = UUID.fromString(parts[0]).toString();
        Brand brand = new Brand(parts[1]);
        ClassType classType = ClassType.valueOf(parts[2]);
        BodyType bodyType = BodyType.valueOf(parts[3]);
        FuelType fuelType = FuelType.valueOf(parts[4]);
        Transmission transmission = Transmission.valueOf(parts[5]);
        int bhp = Integer.parseInt(parts[6]);
        float engineCapacity = Float.parseFloat(parts[7]);
        int yearOfProduction = Integer.parseInt(parts[8]);

        return new Car(uuid, brand, bodyType, yearOfProduction, engineCapacity, fuelType, transmission, bhp, classType);
    }

    private String toString(Car car) {
        return  car.getUuid() + DELIMITER + car.getBrand().toString() + DELIMITER + car.getClassType().name()
                + DELIMITER + car.getBodyType().toString() + DELIMITER + car.getFuelType().name() + DELIMITER
                + car.getTransmission().name() + DELIMITER + car.getBhp() + DELIMITER + car.getEngineCapacity()
                + DELIMITER + car.getYearOfProduction();
    }
}
