# Conversor de Moedas

Este projeto faz parte de um Challenge da Formação de Java do programa Oracle Next Education (ONE) em parceria com a Alura. O objetivo deste desafio é criar um conversor de moedas funcional, utilizando conceitos de programação em Java e integração com APIs externas.

## Funcionalidades

- Conversões dinâmicas baseadas em taxas de câmbio obtidas pela API.
- Suporte às seguintes moedas:
  - Dólar (USD)
  - Real (BRL)
  - Euro (EUR)
  - Iene (JPY)
- Interface de linha de comando com opções de menu intuitivas.
- Conversões reversas entre moedas (por exemplo, Real para Dólar).
- Tratamento de exceções para erros de API e parsing de JSON.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
Conversor_de_Moedas/
|-- src/
|   |-- com/
|       |-- conversor/
|           |-- ConversorMoeda.java
|           |-- ExchangeRateService.java
|           |-- ApiException.java
|           |-- ParsingException.java
|-- bin/ (diretório para os arquivos compilados)
|-- exemplo_resposta.json
|-- launch.json
|-- README.md
```

## Requisitos

- Java JDK 8 ou superior instalado.
- Dependência externa do Gson (Google JSON library) para parsing de JSON.

## Configuração do Ambiente

1. Instale o Java JDK em sua máquina e configure a variável de ambiente `JAVA_HOME`.
2. Instale o Gson. Se estiver utilizando um gerenciador de dependências (como Maven), adicione o seguinte ao seu arquivo `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```

Se não estiver usando Maven, baixe o .jar do Gson diretamente do [repositório Maven](https://mvnrepository.com/artifact/com.google.code.gson/gson) e adicione ao classpath do projeto.

## Execução

1. Compile os arquivos do projeto:

```bash
javac -d bin src/com/conversor/*.java
```

2. Navegue até o diretório raiz do projeto.

3. Execute o programa:

```bash
java -cp bin com.conversor.ConversorMoeda
```

## Uso

Ao iniciar o programa, será exibido um menu com as opções de conversão. Basta selecionar a opção desejada e inserir o valor a ser convertido. O programa retornará o valor convertido com base na taxa de câmbio atual.

### Exemplo de Uso

Menu inicial:

```
Bem-vindo ao Conversor de Moedas!
Escolha uma opção:
1. Dólar (USD) para Real (BRL)
2. Euro (EUR) para Real (BRL)
3. Iene (JPY) para Real (BRL)
4. Real (BRL) para Dólar (USD)
5. Real (BRL) para Euro (EUR)
6. Real (BRL) para Iene (JPY)
0. Sair
Opção:
```

Selecione uma opção e insira o valor a ser convertido quando solicitado.
