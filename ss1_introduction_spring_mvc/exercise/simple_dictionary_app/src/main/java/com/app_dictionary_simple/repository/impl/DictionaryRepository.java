package com.app_dictionary_simple.repository.impl;

import com.app_dictionary_simple.model.Dictionary;
import com.app_dictionary_simple.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static List<Dictionary> dictionaries=new ArrayList<>();
    static {
        dictionaries.add(new Dictionary("cake", "banh"));
        dictionaries.add(new Dictionary("hello", "xin chao"));
        dictionaries.add(new Dictionary("cook", "nau"));
    }

    @Override
    public String dictionary(String english) {
        for (Dictionary item : dictionaries) {
            if (item.getEnglish().equals(english)) {
                return item.getVn();
            }
        }
        return "word is not have in dictionary";
    }

}


