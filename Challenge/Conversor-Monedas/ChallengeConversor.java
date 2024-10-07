import java.io.IOException;
import java.util.Scanner;

public class ChallengeConversor {
    // Metodo para mostrar el menú
    public static void menu() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Bienvenido al conversor de monedas!");
        System.out.println();
        System.out.println("1) Dólar ==>> Peso argentino");
        System.out.println("2) Peso argentino ==>> Dólar");
        System.out.println("3) Dólar ==>> Peso chileno");
        System.out.println("4) Peso chileno ==>> Dólar");
        System.out.println("5) Dólar ==>> Real");
        System.out.println("6) Real ==>> Dólar");
        System.out.println("7) Dólar ==>> Yen");
        System.out.println("8) Yen ==>> Dólar");
        System.out.println("9) Salir");
        System.out.println();
        System.out.println("Elige una opción:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean encendido = true;

        while (encendido) {
            menu();
            int opcion = scanner.nextInt();
            System.out.println("------------------------------------------------------------------");

            try {
                switch (opcion) {
                    case 1:
                        peticionesApi.usdToX("ARS", scanner);
                        break;
                    case 2:
                        peticionesApi.xToUsd("ARS", scanner);
                        break;
                    case 3:
                        peticionesApi.usdToX("CLP", scanner);
                        break;
                    case 4:
                        peticionesApi.xToUsd("CLP", scanner);
                        break;
                    case 5:
                        peticionesApi.usdToX("BRL", scanner);
                        break;
                    case 6:
                        peticionesApi.xToUsd("BRL", scanner);
                        break;
                    case 7:
                        peticionesApi.usdToX("JPY", scanner);
                        break;
                    case 8:
                        peticionesApi.xToUsd("JPY", scanner);
                        break;
                    case 9:
                        encendido = false;
                        System.out.println("Saliendo del programa...");
                        break;
                }
            } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener los datos de la API. Inténtalo de nuevo más tarde.");
            } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            }
        }
    }
}