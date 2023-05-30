package unit;

import magnitude.Weight;

public class Grams extends Weight{
    public Grams(){
        super();
    }
    public Grams(double valor){
        super(valor);
    }

    @Override
    public double convGrams() {
        return valor;
    }

    @Override
    public double convKGrams() {
        return (valor * 0.001);
    }

    @Override
    public double convNewton() {
        return (valor * 0.00980665);
    }

    @Override
    public double convOunce() {
        return (valor / 28.35);
    }

    @Override
    public double convPounds() {
        return (valor * 0.00220462262);
    }

    @Override
    public double convStone() {
        return (valor / 6350.29318);
    }

    @Override
    public double convTon() {
        return (valor * 0.000001);
    }

    @Override
    public double convmiliGrams() {
        return (valor * 1000);
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
