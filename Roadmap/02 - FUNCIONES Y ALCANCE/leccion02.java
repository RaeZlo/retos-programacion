public class leccion02 {

    // Función sin parámetros ni retorno
    static void saludar() {
        System.out.println("Hola, Java!");
    }

    // Función con retorno
    static String saludoConRetorno() {
        return "Hola, Java!";
    }

    // Función con argumento
    static void saludoParticular(String nombre) {
        System.out.println("Hola, " + nombre + "!");
    }

    // Función con varios argumentos
    static String saludoPersonalizado(String saludo, String nombre) {
        return saludo + ", " + nombre + "!";
    }

    // Ejemplo de variable local
    static int multiplicacion(int num1, int num2){
        int resultado = num1 * num2; // Variable local
        return resultado;
    }

    static String variableGlobal = "Esto es una variable global"; // Variable global

    // Extra

    static int fizzBuzz(String text1, String text2) {
        int contador = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(text1 + text2);
            } else if (i % 3 == 0) {
                System.out.println(text1);
            } else if (i % 5 == 0) {
                System.out.println(text2);
            } else {
                contador++;
                System.out.println(i);
            }
        }
        return contador; // Se devuelve después de que el bucle haya terminado
    }
    
    public static void main(String[] args) {

        // Llamada a las funciones
        saludar();

        System.out.println(saludoConRetorno());

        saludoParticular("Rafa");

        System.out.println(saludoPersonalizado("Buenas noches", "Pepe"));

        System.out.println("Resultado de la multiplicación: " + multiplicacion(2, 5));

        // Ejemplo de variable global
        System.out.println(variableGlobal);

        // Ejemplo de función predefinida en Java
        System.out.println("Raíz cuadrada de 16: " + Math.sqrt(16));

        int cantidadNumeros = fizzBuzz("Fizz", "Buzz");
    }
}
