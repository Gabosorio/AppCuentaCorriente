public class ExplicacionErrores {

    public static void mostrarExplicacion() {
        System.out.println("\n=== EXPLICACION DE TIPOS DE ERRORES ===");

        System.out.println("Exception: ocurre durante la ejecucion del programa.");
        System.out.println("Ejemplo: dividir por cero o acceder a una posicion inexistente de un arreglo.");

        System.out.println("Error logico: el programa compila y se ejecuta, pero entrega un resultado incorrecto.");
        System.out.println("Ejemplo: validar mal una condicion, como permitir montos negativos.");

        System.out.println("Error sintactico: el codigo esta mal escrito y no compila.");
        System.out.println("Ejemplo: olvidar un punto y coma o cerrar mal una llave.");
    }

    public static void ejemploErrorLogico() {
        System.out.println("\n=== EJEMPLO DE ERROR LOGICO ===");

        int edad = -5;

        // Error logico: la condicion esta mal planteada.
        // Una edad negativa no deberia ser valida, pero esta condicion la acepta.
        if (edad < 0) {
            System.out.println("Edad aceptada incorrectamente: " + edad);
        } else {
            System.out.println("Edad valida.");
        }
    }

    public static void ejemploErrorSintacticoComentado() {
        System.out.println("\n=== EJEMPLO DE ERROR SINTACTICO ===");

        // El siguiente codigo seria un error sintactico si estuviera activo,
        // porque falta el punto y coma al final:
        //
        // System.out.println("Hola")
        //
        // Java no podria compilar hasta corregirlo:
        // System.out.println("Hola");
        System.out.println("Ejemplo sintactico explicado en comentarios.");
    }
    public static void explicarNivelesExcepciones() {
        System.out.println("\n=== NIVELES DE EXCEPCIONES ===");

        System.out.println("Excepcion del sistema: ocurre por problemas propios del lenguaje o del entorno.");
        System.out.println("Ejemplo: NullPointerException al usar un objeto null.");

        System.out.println("Excepcion de aplicacion: ocurre por validaciones generales del programa.");
        System.out.println("Ejemplo: MontoInvalidoException cuando se ingresa un monto negativo o cero.");

        System.out.println("Excepcion de negocio: ocurre cuando se rompe una regla propia del cajero.");
        System.out.println("Ejemplo: SaldoInsuficienteException cuando se intenta cargar mas dinero del disponible.");
    }
    public static void analizarExcepcionesDelCajero() {
        System.out.println("\n=== ANALISIS DE EXCEPCIONES DEL CAJERO ===");

        System.out.println("1. Monto invalido:");
        System.out.println("Puede ocurrir al intentar abonar o cargar valores menores o iguales a cero.");
        System.out.println("Estrategia: lanzar MontoInvalidoException y capturarla con try/catch.");

        System.out.println("2. Saldo insuficiente:");
        System.out.println("Puede ocurrir cuando el usuario intenta cargar mas dinero del balance disponible.");
        System.out.println("Estrategia: lanzar SaldoInsuficienteException como excepcion de negocio.");

        System.out.println("3. Fecha invalida:");
        System.out.println("Puede ocurrir si se ingresa una fecha inexistente o con formato distinto a DD/MM/YYYY.");
        System.out.println("Estrategia: validar con LocalDate y capturar DateTimeParseException para lanzar FechaInvalidaException.");

        System.out.println("4. Arreglo no inicializado:");
        System.out.println("Puede ocurrir si el arreglo de movimientos queda en null y se intenta usar.");
        System.out.println("Estrategia: inicializar el arreglo en los constructores y validar antes de recorrerlo.");

        System.out.println("5. Indice fuera de rango:");
        System.out.println("Puede ocurrir al acceder a una posicion inexistente del arreglo de movimientos.");
        System.out.println("Estrategia: controlar los limites con cantidadMovimientos y MAX_MOVIMIENTOS.");

        System.out.println("6. Caracteres en campos numericos:");
        System.out.println("Puede ocurrir si el usuario ingresa texto donde el programa espera un numero.");
        System.out.println("Estrategia: capturar NumberFormatException o validar la entrada antes de convertirla.");
    }
}
