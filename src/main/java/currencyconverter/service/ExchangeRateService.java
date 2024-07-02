package main.java.currencyconverter.service;

import java.math.BigDecimal;

public interface ExchangeRateService {
    double getExchangeRate(String fromCurrency, String toCurrency);
}
