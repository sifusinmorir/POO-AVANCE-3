package unit;

import magnitude.Temperature;

public class Kelvin extends Temperature {
   
    public Kelvin(){
        super();
    }
    public Kelvin(double valor){
        super(valor);
    }

    @Override
    public double convCelsius() {
        return valor - 273.15;
    }

    @Override
    public double convFahrenheit() {
        return (9*(valor - 273.15))/5 + 32;    
    }

    @Override
    public double convKelvin() {
        return valor;
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
