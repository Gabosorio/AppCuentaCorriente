package cuentas; // Indica que esta clase pertenece al paquete "cuentas".

import exceptions.MontoInvalidoException;
import java.time.LocalDate;
// Definición de la clase CuentaCorriente.
public class CuentaCorriente {
    private static final int MAX_MOVIMIENTOS = 10;
    // =========================
    // Atributos
    // =========================

    // Número único de la cuenta corriente.
    private Integer numero;

    // Nombre del titular de la cuenta.
    private String titular;

    // saldo disponible en la cuenta.
    private Integer saldo;
    private Integer saldoBase;

    // Arreglo que almacena los últimos 10 movimientos de la cuenta.
    private Movimientos[] movimientos;
    // Controla cuántos movimientos han sido registrados.
    private int cantidadMovimientos;

    // =========================
    // Constructores
    // =========================

    // Constructor que recibe número y titular.
    // Como el saldo es opcional, comienza en 0.
    public CuentaCorriente(Integer numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.saldoBase = 0;
        this.movimientos = new Movimientos[MAX_MOVIMIENTOS];
        this.cantidadMovimientos = 0;
    }

    // Constructor que recibe número, titular y saldo inicial.
    public CuentaCorriente(Integer numero, String titular, Integer saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.saldoBase = 0;
        this.movimientos = new Movimientos[MAX_MOVIMIENTOS];
        this.cantidadMovimientos = 0;

        if (saldo != null && saldo > 0) {
            registrarMovimiento("Saldo inicial", saldo);
            this.saldo = consultarBalance();
        }
    }


    // =========================
    // GETTERS
    // =========================

    // Devuelve el número de la cuenta.
    public Integer getNumero() {
        return numero;
    }

    // Devuelve el nombre del titular.
    public String getTitular() {
        return titular;
    }

    // Devuelve el saldo actual.
    public Integer getSaldo() {
        return saldo;
    }


    // =========================
    // SETTERS
    // =========================

    // Modifica el número de cuenta.
    // Solo acepta números mayores que cero.
    public void setNumero(Integer numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.err.println("El número de cuenta debe ser mayor que cero.");
        }
    }

    // Modifica el nombre del titular.
    // Verifica que no sea nulo ni esté vacío.
    public void setTitular(String titular) {
        if (titular != null && !titular.isBlank()) {
            this.titular = titular;
        } else {
            System.out.println("El titular no puede estar vacío.");
        }
    }

    // Modifica el saldo.
    // No permite valores negativos.
    public void setSaldo(Integer saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo no puede ser negativo.");
        }
    }


    // =========================
    // MÉTODO toString()
    // =========================

    // Devuelve una representación del objeto en formato texto.
    // Se ejecuta automáticamente al hacer:
    // System.out.println(cuenta);
    @Override
    public String toString() {
        return "Número: " + numero +
                ", Titular: " + titular +
                ", Saldo: " + consultarBalance();
    }
    // Registra un movimiento en el arreglo.
    // Si el arreglo está lleno, elimina el movimiento más antiguo
    // y conserva solo los últimos 10.
    private void registrarMovimiento(String tipoMovimiento, Integer monto) {
        String fecha = LocalDate.now().toString();

        if (cantidadMovimientos < movimientos.length) {
            movimientos[cantidadMovimientos] = new Movimientos(tipoMovimiento, monto, fecha);
            cantidadMovimientos++;
        } else {
            consolidarMovimiento(movimientos[0]);
            for (int i = 0; i < movimientos.length - 1; i++) {
                movimientos[i] = movimientos[i + 1];
            }
            movimientos[movimientos.length - 1] = new Movimientos(tipoMovimiento, monto, fecha);
        }
    }
    // =========================
    // MÉTODO ABONAR
    // =========================

    // Agrega dinero al saldo de la cuenta.
    // Solo acepta montos positivos.
    public void abonar(Integer valor) {
        if (valor <= 0) {
            throw new MontoInvalidoException("El monto a abonar debe ser mayor que cero.");
        }
        registrarMovimiento("Abono", valor);
        this.saldo = consultarBalance();
    }


    // =========================
    // MÉTODO CARGAR
    // =========================

    // Descuenta dinero del saldo de la cuenta.
    public void cargar(Integer valor) {
        // No permite cargar montos negativos ni cero
        if (valor <= 0) {
            throw new MontoInvalidoException("El monto a cargar debe ser mayor que cero.");
        }
        // Si existe saldo suficiente, realiza el descuento.
        else if (consultarBalance()-valor >= 0) {
            // Registra el cargo en el arreglo de movimientos.
            registrarMovimiento("Cargo", valor);
            this.saldo = consultarBalance();
        }
        // Si el retiro supera el saldo disponible,
        // el saldo queda en cero según el requerimiento.
        else {
            registrarMovimiento("Cargo", consultarBalance());
            this.saldo = consultarBalance();
        }
    }

    public void mostrarMovimientos() {
        System.out.println("=== MOVIMIENTOS DE LA CUENTA ===");
        if (cantidadMovimientos == 0) {
            System.out.println("No hay movimientos registrados.");
        } else {
            for (int i = 0; i < cantidadMovimientos; i++) {
                System.out.println(movimientos[i]);
            }
        }
    }

    // Devuelve el balance calculado desde saldoBase y el arreglo de movimientos.
    public Integer consultarBalance() {
        int balance = saldoBase;

        for (int i = 0; i < cantidadMovimientos; i++) {
            if (movimientos[i].getMovimiento().equals("Abono") ||
                    movimientos[i].getMovimiento().equals("Saldo inicial")) {
                balance += movimientos[i].getMonto();
            } else if (movimientos[i].getMovimiento().equals("Cargo")) {
                balance -= movimientos[i].getMonto();
            }
        }
        return balance;
    }
    private void consolidarMovimiento(Movimientos movimiento) {
        if (movimiento.getMovimiento().equals("Abono") ||
                movimiento.getMovimiento().equals("Saldo inicial")) {
            saldoBase += movimiento.getMonto();
        } else if (movimiento.getMovimiento().equals("Cargo")) {
            saldoBase -= movimiento.getMonto();
        }
    }
}