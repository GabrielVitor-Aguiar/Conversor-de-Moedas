package com.conversor;

/**
 * Classe para realizar a conversão de moedas com base na taxa obtida.
 */
public class CurrencyConversion {
    public static double convert(double amount, double rate) {
        return amount * rate;
    }
}
