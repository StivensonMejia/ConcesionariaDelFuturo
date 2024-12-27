package Entidades;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    //colores personalizados
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";

    DecimalFormat formato = new DecimalFormat("#,###");
    Scanner userScanner = new Scanner(System.in); //invocar Scaner

    private static final Menu menuInstance = new Menu();//crear instancia del menu
    private Menu() {
    } // constructor de la clase
    private Concesionaria concesionariaDelFuturo = Concesionaria.getConcesionaria();
    ArrayList<Vehiculo> listaVehiculos = concesionariaDelFuturo.getListaDeVehiculos();
    ArrayList<Vehiculo> listaVehiculosVendidos = concesionariaDelFuturo.getVehiculosVendidos();

    public void menuConcesionario() {
        System.out.println();
        System.out.println(AMARILLO + "Bienvenido a la concesionaria del futuro" + RESET);
        System.out.println();
        System.out.println("1. Ingresar un vehículo");
        System.out.println("2. Mostar invetario");
        System.out.println("3. Buscar vehículo por marca");
        System.out.println("4. Simular Venta");
        System.out.println("5. Salir");

        int numero = 0;
        System.out.print(AZUL + "Digite una opcion : " + RESET);
        while (numero < 1 || numero > 5) {
            while (!userScanner.hasNextInt()){
                System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
                System.out.print(AZUL + "Digite una opcion : " + RESET);
                userScanner.next();
            }
            numero = userScanner.nextInt();
            if (numero < 1 || numero > 5) {
                System.out.println(ROJO + "Numero no disponible." + RESET);
                System.out.print(AZUL + "Digite una opcion : " + RESET);
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
        System.out.println(AMARILLO + "MENU PARA INGRESAR UN VEHÍCULO" + RESET);
        System.out.println();
        userScanner.nextLine();

        System.out.println("1. Ingresar un Automovil");
        System.out.println("2. Ingresar una Motocicleta");
        System.out.print(AZUL + "Digite una opcion : " + RESET);
        while (!userScanner.hasNextInt()){
            System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
            System.out.print(AZUL + "Digite una opcion : " + RESET);
            userScanner.next();
        }
        switch (userScanner.nextInt()) {
            case 1 -> ingresarVehiculo(concesionariaDelFuturo.crearVehiculo(1));
            case 2 -> ingresarVehiculo(concesionariaDelFuturo.crearVehiculo(2));
            default -> {
                System.out.println();
                System.out.println(ROJO + "Opcion no valida" + RESET);
                seleccionarTipoVehiculo();
            }
        }
    }
    public void ingresarVehiculo(Vehiculo vehiculo) {
        userScanner.nextLine();
        System.out.println();
        System.out.print(AZUL + "Ingrese la marca del Vehiculo : " + RESET);
        vehiculo.setMarca(userScanner.nextLine().toUpperCase());

        System.out.print(AZUL + "Ingrese el modelo del Vehiculo : " + RESET);
        vehiculo.setModelo(userScanner.nextLine().toUpperCase());

        System.out.print(AZUL +"Ingrese el año del Vehiculo : " + RESET);
        while (!userScanner.hasNextInt()) {
            System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
            System.out.print(AZUL +"Ingrese el año del Vehiculo : " + RESET);
            userScanner.next();
        }
        vehiculo.setAnio(userScanner.nextInt());

        System.out.print(AZUL + "Ingrese el precio del Vehiculo : " + RESET);
        while (!userScanner.hasNextInt()) {
            System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
            System.out.print(AZUL + "Ingrese el precio del Vehiculo : " + RESET);
            userScanner.next();
        }
        vehiculo.setPrecio(userScanner.nextInt());

        if (vehiculo instanceof Automovil) {
            numPuertasParaAuto(vehiculo);
        } else if (vehiculo instanceof Motocicleta) {
            tipoDeMotorParaMoto(vehiculo);
        }
        // Confirmación
        System.out.println();
        System.out.println(VERDE + "Vehículo ingresado con éxito:" + RESET);
        concesionariaDelFuturo.calcularImpuestos(vehiculo);
        concesionariaDelFuturo.getListaDeVehiculos().add(vehiculo);
        System.out.println();

        espaciosGrandesConsola();
        menuConcesionario();
    }
    public void numPuertasParaAuto(Vehiculo vehiculo) {
        System.out.println();
        System.out.println("Ingrese el numero de puertas del Vehiculo.");
        System.out.print(AZUL + "en un rango de 1 a 6 puertas : " + RESET);
        int numero = 0;
        while (numero < 1 || numero > 6) {
            while(!userScanner.hasNextInt()) {
                System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
                System.out.println("Ingrese el numero de puertas del Vehiculo.");
                System.out.print(AZUL + "Con maximo de 6 puertas: " + RESET);
                userScanner.next();
            }
            numero = userScanner.nextInt();
            if (numero < 1 || numero > 6) {
                System.out.println(ROJO + "Numero de puertas NO VALIDO." + RESET);
                System.out.println("Ingrese el numero de puertas del Vehiculo.");
                System.out.print(AZUL + "Con maximo de 6 puertas: " + RESET);
            } else {
                break;
            }
        }
        ((Automovil) vehiculo).setNumPuertas(numero);
    }
    public void tipoDeMotorParaMoto(Vehiculo vehiculo) {
        System.out.println();
        System.out.println("Seleccione el tipo de Motor del Vehiculo:");
        System.out.println("1: MOTOR 2Timepos");
        System.out.println("2: MOTOR 4Tiempos");
        System.out.print(AZUL + "Digite una opcion : " + RESET);
        while (!userScanner.hasNextInt()){
            System.out.println(ROJO + "Dato invalido, Ingrese un numero entero." + RESET);
            System.out.print(AZUL + "Digite una opcion : " + RESET);
            userScanner.next();
        }
        switch (userScanner.nextInt()) {
            case 1 -> ((Motocicleta) vehiculo).setTipoDeMotor2T();
            case 2 -> ((Motocicleta) vehiculo).setTipoDeMotor4T();
            default -> {
                System.out.println(ROJO +"la opcion seleccionada NO EXISTE" + RESET);
                tipoDeMotorParaMoto(vehiculo);
            }
        }
    }

    public void mostrarInventario() {
        System.out.println();
        System.out.println(AMARILLO + "LISTA DE VEHICULOS DISPONIBE" + RESET);
        System.out.println();
        if(listaVehiculos.isEmpty()) {
            listaVacia();
        } else {
            for(Vehiculo v : listaVehiculos) {
                if (v instanceof Automovil) {
                    System.out.println(AMARILLO + "AUTOMOVIL" + RESET);
                    System.out.println(String.format("Numero de puertas: %s", ((Automovil) v).getNumPuertas()));
                } else if (v instanceof Motocicleta) {
                    System.out.println(AMARILLO + "MOTOCICLETA" + RESET);
                    System.out.println(String.format("Tiopo de motor: %s", ((Motocicleta) v).getTipoDeMotor()));
                }
                System.out.println(String.format("Marca: %s", v.getMarca()));
                System.out.println(String.format("Modelo: %s", v.getModelo()));
                System.out.println(String.format("Año: %s", v.getAnio()));
                System.out.println();
                System.out.println(String.format("Precio: $%s", formato.format(v.getPrecio())));
                System.out.println(String.format("Impuesto: $%s", formato.format(v.getPrecioConimpuesto())));
                System.out.print(VERDE);
                System.out.println(String.format("Total: $%s", formato.format(v.getTotal())));
                System.out.println(RESET);
            }
        }
        espaciosGrandesConsola();
        menuConcesionario();

    }
    public void listaVacia() {
        System.out.println(ROJO + "Lo sentimos no hay ningun vehiculo disponible" + RESET);
        espaciosGrandesConsola();
        menuConcesionario();
    }

    public void menuBuscarVehiculo(){
        System.out.println();
        System.out.println(AMARILLO + "BUSCAR POR MARCA" + RESET);
        System.out.println();
        if(listaVehiculos.isEmpty()) {
            listaVacia();
        }
        System.out.print(AZUL + "Porfavor digite la marca del vehiculo : " + RESET);
        userScanner.nextLine();
        buscarVehiculo(userScanner.nextLine());
    }
    public void buscarVehiculo(String userMarca) {
        boolean marcaencontrada = false;
        System.out.println();
        for (Vehiculo v : listaVehiculos) {
            if (v.getMarca().equals(userMarca.toUpperCase())) {
                if (v instanceof Automovil) {
                    System.out.print(AMARILLO + "[AUTOMOVIL] | " + RESET);
                } else if (v instanceof Motocicleta) {
                    System.out.print(AMARILLO + "[MOTOCICLETA] | " + RESET);
                }
                System.out.print( String.format(" Marca: %s ", v.getMarca()));
                System.out.print(String.format(" Modelo: %s ", v.getModelo()));
                System.out.print(String.format(" Año: %s ", v.getAnio()));
                System.out.println(String.format(" Precio: %s ", formato.format(v.getTotal())));
                marcaencontrada = true;
            }
        }
        if (!marcaencontrada) {
            System.out.println(ROJO + "Marca no encontrada" + RESET);
        }
        espaciosGrandesConsola();
        menuConcesionario();
    }

    public void menuVenderVehiculo() {
        System.out.println();
        System.out.println(AMARILLO + "VENDER VEHICULO" + RESET);
        System.out.println();
        userScanner.nextLine();
        System.out.print(AZUL + "Digite la marca del vehiculo : " + RESET);
        String userMarca = userScanner.nextLine();
        System.out.print(AZUL + "Digite el modelo del vehiculo : " + RESET);
        String userModelo = userScanner.nextLine();
        System.out.println();

        verVehiculo(userMarca, userModelo, false);

        System.out.println("¿Desea Vender el vehículo?");
        System.out.print("Escriba :" + VERDE + " SI " + RESET);
        System.out.println("Escriba :" + ROJO + " NO" + RESET);
        System.out.print(AZUL + "su respuesta: " + RESET);

        String option = userScanner.nextLine().toUpperCase();
        boolean esCorrecto = false;

        while (!esCorrecto) {
            if (option.equals("SI")) {
                System.out.println(VERDE + "Venta Exitosa" + RESET);
                verVehiculo(userMarca, userModelo,true);
                esCorrecto = true;
            } else if(option.equals("NO")) {
                System.out.println(VERDE + "No se realizo la venta" + RESET);
                esCorrecto = true;
            } else {
                System.out.println(ROJO + "Opcion no reconocida" + RESET);
                System.out.print(AZUL + "su respuesta: " + RESET);
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
                System.out.print(String.format(" Marca: %s ", v.getMarca()));
                System.out.print(String.format(" Modelo: %s ", v.getModelo()));
                System.out.print(String.format(" Año: %s ", v.getAnio()));
                System.out.println(String.format(" Precio: %s ", formato.format(v.getTotal())));
                System.out.println();
                if (venta) {
                    venderVehiculo(v);
                }
                break;
            } else {
                System.out.println(ROJO + "No se encontraron coincidencias" + RESET);
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
        System.out.println(VERDE +"GRACIAS POR SU VISITA" +RESET);
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
