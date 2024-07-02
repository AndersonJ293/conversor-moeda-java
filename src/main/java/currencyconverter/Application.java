package main.java.currencyconverter;

import java.util.Scanner;
import main.java.currencyconverter.dto.ConversionRequest;
import main.java.currencyconverter.dto.ConversionResponse;
import main.java.currencyconverter.service.CurrencyConverterService;
import main.java.currencyconverter.service.CurrencyConverterServiceImpl;
import main.java.currencyconverter.service.ExchangeRateService;
import main.java.currencyconverter.service.ExchangeRateServiceImpl;
import main.java.currencyconverter.utils.ConsoleViewUtils;

public class Application {
  public static void main(String[] args) {
    ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();
    CurrencyConverterService currencyConverterService = new CurrencyConverterServiceImpl(exchangeRateService);
    String fromCurrency = "";
    String toCurrency = "";
    double amount = 0;
    Scanner scanner = new Scanner(System.in);
    ConversionResponse conversionResponse = null;

    while (!fromCurrency.equals("0")) {
      ConsoleViewUtils.showOptions();
      fromCurrency = scanner.nextLine();

      if (!ConsoleViewUtils.checkInput(fromCurrency)) {
        ConsoleViewUtils.showIncorrectInputMessage();
        continue;
      }

      ConsoleViewUtils.showRemaingOptions(fromCurrency);
      toCurrency = scanner.nextLine();

      if (!ConsoleViewUtils.checkInput(fromCurrency)) {
        ConsoleViewUtils.showIncorrectInputMessage();
        continue;
      }

      ConsoleViewUtils.showMessage("\nConverter " + fromCurrency + " para " + toCurrency + "\n");
      ConsoleViewUtils.showMessage("Insira a quantidade:");
      amount = scanner.nextDouble();

      conversionResponse =
          currencyConverterService.convertCurrency(new ConversionRequest(fromCurrency, toCurrency, amount));

      ConsoleViewUtils.showResult(conversionResponse);
      ConsoleViewUtils.showResultOptions();
      fromCurrency = scanner.nextLine();
      fromCurrency = scanner.nextLine();
    }
  }
}
