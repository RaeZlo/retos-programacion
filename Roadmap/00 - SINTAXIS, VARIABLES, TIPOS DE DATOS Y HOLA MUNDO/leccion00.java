public class leccion00 {
    public static void main(String[] args) {

        // URL del sitio oficial de Java = https://www.java.com/es/

        // Comentario en una línea

        /* Esto es un
        comentario
        en varias
        líneas */

        String variable = "Soy una variable";

        String otraVariable;
        otraVariable = "Otra forma de declarar variables";

        final String constante = "Soy una constante";

        // Datos Primitivos
        boolean datoLogico = true; // Puede ser true o false
        char caracter = 'a'; // Símbolo único que puede ser una letra, un número, etc.
        String texto = "¡Hola, Java!"; //Tipo de dato no primitivo (Objeto)
        byte numeroMuyPequenio = 18; // Comprende entre -128 e 127
        short numeroPequenio = 18000; // Comprende entre -32768 y 32767
        int numero = 734869; // Comprende entre -2.147.483.648 y 2.147.483.647
        long numeroGrande = 2000000000L; // Comprende entre -9.223.372.036.854.775.808 e 9.223.372.036.854.775.807
        float decimalPequenio = 15.6666F; // Decimal de 4 bytes
        double decimal = 13.4823; // Decimal de 8 bytes

        System.out.println(texto);
    }
}
