// Importa la clase CuentaCorriente desde el paquete cuentas.
// Esto permite crear objetos de esa clase en este archivo.
import cuentas.CuentaCorriente;

// Clase principal del programa.
// Desde aquí comienza la ejecución cuando presionamos Run.
public class Main {

    // Método principal (punto de entrada del programa).
    // Java siempre comienza ejecutando este método.
    public static void main(String[] args) {

        // =========================
        // CREAR UN OBJETO
        // =========================

        // Se crea un objeto llamado cuenta1 utilizando el constructor
        // que recibe número, titular y saldo inicial.
        CuentaCorriente cuenta1 = new CuentaCorriente(10001, "Gabriel", 100000);


        // =========================
        // MOSTRAR ESTADO INICIAL
        // =========================


        System.out.println("=== ESTADO INICIAL ===");

        // Imprime el objeto.
        // Java ejecuta automáticamente el método toString().
        System.out.println(cuenta1);


        // =========================
        // PROBAR EL MÉTODO ABONAR
        // =========================

        // Agrega $20.000 al saldo.
        System.out.println("\n=== ABONOS ===");
        cuenta1.abonar(20000);
        cuenta1.abonar(15000);
        cuenta1.abonar(-500);
        cuenta1.abonar(0);

        System.out.println("\n=== CARGOS ===");
        cuenta1.cargar(10000);
        cuenta1.cargar(25000);
        cuenta1.cargar(-1000);
        cuenta1.cargar(0);

        // Imprime nuevamente la cuenta para verificar el nuevo saldo.
        System.out.println("\n=== ESTADO FINAL ===");
        System.out.println(cuenta1);

        System.out.println("\n=== BALANCE ===");
        System.out.println("Balance actual: " + cuenta1.consultarBalance());

        System.out.println("\n=== PRUEBA DE LOS 10 ÚLTIMOS MOVIMIENTOS ===");

        cuenta1.abonar(1000);
        cuenta1.abonar(2000);
        cuenta1.abonar(3000);
        cuenta1.abonar(4000);
        cuenta1.abonar(5000);
        cuenta1.abonar(6000);
        cuenta1.abonar(7000);
        cuenta1.abonar(8000);

        System.out.println("\n=== BALANCE FINAL DESPUÉS DE LA PRUEBA ===");
        System.out.println("Balance actual: " + cuenta1.consultarBalance());
        cuenta1.mostrarMovimientos();

    }
}
