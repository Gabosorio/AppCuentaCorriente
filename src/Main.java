// Importa la clase CuentaCorriente desde el paquete cuentas.
// Esto permite crear objetos de esa clase en este archivo.
import cuentas.CuentaCorriente;
import exceptions.MontoInvalidoException;

// Clase principal del programa.
// Desde aquí comienza la ejecución cuando presionamos Run.
// Método principal (punto de entrada del programa).
// Java siempre comienza ejecutando este método.
void main() {

    // =========================
    // CREAR UN OBJETO
    // =========================

    // Se crea un objeto llamado cuenta1 utilizando el constructor
    // que recibe número, titular y saldo inicial.
    CuentaCorriente cuenta1 = new CuentaCorriente(10001, "Gabriel", 100000);


    // =========================
    // MOSTRAR ESTADO INICIAL
    // =========================


    IO.println("=== ESTADO INICIAL ===");

    // Imprime el objeto.
    // Java ejecuta automáticamente el método toString().
    IO.println(cuenta1);


    // ==================================
    // PROBAR EL MÉTODO ABONAR Y CARGOS
    // ==================================

    // Agrega $20.000 al saldo.
    IO.println("\n=== ABONOS ===");
    try {
        cuenta1.abonar(20000);
        cuenta1.abonar(15000);
        cuenta1.abonar(-500);
        cuenta1.abonar(0);
    }catch(MontoInvalidoException e) {
        System.out.println("Error de validacion: " + e.getMessage());
    }finally {
        System.out.println("Proceso de abonos finalizado.");
    }

    IO.println("\n=== CARGOS ===");
    try {
        cuenta1.cargar(10000);
        cuenta1.cargar(25000);
        cuenta1.cargar(-1000);
        cuenta1.cargar(0);
    }catch(MontoInvalidoException e) {
        System.out.println("Error de validacion: " + e.getMessage());
    }finally {
        System.out.println("Proceso de cargos finalizado.");
    }


    // Imprime nuevamente la cuenta para verificar el nuevo saldo.
    IO.println("\n=== ESTADO FINAL ===");
    IO.println(cuenta1);

    IO.println("\n=== BALANCE ===");
    IO.println("Balance actual: " + cuenta1.consultarBalance());

    IO.println("\n=== PRUEBA DE LOS 10 ÚLTIMOS MOVIMIENTOS ===");

    cuenta1.abonar(1000);
    cuenta1.abonar(2000);
    cuenta1.abonar(3000);
    cuenta1.abonar(4000);
    cuenta1.abonar(5000);
    cuenta1.abonar(6000);
    cuenta1.abonar(7000);
    cuenta1.abonar(8000);

    IO.println("\n=== BALANCE FINAL DESPUÉS DE LA PRUEBA ===");
    IO.println("Balance actual: " + cuenta1.consultarBalance());
    cuenta1.mostrarMovimientos();

}
