public class leccion05 {
    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        System.out.println("Antes de intercambiar (por valor): a = " + a + ", b = " + b);
        intercambiarValor(7, 12);
        System.out.println("Después de intercambiar (por valor): a = " + a + ", b = " + b);

        // Asignación por Referencia
        int[] array = {5, 10};
        System.out.println("Antes de intercambiar (por referencia): array[0] = " + array[0] + ", array[1] = " + array[1]);
        intercambioReferencia(array);
        System.out.println("Después de intercambiar (por referencia): array[0] = " + array[0] + ", array[1] = " + array[1]);

        // Extra

        // Valores originales
        int val1 = 10;
        int val2 = 20;

        // Intercambio por valor
        System.out.println("Antes del intercambio por valor: val1 = " + val1 + ", val2 = " + val2);
        int[] valoresIntercambiadosPorValor = intercambiarPorValor(val1, val2);
        System.out.println("Después del intercambio por valor: val1 = " + val1 + ", val2 = " + val2);
        System.out.println("Nuevas variables intercambiadas: nuevoVal1 = " + valoresIntercambiadosPorValor[0] + ", nuevoVal2 = " + valoresIntercambiadosPorValor[1]);

        // Objetos originales
        int[] referencia1 = {30};
        int[] referencia2 = {40};

        // Intercambio por referencia
        System.out.println("Antes del intercambio por referencia: referencia1 = " + referencia1[0] + ", referencia2 = " + referencia2[0]);
        intercambiarPorReferencia(referencia1, referencia2);
        System.out.println("Después del intercambio por referencia: referencia1 = " + referencia1[0] + ", referencia2 = " + referencia2[0]);

    }

    public static void intercambiarValor(int a, int b) {
        int c = a;
        a = b;
        b = c;
        // No afecta las variables originales
    }

    public static void intercambioReferencia(int[] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
        // Afecta el array original, ya que se pasa por referencia
    }

    // Extra
    public static int[] intercambiarPorValor(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
        return new int[]{x, y}; // Devuelve los valores intercambiados
    }

    // Intercambio por referencia
    public static void intercambiarPorReferencia(int[] ref1, int[] ref2) {
        int temp = ref1[0];
        ref1[0] = ref2[0];
        ref2[0] = temp;
        // Los cambios afectan directamente las referencias originales
    }
}
