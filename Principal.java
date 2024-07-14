import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BuscadorTasas buscadorTasas = new BuscadorTasas();
        String respuesta = buscadorTasas.getExchangeRates();
        Map<String, Double> tasasDeCambio = buscadorTasas.getConversionRates(respuesta);

        while (true) {
            String mensaje = """
                    **************************************
                    Bienvenid@ al Conversor de Monedas
                    
                    1) Dólar ==>> Peso Argentino (ARS)
                    2) Peso Argentino ==>> Dólar
                    3) Dólar ==>> Real Brasileño (BRL)
                    4) Real Brasileño ==>> Dólar
                    5) Dólar ==>> Peso Colombiano (COP)
                    6) Peso Colombiano ==>> Dólar
                    7) Salir
                    Elija una opción válida:
                    **************************************
                    """;
            System.out.println(mensaje);
            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }
            System.out.println("Ingrese el valor a convertir:");
            double valor = scanner.nextDouble();
            switch (opcion) {
                case 1 -> new CalculadoraDolaresMonedas(valor, "ARS");
                case 2 -> new CalculadoraMonedasDolares(valor, "ARS");
                case 3 -> new CalculadoraDolaresMonedas(valor, "BRL");
                case 4 -> new CalculadoraMonedasDolares(valor, "BRL");
                case 5 -> new CalculadoraDolaresMonedas(valor, "COP");
                case 6 -> new CalculadoraMonedasDolares(valor, "COP");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
