## Second project for Oracle Alura Next-Generation

## Currency Converter

This is a simple currency converter program written in Java. It allows users to convert an amount from one currency to another using real-time exchange rates from an API.

### Setup

Ensure you have Java installed on your system to run this program.

### Usage

1. Clone the repository or download the `Main.java` file.
2. Compile the `Main.java` file using `javac Main.java`.
3. Run the compiled program using `java Main`.

### Description

The program presents a menu with two options:
- Option 1: Perform a currency conversion
- Option 0: Terminate the program

For option 1:
- The user is prompted to enter the currency to convert from, the amount, and the currency to convert to.
- The program fetches real-time exchange rate data from an API using the provided API key.
- It then performs the currency conversion and displays the result.

### Supported Currencies

You can find the list of supported currencies [here](https://www.exchangerate-api.com/docs/supported-currencies).

### Example

| Cod    | Currency           | Country        |
|--------|--------------------|----------------|
| ARS    | Peso argentino     | Argentina      |
| BOB    | Boliviano boliviano| Bolivia        |
| BRL    | Real brasileño     | Brasil         |
| CLP    | Peso chileno       | Chile          |
| COP    | Peso colombiano    | Colombia       |
| USD    | Dólar estadounidense| Estados Unidos|

### Dependencies

- Gson library for JSON processing.

### Note

- Make sure to replace the `apiKey` variable with your own API key to fetch exchange rate data from the API.