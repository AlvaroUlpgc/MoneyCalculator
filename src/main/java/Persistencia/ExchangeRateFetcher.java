package Persistencia;

import Modelo.ExchangeRate;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRateFetcher implements ExchangeRateLoader {
    private final String apiDir = "https://api.exchangeratesapi.io/latest?";

    @Override
    public void getRate (ExchangeRate exangeRate) {

        try {
            URL url = new URL (apiDir+"symbols="+exangeRate.getTo()+"&base="+exangeRate.getFrom());
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            exangeRate.setRate(processJson(reader.readLine()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private double processJson (String json) {
        return Double.parseDouble(json.substring(json.indexOf(":{")+8,json.indexOf("}")));
    }
}