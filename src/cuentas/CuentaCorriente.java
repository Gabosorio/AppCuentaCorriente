package cuentas; // Indica que esta clase pertenece al paquete "cuentas".

import java.time.LocalDate;
// Definición de la clase CuentaCorriente.
public class CuentaCorriente {

    // =========================
    // ATRIBUTOS
    // =========================

    // Número único de la cuenta corriente.
    private Integer numero;

    // Nombre del titular de la cuenta.
    private String titular;

    // Saldo disponible en la cuenta.
    private Integer saldo;
    // Arreglo que almacena los últimos 10 movimientos de la cuenta.
    private Movimientos[] movimientos;
    // Controla cuántos movimientos han sido registrados.
    private int cantidadMovimientos;

    // =========================
    // CONSTRUCTORES
    // =========================

    // Constructor que recibe número y titular.
    // Como el saldo es opcional, comienza en 0.
    public CuentaCorriente(Integer numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new Movimientos[10];
        this.cantidadMovimientos = 0;
    }

    // Constructor que recibe número, titular y saldo inicial.
    public CuentaCorriente(Integer numero, String titular, Integer saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.movimientos = new Movimientos[10];
        this.cantidadMovimientos = 0;
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
                ", Saldo: " + saldo;
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

        // Verifica que el monto sea válido.
        if (valor > 0) {

            // Suma el valor al saldo actual.
            this.saldo += valor;

            // Registra el abono en el arreglo de movimientos.
            registrarMovimiento("Abono", valor);

        } else {

            // Informa que el monto ingresado no es válido.
            System.out.println("El monto a abonar debe ser mayor que cero.");
        }
    }


    // =========================
    // MÉTODO CARGAR
    // =========================

    // Descuenta dinero del saldo de la cuenta.
    public void cargar(Integer valor) {
        // No permite cargar montos negativos ni cero
        if (valor <= 0) {
            System.out.println("El monto a cargar debe ser mayor que cero.");
        }
        // Si existe saldo suficiente, realiza el descuento.
        else if (saldo - valor >= 0) {

            this.saldo -= valor;
            // Registra el cargo en el arreglo de movimientos.
            registrarMovimiento("Cargo", valor);
        }
        // Si el retiro supera el saldo disponible,
        // el saldo queda en cero según el requerimiento.
        else {
            registrarMovimiento("Cargo", saldo);
            this.saldo = 0;
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

    // Devuelve el saldo actual de la cuenta como balance.
    public Integer consultarBalance() {
        return saldo;
    }
}