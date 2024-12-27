package Entidades;
import java.util.ArrayList;

public class Concesionaria {

    private static final Concesionaria instance = new Concesionaria();
    private Concesionaria() {
        // Constructor privado para evitar instanciación directa
    }
    public static Concesionaria getConcesionaria() {
        return instance;
    }

    private Vehiculo newVehiculo;
    private ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private ArrayList<Vehiculo> vehiculosVendidos = new ArrayList<>();


    public Vehiculo crearVehiculo(int x) {
        switch (x) {
            case 1 -> {
                Vehiculo newVehiculo = new Automovil();
                return newVehiculo;
            }
            case 2 -> {
                Vehiculo newVehiculo = new Motocicleta();
                return newVehiculo;
            }
            /*case 3 -> {
                Vehiculo newVehiculo = new Camion();
                return newVehiculo;
            }*/
            default -> {
                return null;
            }
        }
    }
    public void calculoDeImpuestos(Vehiculo vehiculo) {
        int precio = vehiculo.getPrecio();
        double precioConImpuesto = 0.0;
        double total = 0.0;
        if(vehiculo instanceof Automovil) {
            precioConImpuesto = precio*0.05;
            total = precioConImpuesto + precio;
        } else if (vehiculo instanceof Motocicleta) {
            switch (((Motocicleta) vehiculo).getTipoDeMotor()) {
                case MOTOR2T -> {
                    precioConImpuesto = precio*0.03;
                }
                case MOTOR4T -> {
                    precioConImpuesto = precio*0.04;
                }
            }
            total = precioConImpuesto + precio;
        }
        vehiculo.setPrecioConimpuesto(precioConImpuesto);
        vehiculo.setTotal(total);
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }
    public ArrayList<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }
    public Vehiculo getNewVehiculo() {
        return newVehiculo;
    }
}
