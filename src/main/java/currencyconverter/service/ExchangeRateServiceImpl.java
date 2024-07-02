package main.java.currencyconverter.service;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateServiceImpl implements ExchangeRateService {
  private final Map<String, Double> brlRates =
      new HashMap<String, Double>() {
        {
          put("USD", 0.18);
          put("EUR", 0.16);
          put("JPY", 28.56);
          put("ARS", 161.50);
          put("CTM", 0.3);
        }
      };

  private final Map<String, Double> usdRates =
      new HashMap<String, Double>() {
        {
          put("BRL", 5.66);
          put("EUR", 0.93);
          put("JPY", 161.57);
          put("ARS", 913.50);
          put("CTM", 0.93);
        }
      };

  private final Map<String, Double> eurRates =
      new HashMap<String, Double>() {
        {
          put("USD", 1.07);
          put("BRL", 6.07);
          put("JPY", 173.47);
          put("ARS", 980.82);
          put("CTM", 1.05);
        }
      };

  private final Map<String, Double> jpyRates =
      new HashMap<String, Double>() {
        {
          put("USD", 0.0062);
          put("EUR", 0.0058);
          put("BRL", 0.035);
          put("ARS", 5.65);
          put("CTM", 0.0052);
        }
      };

  private final Map<String, Double> arsRates =
      new HashMap<String, Double>() {
        {
          put("USD", 0.18);
          put("EUR", 0.16);
          put("JPY", 28.56);
          put("BRL", 161.50);
          put("CTM", 0.8);
        }
      };

  private final Map<String, Double> ctmRates =
      new HashMap<String, Double>() {
        {
          put("USD", 0.0011);
          put("EUR", 0.0010);
          put("JPY", 0.18);
          put("ARS", 0.0062);
          put("BRL", 0.0009);
        }
      };

  private final Map<String, Map<String, Double>> rates =
      new HashMap<String, Map<String, Double>>() {
        {
          put("BRL", brlRates);
          put("USD", usdRates);
          put("EUR", eurRates);
          put("JPY", jpyRates);
          put("ARS", arsRates);
          put("CTM", ctmRates);
        }
      };

  @Override
  public double getExchangeRate(String fromCurrency, String toCurrency) {
    return rates.get(fromCurrency).get(toCurrency);
  }
}
