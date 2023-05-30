package unit;

import magnitude.Weight;

public class Newtons extends Weight{
    public Newtons(){
        super();
    }
    public Newtons(double valor){
        super(valor);
    }

    @Override
    public double convGrams() {
        return (convKGrams() * 1000);
    }

    @Override
    public double convKGrams() {
        return valor / 9.80665;
    }

    @Override
    public double convNewton() {
        return (valor);
    }

    @Override
    public double convOunce() {
        return (convKGrams() / 0.02835);
    }

    @Override
    public double convPounds() {
        return (convKGrams() * 2.20462262);
    }

    @Override
    public double convStone() {
        return (convKGrams() / 6.35029318);
    }

    @Override
    public double convTon() {
        return (convKGrams() * 0.001);
    }

    @Override
    public double convmiliGrams() {
        return (convKGrams() * 1000000);
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
