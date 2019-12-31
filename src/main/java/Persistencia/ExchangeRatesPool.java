package Persistencia;

import Modelo.Currency;
import Modelo.ExchangeRate;

import java.util.LinkedList;
import java.util.List;

public class ExchangeRatesPool {
    List<ExchangeRateLoader> loaders = new LinkedList<>();
    public ExchangeRatesPool () {
        loaders.add(new ExchangeRateFetcher());
    }
    public ExchangeRate get (Currency from, Currency to) {
        ExchangeRate exangeRate = new ExchangeRate(from,to);
        for (ExchangeRateLoader loader : loaders) {
            try {
                 loader.getRate(exangeRate);
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        return exangeRate;
    }
}