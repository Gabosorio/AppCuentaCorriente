package cuentas;

public class Movimientos extends Transaccion {

    private String movimiento;

    public Movimientos(String movimiento, Integer monto, String fecha) {
        super(monto, fecha);
        this.movimiento = movimiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    @Override
    public String toString() {
        return "Movimiento: " + movimiento +
                ", Monto: " + getMonto() +
                ", Fecha: " + getFecha();
    }
}