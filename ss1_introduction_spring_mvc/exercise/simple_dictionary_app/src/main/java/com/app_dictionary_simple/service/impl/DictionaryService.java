package com.app_dictionary_simple.service.impl;

import com.app_dictionary_simple.repository.impl.DictionaryRepository;
import com.app_dictionary_simple.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService  implements IDictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Override
    public String dictionary(String english) {
        return dictionaryRepository.dictionary(english);
    }
}
