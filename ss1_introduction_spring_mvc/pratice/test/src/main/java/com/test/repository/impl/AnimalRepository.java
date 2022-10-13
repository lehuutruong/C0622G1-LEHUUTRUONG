package com.test.repository.impl;

import com.test.model.Animal;
import com.test.repository.IAnimalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AnimalRepository implements IAnimalRepository {
    private static List<Animal> animalList=new ArrayList<>();
    static {
        animalList.add(new Animal("cat",7,"black","male"));
        animalList.add(new Animal("cat",8,"blue","male"));
        animalList.add(new Animal("cat",9,"red","female"));
        animalList.add(new Animal("cat",7,"black","male"));
        animalList.add(new Animal("cat",9,"blue","male"));
        animalList.add(new Animal("cat",2,"black","female"));
        animalList.add(new Animal("cat",7,"black","male"));
    }
    @Override
    public List<Animal> findAll() {
        return animalList;
    }
}
