package com.interview.task.resource;

import com.interview.task.domain.Car;
import com.interview.task.service.CarsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarsResource {

    private final CarsHolder carsHolder;

    @Autowired
    public CarsResource(CarsHolder carsHolder) {
        this.carsHolder = carsHolder;
    }

    @GetMapping(path = "/cars/limit/{limit}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Car> getCars(@PathVariable("limit") Integer limit) {
        return carsHolder.get(limit);
    }

}
