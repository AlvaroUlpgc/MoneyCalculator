package Persistencia;

import Modelo.Currency;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileCurrencySetLoader implements CurrencySetLoader {
    
    private File file;
    
    @Override
    public List<Currency> loadCurrencies() {
        List<Currency> result = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String [] temp = line.split(":");
                result.add(new Currency(temp[0].replaceAll("\"", ""), temp[1].replaceAll("\"", "")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return result;
    }

    public FileCurrencySetLoader () {
        file = new File("Currencies.txt");
    }
}