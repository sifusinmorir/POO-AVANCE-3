package unit;

import magnitude.Temperature;

public class Fahrenheit extends Temperature {

    public Fahrenheit(){
        super();
    }
    public Fahrenheit(double valor){
        super(valor);
    }

    @Override
    public double convCelsius() {
        return (5*(valor - 32)/9);
    }

    @Override
    public double convFahrenheit() {
        return valor;
    }

    @Override
    public double convKelvin() {
        return (5*(valor - 32)/9) + 273.15;
    }
    @Override
    public double convertir(String unidadDestino) {
        switch (unidadDestino) {
            case "C":
                return convCelsius();
            case "F":
                return convFahrenheit();
            case "K":
                return convKelvin();
            default:
                throw new IllegalArgumentException("Unidad de temperatura no válida: " + unidadDestino);
        }
    }
}
