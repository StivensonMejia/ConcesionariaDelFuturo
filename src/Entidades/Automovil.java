package Entidades;

import java.util.Scanner;

public class Automovil extends Vehiculo {
    private int numPuertas;
    Scanner autoScanner = new Scanner(System.in);

    public Automovil() {

    }

    @Override
    public void calcularImpuestos() {
        int precio = getPrecio();
        double valorImpuesto = precio*0.05;

        setPrecioConimpuesto(valorImpuesto);
        setTotal(getPrecio() + valorImpuesto);
    }

    @Override
    public void imprimirInformacion(int infoAd) {
        System.out.println(Propiedades.AMARILLO + "[AUTOMOVIL]" + Propiedades.RESET);
        System.out.print(String.format(" Marca: %s | ", getMarca()));
        System.out.print(String.format(" Modelo: %s | ", getModelo()));
        System.out.print(String.format(" Ano: %s | ", getAnio()));
        System.out.println(String.format(" Numero de puertas: %s ", numPuertas));
        if(infoAd > 0) {
            imprimirInformacionAd();
        }
        System.out.println(String.format(Propiedades.VERDE + " Total: %s ", Propiedades.formato.format(getTotal())) + Propiedades.RESET);
    }

    @Override
    public void imprimirInformacionAd() {
        System.out.println(String.format(" Precio: %s ", Propiedades.formato.format(getTotal())));
        System.out.println(String.format(" Impuestos: %s ", Propiedades.formato.format(getTotal())));
    }

    @Override
    public void metodoEspecial() {
        System.out.println();
        System.out.println("Ingrese el numero de puertas del Vehiculo.");
        System.out.print(Propiedades.AZUL + "en un rango de 1 a 6 puertas : " + Propiedades.RESET);
        int numero = 0;
        while (numero < 1 || numero > 6) {
            while(!autoScanner.hasNextInt()) {
                System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
                System.out.println("Ingrese el numero de puertas del Vehiculo.");
                System.out.print(Propiedades.AZUL + "Con maximo de 6 puertas: " + Propiedades.RESET);
                autoScanner.next();
            }
            numero = autoScanner.nextInt();
            if (numero < 1 || numero > 6) {
                System.out.println(Propiedades.ROJO + "Numero de puertas NO VALIDO." + Propiedades.RESET);
                System.out.println("Ingrese el numero de puertas del Vehiculo.");
                System.out.print(Propiedades.AZUL + "Con maximo de 6 puertas: " + Propiedades.RESET);
            } else {
                break;
            }
        }
        setNumPuertas(numero);
    }


    // GETTERS Y SETTERS
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
