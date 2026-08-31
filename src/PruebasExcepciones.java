public class PruebasExcepciones {

    public static void ejecutarPruebasComunes() {
        System.out.println("\n=== PRUEBAS DE EXCEPCIONES COMUNES ===");

        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: se intento usar un objeto null.");
        }

        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: indice fuera del arreglo.");
        }

        try {
            int resultado = 10 / 0;
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: no se puede dividir por cero.");
        }

        try {
            int numero = Integer.parseInt("abc");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: el texto no se puede convertir a numero.");
        }

        try {
            String palabra = "Java";
            System.out.println(palabra.charAt(10));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException: indice fuera del texto.");
        }
    }
}