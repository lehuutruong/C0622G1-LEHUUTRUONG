package com.check_mail.service.impl;

import com.check_mail.service.ICheckMailService;
import org.springframework.stereotype.Service;

@Service
public class CheckMailService implements ICheckMailService {
    @Override
    public String checkMail(String email) {
        String regex ="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if(email.matches(regex)){
            return "email is right format";
        }
        return "email is not right format";
    }
}
