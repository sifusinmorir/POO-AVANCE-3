package magnitude;

public abstract class Weight implements Measure{
    protected double valor;
    public Weight(){
        this.valor = 0.0;
    }
    public Weight(double valor){
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public abstract double convGrams();
    public abstract double convKGrams();
    public abstract double convmiliGrams();
    public abstract double convTon();
    public abstract double convPounds(); 
    public abstract double convOunce();
    public abstract double convStone();
    public abstract double convNewton();
}
