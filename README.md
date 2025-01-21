# Conversor de Moedas

Este projeto é um conversor de moedas simples implementado em Java, utilizando apenas bibliotecas nativas.

## Funcionalidades

- Conversão de moedas com taxas de câmbio em tempo real.
- Moedas suportadas:
  - USD (Dólar Americano)
  - EUR (Euro)
  - BRL (Real Brasileiro)
  - JPY (Iene Japonês)
  - CAD (Dólar Canadense)
  - AUD (Dólar Australiano)

## Como Executar

1. Certifique-se de que possui o JDK 8 ou superior instalado.
2. Compile todos os arquivos do projeto.
3. Execute a classe `ConversorMoeda`.

## Estrutura de Classes

- `ConversorMoeda`: Classe principal.
- `ExchangeRateService`: Gerencia as taxas de câmbio.
- `CurrencyConversion`: Representa uma conversão.
- `Currency`: Representa uma moeda.

## API Utilizada

- API: [Exchange Rate API](https://api.exchangerate-api.com)
