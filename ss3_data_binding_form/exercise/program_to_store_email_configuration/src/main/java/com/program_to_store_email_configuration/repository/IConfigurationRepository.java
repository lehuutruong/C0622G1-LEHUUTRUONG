package com.program_to_store_email_configuration.repository;
import java.util.List;

public interface IConfigurationRepository {
    List<String> languageList();
    List<String> sizeList();
}
