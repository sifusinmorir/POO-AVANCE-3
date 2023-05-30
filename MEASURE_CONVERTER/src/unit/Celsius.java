package unit;


//import java.lang.reflect.GenericSignatureFormatError;

import magnitude.Temperature;

public class Celsius extends Temperature {
    public Celsius(){
        super();
    }
    public Celsius(double valor){
        super(valor);
    }
    @Override
    public double convCelsius() {
        return valor;
    }

    @Override
    public double convFahrenheit() {
        return (9*valor)/5 + 32;
    }

    @Override
    public double convKelvin() {
        return valor + 273.15;
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
