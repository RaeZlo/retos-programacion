import java.util.*;

public class leccion03 {
    public static void main(String[] args) {

        /*
        Estructuras de datos por defecto en Java:
        -- Arrays: son un conjunto de datos del mismo tipo
        almacenados en posiciones con consecutivas de memoria,
        cuya extensión es inmutable.
        -- Listas: secuencia de datos del mismo tipo, donde cada
        elemento está enlazado al siguiente. La extensión es mutable.
        -- Pilas: Los elementos se apilan uno encima del otro,
        y solo se puede acceder al último elemento agregado (LIFO).
        -- Colas: Los elementos se encolan uno detrás del otro,
        y solo se puede acceder al primer elemento agregado (FIFO).
        -- Conjuntos: son colecciones de elementos únicos sin orden.
        -- Diccionarios: son colecciones guardadas en pares de clave-valor,
        donde cada clave se asocia con un valor. El concepto de clave
        es similar al de primary key en bases de datos.
        */

        // Inicializar array con datos
        int [] array = new int[]{10, 9, 7, 6 , 5};
        // Inserción
        array[3] = 35;
        // Modificar elementos
        array[0] = 1;
        // Ordenar array
        Arrays.sort(array);

        // Inicializar array con longitud
        int [] array2 = new int[10];

        // Listas
        ArrayList<String> lista = new ArrayList<>();
        // Inserción
        lista.add("Pepe");
        lista.add("Lore");
        // Borrar
        lista.remove(1);
        // Modificar elementos
        lista.set(0, "Rafa");

        // Conjuntos
        HashSet<Integer> conjunto = new HashSet<>();
        // Inserción
        conjunto.add(1);
        // Borrar
        conjunto.remove(1);

        // Diccionarios
        HashMap<Integer, String> diccionario = new HashMap<>();
        // Inserción
        diccionario.put(1, "Mar");
        diccionario.put(2, "Toto");
        // Borrar clave
        diccionario.remove(1);
        // Borrar clave y valor
        diccionario.remove(2, "Toto");

        // Colas
        Queue<Integer> cola = new LinkedList<>();
        // Inserción
        cola.add(6);
        // Borrar
        cola.remove(6);

        // Pilas
        Stack<Integer> pila = new Stack<>();
        // Inserción
        pila.add(44);
        // Borrar
        pila.remove(0);
        // Actualizar
        pila.set(0, 48);
        // Ordenar
        Collections.sort(pila);

        // Extra 

        HashMap<String, Integer> listaContactos = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        boolean encendido = true;

        while (encendido) {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Actualizar número de contacto");
            System.out.println("5. Salir");

            System.out.print("Elige una opción: ");
            int opcion = scan.nextInt();
            scan.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar contacto
                    System.out.println("Nombre del contacto:");
                    String nombreAgregar = scan.nextLine();

                    System.out.println("Número del contacto:");
                    String numeroAgregar = scan.nextLine();

                    if (validarNumero(numeroAgregar)) {
                        listaContactos.put(nombreAgregar, Integer.parseInt(numeroAgregar));
                        System.out.println("Contacto agregado exitosamente.");
                    } else {
                        System.out.println("Número inválido. Debe ser numérico y tener un máximo de 11 dígitos.");
                    }
                    System.out.println("------------------------------------------");
                    break;

                case 2:
                    // Buscar contacto
                    System.out.println("Ingrese el nombre del contacto que quiere buscar:");
                    String nombreBuscar = scan.nextLine();

                    if (listaContactos.containsKey(nombreBuscar)) {
                        System.out.println("El número del contacto es: " + listaContactos.get(nombreBuscar));
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    System.out.println("------------------------------------------");
                    break;

                case 3:
                    // Eliminar contacto
                    System.out.println("Ingrese el nombre del contacto que quiere eliminar:");
                    String nombreEliminar = scan.nextLine();

                    if (listaContactos.containsKey(nombreEliminar)) {
                        listaContactos.remove(nombreEliminar);
                        System.out.println("El contacto fue eliminado exitosamente.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    System.out.println("------------------------------------------");
                    break;

                case 4:
                    // Actualizar contacto
                    System.out.println("Ingrese el nombre del contacto para actualizar su número:");
                    String nombreActualizar = scan.nextLine();

                    if (listaContactos.containsKey(nombreActualizar)) {
                        System.out.println("Ingrese el nuevo número:");
                        String nuevoNumero = scan.nextLine();

                        if (validarNumero(nuevoNumero)) {
                            listaContactos.replace(nombreActualizar, Integer.parseInt(nuevoNumero));
                            System.out.println("Número actualizado exitosamente.");
                        } else {
                            System.out.println("Número inválido. Debe ser numérico y tener un máximo de 11 dígitos.");
                        }
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    System.out.println("------------------------------------------");
                    break;

                case 5:
                    // Salir del programa
                    encendido = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
    // Validar que el número sea numérico y tenga un máximo de 11 dígitos
    public static boolean validarNumero(String numero) {
        return numero.matches("\\d{1,11}");
    }
}
