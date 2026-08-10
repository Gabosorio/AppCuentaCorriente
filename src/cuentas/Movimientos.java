package cuentas;

public class Movimientos {

    private String movimiento;
    private Integer monto;
    private String fecha;

    public Movimientos(String movimiento, Integer monto, String fecha) {
        this.movimiento = movimiento;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public Integer getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Movimiento: " + movimiento +
                ", Monto: " + monto +
                ", Fecha: " + fecha;
    }
}
