package Entidades;
import Enums.TipoDeMotor;

public class Motocicleta extends Vehiculo {
    private TipoDeMotor tipoDeMotor;

    public Motocicleta() {

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
