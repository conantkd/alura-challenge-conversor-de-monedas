import java.text.DecimalFormat;
import java.util.Map;

public class CalculadoraMonedasDolares {
    BuscadorTasas buscarTasa = new BuscadorTasas();
    Map<String, Double> tasasDeCambio;
    DecimalFormat df = new DecimalFormat("#.##");

    public CalculadoraMonedasDolares(double valor, String moneda) {
        String json = buscarTasa.getExchangeRates();
        tasasDeCambio = buscarTasa.getConversionRates(json);
        double tasa = tasasDeCambio.get(moneda);
        double conversion = valor / tasa;
        System.out.println("Conversión: " + valor + " " + moneda + "son " + df.format(conversion)+" USD");
    }
}