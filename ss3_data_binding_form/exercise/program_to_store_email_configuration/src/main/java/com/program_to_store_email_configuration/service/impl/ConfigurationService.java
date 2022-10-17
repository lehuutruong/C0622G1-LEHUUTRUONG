package com.program_to_store_email_configuration.service.impl;
import com.program_to_store_email_configuration.repository.IConfigurationRepository;
import com.program_to_store_email_configuration.service.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService implements IConfigurationService {
    @Autowired
    private IConfigurationRepository configurationRepository;

    @Override
    public List<String> languageList() {
        return configurationRepository.languageList();
    }

    @Override
    public List<String> sizeList() {
        return configurationRepository.sizeList();
    }
}
