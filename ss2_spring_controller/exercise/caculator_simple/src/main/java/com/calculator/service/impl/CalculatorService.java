package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(double parameterOne, double parameterTwo, String calculation) {
        if (calculation.equals("addition")){
            return String.valueOf(parameterOne + parameterTwo);
        }
        else if(calculation.equals("subtraction")){
            return String.valueOf(parameterOne - parameterTwo);
        }
        else if(calculation.equals("multiplication")){
            return String.valueOf(parameterOne * parameterTwo);
        }
        else if(calculation.equals("division")&& parameterTwo==0){
            return " not division by zero ";
        }
        return String.valueOf(parameterOne / parameterTwo);
    }
}
