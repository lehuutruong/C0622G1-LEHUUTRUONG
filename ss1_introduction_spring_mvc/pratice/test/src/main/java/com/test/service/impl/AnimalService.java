package com.test.service.impl;

import com.test.model.Animal;
import com.test.repository.impl.AnimalRepository;
import com.test.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimalService  implements IAnimalService {
  @Autowired
  AnimalRepository animalRepository;
    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }
}
