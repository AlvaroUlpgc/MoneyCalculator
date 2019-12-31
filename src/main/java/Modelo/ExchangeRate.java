package Modelo;

public class ExchangeRate {
    double rate;
    Currency from;
    Currency to;


    public ExchangeRate (Currency from, Currency to) {
        this.from = from;
        this.to = to;
    }
    public void setRate(double in) {
        rate = in;
    }

    public double getRate () {
        return rate;
    }

    public String getTo() {
        return to.getCode();
    }

    public String getFrom () {
        return from.getCode();
    }
}