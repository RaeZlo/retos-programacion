import java.util.ArrayList;
import java.util.Scanner;

public class leccion07 {
    public static void main(String[] args) {
             /* Pilas (Stacks): Siguen el principio LIFO (Last In, First Out),
        donde el último elemento que se agrega es el primero en salir.
        Las operaciones principales son push (añadir) y pop (eliminar).*/

        push(1);
        push(4);
        push(55);
        System.out.println("La pila contiene los siguientes valores: " + stack);
        System.out.println("Se eliminó: " + pop());
        System.out.println("La pila contiene los siguientes valores: " + stack);

        /* Colas (Queues): Siguen el principio FIFO (First In, First Out),
        donde el primer elemento en entrar es el primero en salir.
        Las operaciones principales son enqueue (añadir) y dequeue (eliminar). */

        pushQueue(2);
        pushQueue(48);
        pushQueue(69);
        System.out.println("La cola contiene los siguientes valores: " + queues);
        System.out.println("Se eliminó: " + popQueues());
        System.out.println("La cola contiene los siguientes valores: " + queues);

        // Extra
        webNavegation();
        impresora();
    }

    static ArrayList<Integer> stack = new ArrayList<>();

    public static void push(int number) {

        stack.add(number);
    }

    public static int pop() {
        /*stack.removeLast();*/ // Solución fácil

        return stack.remove(stack.size() - 1); // Solución genérica
    }

    static ArrayList<Integer> queues = new ArrayList<>();

    public static void pushQueue(int number) {

        queues.add(number);
    }

    public static int popQueues() {
        /*queues.removeFirst();*/ // Solución fácil

        return queues.remove(0); // Solución genérica
    }

    public static void webNavegation() {
        ArrayList<String> stack = new ArrayList<>();
        boolean exit = false;

        do {
            Scanner scanner =  new Scanner(System.in);
            System.out.println("Añade una url o navega a traves de las palabras adelante/atras/salir");
            System.out.print("Introduce el texto: ");

            String action = scanner.nextLine();

            switch (action){
                case "adelante":
                    break;
                case "atras":
                    if (stack.size() > 1) {
                        stack.remove(stack.size() - 1);
                    }
                    break;
                case "salir":
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    stack.add(action);
            }

            if (stack.size() > 1) {
                System.out.println("Web actual: " + stack.get(stack.size() - 1));
            } else {
                System.out.println("Estas en la página de inicio.");
            }
        } while (!exit);
    }

    public static void impresora() {
        ArrayList<String> queue = new ArrayList<>();
        boolean exit = false;

        do {
            Scanner scanner =  new Scanner(System.in);
            System.out.println("Añade un documento o selecciona imprimir/salir");
            System.out.print("Introduce el texto: ");

            String action = scanner.nextLine();

            switch (action) {
                case "imprimir":
                    if (queue.size() >= 1) {
                        System.out.println("Imprimiendo documento: " + queue.get(0));
                        queue.remove(0);
                    } else {
                        System.out.println("No hay documentos para imprimir.");
                    }
                    break;
                case "salir":
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    queue.add(action);
            }
        } while (!exit);
    }
}
