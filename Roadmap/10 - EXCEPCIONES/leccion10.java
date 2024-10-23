import java.util.ArrayList;

public class leccion10 {
    public static void main(String[] args) {

        try {
            int division = 10/0;
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        }

        try {
            ArrayList<String> list = new ArrayList<>();
            list.add("reloj");
            System.out.println(list.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("----------DIFICULTAD EXTRA-----------");

        try {
            int result = errorResult(-1);
            System.out.println("No se produce ningún error");
            System.out.println("Resultado del método: " + result);
        } catch (RafaException e) {
            System.out.println("Error personalizado: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error 1: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error 2: " + e.getMessage());
        }finally {
            System.out.println("Fin del programa");
        }


    }

    public static int errorResult(int number) throws RafaException {
        if (number < 0) {
            throw new RafaException("El número no puede ser negativo");
        } else if (number == 0) {
            throw new ArithmeticException("El número no puede ser igual a 0");
        }else if (number >1000) {
            throw new IllegalArgumentException("El número no puede ser mayor de 1000");
        }
        return number;
    }
}

class RafaException extends Exception {
    public RafaException(String mensaje) {
        super(mensaje);
    }
}
