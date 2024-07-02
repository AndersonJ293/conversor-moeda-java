package main.java.currencyconverter.service;

import java.math.BigDecimal;
import main.java.currencyconverter.dto.ConversionRequest;
import main.java.currencyconverter.dto.ConversionResponse;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {

  private final ExchangeRateService exchangeRateService;

  public CurrencyConverterServiceImpl(ExchangeRateService exchangeRateService) {
    this.exchangeRateService = exchangeRateService;
  }

  @Override
  public ConversionResponse convertCurrency(ConversionRequest request) {
    double rate = exchangeRateService.getExchangeRate(request.getFromCurrency(), request.getToCurrency());
    double convertedAmount = request.getAmount() * rate;
    return new ConversionResponse(
        request.getFromCurrency(), request.getToCurrency(), request.getAmount(), convertedAmount);
  }
}
