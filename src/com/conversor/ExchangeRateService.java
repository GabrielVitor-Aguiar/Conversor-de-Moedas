package com.conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double getExchangeRate(String baseCurrency, String targetCurrency) throws ApiException, ParsingException {
        try {
            String requestUrl = API_URL + baseCurrency;
            @SuppressWarnings("deprecation")
            HttpURLConnection connection = (HttpURLConnection) new URL(requestUrl).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new ApiException("Erro ao conectar à API: Código " + responseCode);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return parseExchangeRate(response.toString(), targetCurrency);
        } catch (Exception e) {
            throw new ApiException("Erro ao obter taxa de câmbio: " + e.getMessage(), e);
        }
    }

    private double parseExchangeRate(String jsonResponse, String targetCurrency) throws ParsingException {
        try {
            int ratesIndex = jsonResponse.indexOf("\"rates\":") + 8;
            int endRatesIndex = jsonResponse.indexOf("}", ratesIndex);
            String rates = jsonResponse.substring(ratesIndex, endRatesIndex + 1);

            String[] pairs = rates.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                if (keyValue[0].replace("\"", "").trim().equals(targetCurrency)) {
                    return Double.parseDouble(keyValue[1]);
                }
            }
            throw new ParsingException("Moeda de destino não encontrada no JSON.");
        } catch (Exception e) {
            throw new ParsingException("Erro ao analisar o JSON: " + e.getMessage(), e);
        }
    }
}
