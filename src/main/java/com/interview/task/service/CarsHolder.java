package com.interview.task.service;

import com.interview.task.domain.Car;
import com.interview.task.service.backup.BackupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsHolder {
    private static final Logger logger = LoggerFactory.getLogger(CarsHolder.class);
    private List<Car> cars;

    private final BackupService backupService;
    private final String backupPath;

    @Autowired
    public CarsHolder(BackupService backupService, @Value("${backup.path}") String backupPath) {
        this.backupService = backupService;
        this.backupPath = backupPath;
        this.cars = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        Collection<Car> cars = backupService.restore(Paths.get(backupPath));
        this.cars.addAll(cars);
        logger.info("init::cars initialized. cars size = {}", this.cars.size());
    }

    public List<Car> get(Integer limit) {
        return cars.stream().limit(limit).collect(Collectors.toList());
    }
}
