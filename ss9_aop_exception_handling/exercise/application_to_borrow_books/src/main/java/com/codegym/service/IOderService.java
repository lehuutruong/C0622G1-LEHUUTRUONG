package com.codegym.service;

import com.codegym.model.Oder;

import java.util.List;

public interface IOderService {
    List<Oder> findAll();

    Oder findById(int id);

    void save(Oder oder);
}
