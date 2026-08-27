package cuentas;

public class Transaccion {

    private Integer monto;
    private String fecha;

    public Transaccion(Integer monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }
}
