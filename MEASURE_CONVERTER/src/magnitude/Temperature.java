package magnitude;

public abstract class Temperature implements Measure{
    protected double valor;

    public Temperature(){
        this.valor = 0;
    }

    public Temperature(double valor){
    this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract double convKelvin();
    public abstract double convCelsius();
    public abstract double convFahrenheit();

}
