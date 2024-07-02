package main.java.currencyconverter.utils;

import java.util.Arrays;
import main.java.currencyconverter.dto.ConversionResponse;

public class ConsoleViewUtils {
  public static String[] currency = {"BRL", "USD", "EUR", "JPY", "ARS", "CTM"};

  public static void showMessage(String message) {
    System.out.println(message);
  }

  public static String abbrToString(String abbreviation) {
    return switch (abbreviation) {
      case "BRL" -> "Real";
      case "USD" -> "Dolar";
      case "EUR" -> "Euro";
      case "JPY" -> "Iene";
      case "ARS" -> "Peso Argentino";
      case "CTM" -> "Custom";
      default -> "Abreviação inválida";
    };
  }

  public static void showOptions() {
    System.out.println("===================================\n");
    System.out.println("Bem vindo ao conversor de moedas!\n");
    System.out.println("===================================\n");

    System.out.println("Para iniciar selecione uma das opções abaixo:\n");

    System.out.println("BRL - Converter Real");
    System.out.println("USD - Converter Dolar");
    System.out.println("EUR - Converter Euro");
    System.out.println("JPY - Converter Iene");
    System.out.println("ARS - Converter Peso Argentino");
    System.out.println("CTM - Converter Custom");
    System.out.println("0 - Sair");
  }

  public static void clearConsole() {
    System.out.flush();
  }

  public static boolean checkInput(String input) {
    return (Arrays.asList(currency).contains(input.toUpperCase()));
  }

  public static void showRemaingOptions(String fromCurrency) {
    System.out.println("=================================\n");
    System.out.println("Moeda Selecionada - " + fromCurrency);
    System.out.println("Escolha uma moeda para converter\n");

    for (String curr : currency) {
      if (!fromCurrency.equals(curr.toUpperCase())) System.out.println(curr + " - " + abbrToString(curr));
    }
  }

  public static void showResult(ConversionResponse conversionResponse) {
    System.out.println("=================================\n");
    System.out.println("Resultado\n");
    System.out.println(conversionResponse.getFromCurrency() + " -> " + conversionResponse.getToCurrency());
    System.out.println(
        conversionResponse.getOriginalAmount() + " -> " + conversionResponse.getConvertedAmount() + "\n");
  }

  public static void showResultOptions() {
    System.out.println("=================================\n");
    System.out.println("Deseja continuar?\n");
    System.out.println("Qualquer tecla - Sim");
    System.out.println("0 - Não");
  }

  public static void showIncorrectInputMessage() {
    ConsoleViewUtils.showMessage("Escolha uma opção valida");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    ConsoleViewUtils.clearConsole();
  }
}
