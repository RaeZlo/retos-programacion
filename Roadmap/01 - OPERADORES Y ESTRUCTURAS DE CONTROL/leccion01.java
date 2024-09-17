public class leccion01 {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // Operadores aritméticos
        System.out.println("Suma: 10+3 = " + (a+b));
        System.out.println("Resta: 10-3 = " + (a-b));
        System.out.println("Multiplicación: 10*3 = " + (a*b));
        System.out.println("División: 10/3 = " + (a/b));
        System.out.println("Módulo: 10%3 = " + (a%b));
        System.out.println("********************************************");

        // Operadores de comparación
        System.out.println("Igualdad: 10 == 3 es " + (10 == 3));
        System.out.println("Desigualdad: 10 != 3 es " + (10 != 3));
        System.out.println("Mayor que: 10 > 3 es " + (10 > 3));
        System.out.println("Menor que: 10 < 3 es " + (10 < 3));
        System.out.println("Mayor o igual que: 10 >= 3 es " + (10 >= 3));
        System.out.println("Menor o igual que: 10 <= 3 es " + (10 <= 3));
        System.out.println("********************************************");

        // Operadoers lógicos
        System.out.println("AND: true && false es " + (false)); // Devuelve true si ambas condiciones son verdaderas.
        System.out.println("OR: false || true es " + (true)); // Devuelve true si al menos una de las condiciones es verdadera.
        System.out.println("NOT: !false es " + (true)); // Invierte el valor de una expresión booleana
        System.out.println("XOR Lógico: false ^ false es " + (false)); // Devuelve true si solo una de las condiciones es verdadera.
        System.out.println("********************************************");

        // Operadores de Asignación
        a += 2;  // a = a + 2;
        System.out.println("a += 2: " + a);   // 12
        b *= 3;  // b = b * 3;
        System.out.println("b *= 3: " + b);   // 9
        System.out.println("********************************************");

        // Operadores de Bits
        int c = 6;  // 110 en binario
        int d = 4;  // 100 en binario

        System.out.println("c & d: " + (c & d));  // AND bit a bit, resultado: 4 (100 en binario)
        System.out.println("c | d: " + (c | d));  // OR bit a bit, resultado: 6 (110 en binario)
        System.out.println("c ^ d: " + (c ^ d));  // XOR bit a bit, resultado: 2 (010 en binario)
        System.out.println("~c: " + (~c));        // NOT bit a bit, resultado: -7 (complemento a 2)
        System.out.println("c << 1: " + (c << 1)); // Desplazamiento a la izquierda, resultado: 12 (1100 en binario)
        System.out.println("c >> 1: " + (c >> 1)); // Desplazamiento a la derecha, resultado: 3 (11 en binario)
        System.out.println("********************************************");

        // Estructuras de Control Condicional

        if (a > b) {
            System.out.println("a es mayor que b");
        } else if (a < b) {
            System.out.println("a es menor que b");
        } else {
            System.out.println("Son iguales");
        }
        System.out.println("********************************************");

        // Estructura switch
        int dia = 3;
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            default:
                System.out.println("Día inválido");
        }
        System.out.println("********************************************");

        // Ciclo "for"
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }
        System.out.println("********************************************");

        // Ciclo "do-while"
        int n = 0;
        do {
            System.out.println("n = " + n);
            n++;
        } while (n < 2);
        System.out.println("********************************************");
    }
}
