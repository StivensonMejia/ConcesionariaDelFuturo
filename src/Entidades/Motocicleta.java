package Entidades;
import Enums.TipoDeMotor;

import java.util.Scanner;

public class Motocicleta extends Vehiculo {
    private TipoDeMotor tipoDeMotor;
    Scanner motoScanner = new Scanner(System.in);

    public Motocicleta() {

    }

    @Override
    public void calcularImpuestos() {
        double valorImpuesto = 0.0;
        switch (tipoDeMotor) {
            case MOTOR2T -> valorImpuesto = getPrecio() * 0.03;
            case MOTOR4T -> valorImpuesto = getPrecio() * 0.04;
        }
        setPrecioConimpuesto(valorImpuesto);
        setTotal(getPrecio() + valorImpuesto);
    }

    @Override
    public void imprimirInformacion(int infoAd) {
        System.out.println(Propiedades.AMARILLO + "[MOTOCICLETA]" + Propiedades.RESET);
        System.out.print(String.format(" Marca: %s | ", getMarca()));
        System.out.print(String.format(" Modelo: %s | ", getModelo()));
        System.out.print(String.format(" Año: %s | ", getAnio()));
        System.out.println(String.format(" Tipo de motor : %s ", tipoDeMotor));
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
        System.out.println("Seleccione el tipo de Motor del Vehiculo:");
        System.out.println("1: MOTOR 2Timepos");
        System.out.println("2: MOTOR 4Tiempos");
        System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
        while (!motoScanner.hasNextInt()){
            System.out.println(Propiedades.ROJO + "Dato invalido, Ingrese un numero entero." + Propiedades.RESET);
            System.out.print(Propiedades.AZUL + "Digite una opcion : " + Propiedades.RESET);
            motoScanner.next();
        }
        switch (motoScanner.nextInt()) {
            case 1 -> this.tipoDeMotor = TipoDeMotor.MOTOR2T;
            case 2 -> this.tipoDeMotor = TipoDeMotor.MOTOR4T;
            default -> {
                System.out.println(Propiedades.ROJO +"la opcion seleccionada NO EXISTE" + Propiedades.RESET);
                metodoEspecial();
            }
        }
    }

    public TipoDeMotor getTipoDeMotor() {
        return tipoDeMotor;
    }
}
