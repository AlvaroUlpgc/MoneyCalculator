package Persistencia;

import Modelo.ExchangeRate;
import java.io.IOException;

public interface ExchangeRateLoader {
    
    public void getRate (ExchangeRate exangeRate) throws IOException;
}