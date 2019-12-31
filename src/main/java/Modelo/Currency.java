package Modelo;


public class Currency {
    private final String code;
    private final String name;

    public Currency (String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString () {
        return this.name;
    }
    public String getCode() {
        return code;
    }
}