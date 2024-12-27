package Entidades;

public class Automovil extends Vehiculo {
    private int numPuertas;

    public Automovil() {

    }

    @Override
    public void calcularImpuestos() {
        int precio = getPrecio();
        double valorImpuesto = precio*0.05;

        setPrecioConimpuesto(valorImpuesto);
        setTotal(getPrecio() + valorImpuesto);
    }

    // GETTERS Y SETTERS
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
