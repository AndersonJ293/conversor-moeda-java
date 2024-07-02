package main.java.currencyconverter.dto;


public class ConversionResponse {
    private String fromCurrency;
    private String toCurrency;
    private double originalAmount;
    private double convertedAmount;

    public ConversionResponse(String fromCurrency, String toCurrency, double originalAmount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}
