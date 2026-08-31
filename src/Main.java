// Importa la clase CuentaCorriente desde el paquete cuentas.
// Esto permite crear objetos de esa clase en este archivo.
import cuentas.CuentaCorriente;
import exceptions.MontoInvalidoException;
import exceptions.SaldoInsuficienteException;
import exceptions.FechaInvalidaException;

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
    IO.println("\n=== PRUEBA SALDO INSUFICIENTE ===");
    try {
        cuenta1.cargar(999999);
    } catch (SaldoInsuficienteException e) {
        System.out.println("Error de negocio: " + e.getMessage());
    }

    IO.println("\n=== PRUEBA FECHA ===");
    try {
        cuenta1.validarFecha("31/02/2026");
        System.out.println("Fecha válida.");
    } catch (FechaInvalidaException e) {
        System.out.println("Error de fecha: " + e.getMessage());
    }
// En la primera prueba se captura una excepcion especifica:
// ArrayIndexOutOfBoundsException.
// En la segunda prueba se captura la misma situacion con Exception,
// que es una superclase mas general.
    IO.println("\n=== PRUEBA EXCEPCION ESPECIFICA VS GENERAL ===");

    try {
        int[] numeros = {1, 2, 3};
        IO.println(numeros[5]);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Captura especifica: indice fuera del arreglo.");
    }

    try {
        int[] numeros = {1, 2, 3};
        IO.println(numeros[5]);
    } catch (Exception e) {
        System.out.println("Captura general: " + e.getClass().getSimpleName());
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
    PruebasExcepciones.ejecutarPruebasComunes();
    ExplicacionErrores.mostrarExplicacion();
    ExplicacionErrores.ejemploErrorLogico();
    ExplicacionErrores.ejemploErrorSintacticoComentado();
    ExplicacionErrores.explicarNivelesExcepciones();
    ExplicacionErrores.analizarExcepcionesDelCajero();
}
