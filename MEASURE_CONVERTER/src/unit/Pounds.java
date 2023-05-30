package unit;

import magnitude.Weight;

public class Pounds extends Weight{
    public Pounds(){
        super();
    }
    public Pounds(double valor){
        super(valor);
    }

    @Override
    public double convGrams() {
        return (valor * 453.59237);
    }

    @Override
    public double convKGrams() {
        return (valor * 0.45359237);
    }

    @Override
    public double convNewton() {
        return (convKGrams() * 9.80665);
    }

    @Override
    public double convOunce() {
        return (valor * 16);
    }

    @Override
    public double convPounds() {
        return (valor);
    }

    @Override
    public double convStone() {
        return (convKGrams() / 6.35029318);
    }

    @Override
    public double convTon() {
        return (valor * 0.00045359237);
    }

    @Override
    public double convmiliGrams() {
        return (valor * 453592.37);
    }
    @Override
    public double convertir(String unidadDestino) {
        switch (unidadDestino) {
            case "g":
                return convGrams();
            case "kg":
                return convKGrams();
            case "lb":
                return convPounds();
            case "N":
                return convNewton();
            case "t":
                return convTon();
            case "oz":
                return convOunce();
            case "mg":
                return convmiliGrams();
            default:
                throw new IllegalArgumentException("Unidad de temperatura no válida: " + unidadDestino);
        }
    }      
}
