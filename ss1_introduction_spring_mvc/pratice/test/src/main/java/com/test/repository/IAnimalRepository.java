package com.test.repository;

import com.test.model.Animal;

import java.util.List;

public interface IAnimalRepository {
    List<Animal> findAll();
}
