package currency_converter_app.service.impl;

import currency_converter_app.service.ICurrencyConverterApp;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterAppService implements ICurrencyConverterApp {

    @Override
    public double changeMoney(double vnd, double rate) {
        return vnd/rate;
    }
}
