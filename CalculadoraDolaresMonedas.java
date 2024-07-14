import java.text.DecimalFormat;
import java.util.Map;

public class CalculadoraDolaresMonedas {
    BuscadorTasas buscarTasa = new BuscadorTasas();
    Map<String, Double> tasasDeCambio;
    DecimalFormat df = new DecimalFormat("#.##");

    public CalculadoraDolaresMonedas(double valor, String moneda) {
        String json = buscarTasa.getExchangeRates();
        tasasDeCambio = buscarTasa.getConversionRates(json);
        double tasa = tasasDeCambio.get(moneda);
        double conversion = valor * tasa;
        System.out.println("Conversión: " + valor + " USD son " + df.format(conversion)+ moneda );
    }
}