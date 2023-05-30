package unit;

import magnitude.Weight;

public class KiloGrams extends Weight{
    public KiloGrams(){
        super();
    }
    public KiloGrams(double valor){
        super(valor);
    }

    @Override
    public double convGrams() {
        return (valor * 1000);
    }

    @Override
    public double convKGrams() {
        return valor;
    }

    @Override
    public double convNewton() {
        return (valor * 9.80665);
    }

    @Override
    public double convOunce() {
        return (valor / 0.02835);
    }

    @Override
    public double convPounds() {
        return (valor * 2.20462262);
    }

    @Override
    public double convStone() {
        return (valor / 6.35029318);
    }

    @Override
    public double convTon() {
        return (valor * 0.001);
    }

    @Override
    public double convmiliGrams() {
        return (valor * 1000000);
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
