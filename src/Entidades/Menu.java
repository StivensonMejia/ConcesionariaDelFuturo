package Entidades;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner userScanner = new Scanner(System.in); //invocar Scaner

    private static final Menu menuInstance = new Menu();//crear instancia del menu
    private Menu() {
    } // constructor de la clase
    private Concesionaria concesionariaDelFuturo = Concesionaria.getConcesionaria();
    ArrayList<Vehiculo> listaVehiculos = concesionariaDelFuturo.getListaDeVehiculos();
    ArrayList<Vehiculo> listaVehiculosVendidos = concesionariaDelFuturo.getVehiculosVendidos();

    public void menuConcesionario() {
        System.out.println();
        System.out.println(Propiedades.AMARILLO + "Bienvenido a la concesionaria del futuro" + Propiedades.RESET);
        System.out.println();
        System.out.println("1. Ingresar un vehículo");
        System.out.println("2. Mostar invetario");
        System.out.println("3. Buscar vehículo por marca");
        System.out.println("4. Simular Venta");
        System.out.println("5. Salir");

        int numero = 0;
        System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
        while (numero < 1 || numero > 5) {
            while (!userScanner.hasNextInt()){
                System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
                System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
                userScanner.next();
            }
            numero = userScanner.nextInt();
            if (numero < 1 || numero > 5) {
                System.out.println(Propiedades.ROJO + "Numero no disponible." + Propiedades.RESET);
                System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
            } else {
                switch (numero) {
                    case 1 -> seleccionarTipoVehiculo();
                    case 2 -> mostrarInventario();
                    case 3 -> menuBuscarVehiculo();
                    case 4 -> menuVenderVehiculo();
                    case 5 -> salir();
                }
            }

        }
    }

    public void seleccionarTipoVehiculo() {
        System.out.println();
        System.out.println();
        System.out.println(Propiedades.AMARILLO + "MENU PARA INGRESAR UN VEHÍCULO" + Propiedades.RESET);
        System.out.println();
        userScanner.nextLine();

        System.out.println("1. Ingresar un Automovil");
        System.out.println("2. Ingresar una Motocicleta");
        System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
        while (!userScanner.hasNextInt()){
            System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
            System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
            userScanner.next();
        }
        switch (userScanner.nextInt()) {
            case 1 -> ingresarVehiculo(concesionariaDelFuturo.crearVehiculo(1));
            case 2 -> ingresarVehiculo(concesionariaDelFuturo.crearVehiculo(2));
            default -> {
                System.out.println();
                System.out.println(Propiedades.ROJO + "Opcion no valida" + Propiedades.RESET);
                seleccionarTipoVehiculo();
            }
        }
    }
    public void ingresarVehiculo(Vehiculo vehiculo) {
        userScanner.nextLine();
        System.out.println();
        System.out.print(Propiedades.AZUL + "Ingrese la marca del Vehiculo : " + Propiedades.RESET);
        vehiculo.setMarca(userScanner.nextLine().toUpperCase());

        System.out.print(Propiedades.AZUL + "Ingrese el modelo del Vehiculo : " + Propiedades.RESET);
        vehiculo.setModelo(userScanner.nextLine().toUpperCase());

        System.out.print(Propiedades.AZUL +"Ingrese el año del Vehiculo : " + Propiedades.RESET);
        while (!userScanner.hasNextInt()) {
            System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
            System.out.print(Propiedades.AZUL +"Ingrese el año del Vehiculo : " + Propiedades.RESET);
            userScanner.next();
        }
        vehiculo.setAnio(userScanner.nextInt());

        System.out.print(Propiedades.AZUL + "Ingrese el precio del Vehiculo : " + Propiedades.RESET);
        while (!userScanner.hasNextInt()) {
            System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
            System.out.print(Propiedades.AZUL + "Ingrese el precio del Vehiculo : " + Propiedades.RESET);
            userScanner.next();
        }
        vehiculo.setPrecio(userScanner.nextInt());

        vehiculo.metodoEspecial();

        // Confirmación
        System.out.println();
        System.out.println(Propiedades.VERDE + "Vehículo ingresado con éxito:" + Propiedades.RESET);
        vehiculo.calcularImpuestos();
        concesionariaDelFuturo.getListaDeVehiculos().add(vehiculo);
        System.out.println();

        espaciosGrandesConsola();
        menuConcesionario();
    }

    public void mostrarInventario() {
        System.out.println();
        System.out.println(Propiedades.AMARILLO + "LISTA DE VEHICULOS DISPONIBE" + Propiedades.RESET);
        System.out.println();
        if(listaVehiculos.isEmpty()) {
            listaVacia();
        } else {
            for(Vehiculo v : listaVehiculos) {
                v.imprimirInformacion(1);
            }
        }
        espaciosGrandesConsola();
        menuConcesionario();

    }
    public void listaVacia() {
        System.out.println(Propiedades.ROJO + "Lo sentimos no hay ningun vehiculo disponible" + Propiedades.RESET);
        espaciosGrandesConsola();
        menuConcesionario();
    }

    public void menuBuscarVehiculo(){
        System.out.println();
        System.out.println(Propiedades.AMARILLO + "BUSCAR POR MARCA" + Propiedades.RESET);
        System.out.println();
        if(listaVehiculos.isEmpty()) {
            listaVacia();
        }
        System.out.print(Propiedades.AZUL + "Porfavor digite la marca del vehiculo : " + Propiedades.RESET);
        userScanner.nextLine();
        buscarVehiculo(userScanner.nextLine());
    }
    public void buscarVehiculo(String userMarca) {
        boolean marcaencontrada = false;
        System.out.println();
        for (Vehiculo v : listaVehiculos) {
            if (v.getMarca().equals(userMarca.toUpperCase())) {
                v.imprimirInformacion(0);
                marcaencontrada = true;
            }
        }
        if (!marcaencontrada) {
            System.out.println(Propiedades.ROJO + "Marca no encontrada" + Propiedades.RESET);
        }
        espaciosGrandesConsola();
        menuConcesionario();
    }

    public void menuVenderVehiculo() {
        System.out.println();
        System.out.println(Propiedades.AMARILLO + "VENDER VEHICULO" + Propiedades.RESET);
        System.out.println();
        userScanner.nextLine();
        System.out.print(Propiedades.AZUL + "Digite la marca del vehiculo : " + Propiedades.RESET);
        String userMarca = userScanner.nextLine();
        System.out.print(Propiedades.AZUL + "Digite el modelo del vehiculo : " + Propiedades.RESET);
        String userModelo = userScanner.nextLine();
        System.out.println();

        verVehiculo(userMarca, userModelo, false);

        System.out.println("¿Desea Vender el vehículo?");
        System.out.print("Escriba :" + Propiedades.VERDE + " SI " + Propiedades.RESET);
        System.out.println("Escriba :" + Propiedades.ROJO + " NO" + Propiedades.RESET);
        System.out.print(Propiedades.AZUL + "su respuesta: " + Propiedades.RESET);

        String option = userScanner.nextLine().toUpperCase();
        boolean esCorrecto = false;

        while (!esCorrecto) {
            if (option.equals("SI")) {
                System.out.println(Propiedades.VERDE + "Venta Exitosa" + Propiedades.RESET);
                verVehiculo(userMarca, userModelo,true);
                esCorrecto = true;
            } else if(option.equals("NO")) {
                System.out.println(Propiedades.VERDE + "No se realizo la venta" + Propiedades.RESET);
                esCorrecto = true;
            } else {
                System.out.println(Propiedades.ROJO + "Opcion no reconocida" + Propiedades.RESET);
                System.out.print(Propiedades.AZUL + "su respuesta: " + Propiedades.RESET);
                option = userScanner.nextLine().toUpperCase();
            }
        }
        espaciosGrandesConsola();
        menuConcesionario();
    }
    public void verVehiculo(String marca, String modelo, boolean venta) {
        for (Vehiculo v : listaVehiculos) {

            boolean equalsMarca = marca.toUpperCase().equals(v.getMarca());
            boolean equalsModelo = modelo.toUpperCase().equals(v.getModelo());

            if (equalsMarca && equalsModelo) {
                v.imprimirInformacion(0);
                System.out.println();
                if (venta) {
                    venderVehiculo(v);
                }
                break;
            } else {
                System.out.println(Propiedades.ROJO + "No se encontraron coincidencias" + Propiedades.RESET);
                espaciosGrandesConsola();
                menuConcesionario();
            }
        }
    }
    public void venderVehiculo(Vehiculo vehiculo) {
        listaVehiculosVendidos.add(vehiculo);
        listaVehiculos.remove(vehiculo);
    }

    public void salir(){
        System.out.println();
        System.out.println(Propiedades.VERDE +"GRACIAS POR SU VISITA" + Propiedades.RESET);
        userScanner.close();
        System.exit(0);
    }
    public void espaciosGrandesConsola() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static Menu getMenuInstance() {
        return menuInstance;
    }
}
