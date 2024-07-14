import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;


public class BuscadorTasas {
    public String getExchangeRates() {
        ApiClient apiClient = new ApiClient();
        return apiClient.getExchangeRates();
    }

    public Map<String, Double> getConversionRates(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        return gson.fromJson(conversionRates, type);
    }
}
