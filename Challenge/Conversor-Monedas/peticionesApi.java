import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class peticionesApi {
    public static void usdToX(String moneda, Scanner scanner) throws IOException, InterruptedException {

        System.out.println("Ingrese la cantidad de Dólares que desea convertir: ");

        // Validar si la entrada es un número decimal
        if (scanner.hasNextDouble()) {
            double cantidad = scanner.nextDouble();
            double tasaCambio = conexionApi.obtenerTasaCambio(moneda);
            double resultado = cantidad * tasaCambio;
            System.out.println("EL valor " + cantidad + " [USD] tiene el valor final de ==> " + resultado + " [" + moneda + "]");
        } else {
            System.out.println("Error: Entrada no válida. Por favor ingrese un número decimal con ','.");
        }
    }

    public static void xToUsd(String moneda, Scanner scanner) throws IOException, InterruptedException {

        System.out.println("Ingrese la cantidad de " + moneda + " que desea convertir a Dólares: ");

        // Validar si la entrada es un número decimal
        if (scanner.hasNextDouble()) {
            double cantidad = scanner.nextDouble();
            double tasaCambio = conexionApi.obtenerTasaCambio(moneda);
            double resultado = cantidad / tasaCambio;
            System.out.println("EL valor " + cantidad + " [" + moneda + "] tiene el valor final de ==> " + resultado + " [USD]");
        } else {
            System.out.println("Error: Entrada no válida. Por favor ingrese un número decimal con ','.");
        }
    }

    class conexionApi {
        private static final String API_KEY = "5c53c02f1c76c52db9eb737a";
        private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

        private static double obtenerTasaCambio(String moneda) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

            if (rates.has(moneda)) {
                return rates.get(moneda).getAsDouble();
            } else {
                throw new IllegalArgumentException("Error: La moneda " + moneda + " no es valida.");
            }
        }
    }
}