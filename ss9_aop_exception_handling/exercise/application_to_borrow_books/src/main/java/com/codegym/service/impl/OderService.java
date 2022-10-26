package com.codegym.service.impl;

import com.codegym.model.Oder;
import com.codegym.repository.IOderRepository;
import com.codegym.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepository iOderRepository;

    @Override
    public List<Oder> findAll() {
        return iOderRepository.findAll();
    }

    @Override
    public Oder findById(int id) {
        Oder oder = iOderRepository.findById(id).orElse(new Oder());
        Optional<Oder> optionalOder = iOderRepository.findById(id);
        if ((optionalOder.isPresent())) {
            oder = optionalOder.get();
        }
        return oder;
    }

    @Override
    public void save(Oder oder) {
        iOderRepository.save(oder);
    }
}
