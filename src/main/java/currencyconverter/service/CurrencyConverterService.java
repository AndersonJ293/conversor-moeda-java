package main.java.currencyconverter.service;

import main.java.currencyconverter.dto.ConversionRequest;
import main.java.currencyconverter.dto.ConversionResponse;

public interface CurrencyConverterService {
    ConversionResponse convertCurrency(ConversionRequest request);
}
