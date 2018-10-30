package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CarModelRepository repository;

    @Override
    public void run(String... strings) throws Exception{

        CarModel car = new CarModel(2014,"Suzuki","Wagon-R");
        repository.save(car);

         car = new CarModel(2018,"Honda","CH-R");
        repository.save(car);

        car = new CarModel(2016,"Toyota Corolla","Camry");
        repository.save(car);
    }
}
