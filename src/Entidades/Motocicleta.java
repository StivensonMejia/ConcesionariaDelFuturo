package Entidades;
import Enums.TipoDeMotor;

public class Motocicleta extends Vehiculo {
    private TipoDeMotor tipoDeMotor;

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

    public TipoDeMotor getTipoDeMotor() {
        return tipoDeMotor;
    }

    public void setTipoDeMotor2T() {
        this.tipoDeMotor = TipoDeMotor.MOTOR2T;
    }

    public void setTipoDeMotor4T() {
        this.tipoDeMotor = TipoDeMotor.MOTOR4T;
    }
}
