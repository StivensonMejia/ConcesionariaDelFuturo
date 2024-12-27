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
    public void calcularImpuestos(Vehiculo vehiculo) {
        vehiculo.calcularImpuestos();
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
