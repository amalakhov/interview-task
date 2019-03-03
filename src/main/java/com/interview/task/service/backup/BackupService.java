package com.interview.task.service.backup;

import com.interview.task.domain.Car;

import java.nio.file.Path;
import java.util.Collection;

public interface BackupService {
    boolean store(Collection<Car> cars, Path path);
    Collection<Car> restore(Path path);
}
