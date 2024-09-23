public class leccion04 {
    public static void main(String[] args) {
        String text = "Este es un texto de prueba";

        System.out.println("Operaciones con cadenas en Java:");
        System.out.println();

        System.out.println("** Búsqueda y Comparación **");

        // Obtener un carácter según posición
        System.out.println("Caracter en la posición 0: " + text.charAt(0));

        // Comparar dos cadenas (devuelve la diferencia lexicográfica)
        System.out.println("Diferencia de longitud: " + text.compareTo("Este"));

        // Comparar si dos cadenas son exactamente iguales
        System.out.println("¿Son iguales?: " + text.equals("Este"));

        // Comparar si son iguales ignorando mayúsculas y minúsculas
        System.out.println("¿Son iguales ignorando mayúsculas?: " + text.equalsIgnoreCase("este es un texto de prueba"));

        // Ver si contiene una subcadena
        System.out.println("¿Contiene 'Este'?: " + text.contains("Este"));

        // Encontrar el índice de una subcadena
        System.out.println("Índice de 'texto': " + text.indexOf("texto"));

        // Encontrar el último índice de una subcadena
        System.out.println("Último índice de 'texto': " + text.lastIndexOf("texto"));

        // Ver si empieza por una subcadena
        System.out.println("¿Empieza por 'Este'?: " + text.startsWith("Este"));

        // Ver si termina con una subcadena
        System.out.println("¿Termina por 'prueba'?: " + text.endsWith("prueba"));

        System.out.println();


        System.out.println("** Modificación y Transformación **");

        // Concatenar texto
        System.out.println("Concatenar texto: " + text.concat(" en Java"));

        // Reemplazar una subcadena dentro del texto
        System.out.println("Reemplazar 'Este es' por 'Soy': " + text.replace("Este es", "Soy"));

        // Obtener una subcadena (entre índices)
        System.out.println("Subcadena entre 0 y 10: " + text.substring(0, 10));

        // Obtener una subcadena a partir de un índice
        System.out.println("Texto a partir del índice 10: " + text.substring(10));

        // Convertir a minúsculas
        System.out.println("Texto en minúsculas: " + text.toLowerCase());

        // Convertir a mayúsculas
        System.out.println("Texto en mayúsculas: " + text.toUpperCase());

        // Repetir el texto n veces
        System.out.println("Repetir texto 2 veces: " + text.repeat(2));

        System.out.println();



        System.out.println("** Validación y Verificación **");

        // Ver si la cadena está vacía
        System.out.println("¿Está vacía?: " + text.isEmpty());

        // Ver si la cadena solo tiene espacios o está vacía
        System.out.println("¿Está vacía o solo tiene espacios en blanco?: " + text.isBlank());

        // Longitud del texto
        System.out.println("Longitud del texto: " + text.length());
    }
}
