public class leccion06 {
    public static void main(String[] args) {
        countDown(100);
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
    }

    /*
      La recursividad consiste una función se llama a sí misma para resolver un problema, actuando en cierta forma como un bucle.
      Es útil para la exploración de estructuras de datos jerárquicas (como árboles).
    */

    // Ejercicio
    public static void countDown(int number) {
        if (number >= 0) {
            System.out.println(number);
            countDown(number - 1);
        }
    }

    // Extra
    public static int factorial(int number) {
        if (number < 0) {
            System.out.println("No valido.");
        } else if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static int fibonacci(int numberPosition) {
        if (numberPosition <= 0) {
            System.out.println("No valido.");
        } else if (numberPosition == 1) {
            return 0;
        } else if (numberPosition == 2) {
            return 1;
        }

        return fibonacci(numberPosition - 1) + fibonacci(numberPosition - 2);
    }

}
