package Entidades;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;

    private int precio;



    private double precioConimpuesto;
    private double total;

    public Vehiculo() {

    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setPrecioConimpuesto(double precioConimpuesto) {
        this.precioConimpuesto = precioConimpuesto;
    }



    public void setTotal(double total) {
        this.total = total;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAnio() {
        return anio;
    }
    public int getPrecio(){
        return precio;
    }
    public double getPrecioConimpuesto() {
        return precioConimpuesto;
    }
    public double getTotal() {
        return total;
    }
}

