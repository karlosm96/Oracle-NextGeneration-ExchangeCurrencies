
import com.google.gson.FieldNamingPolicy;
import com.reto_2.models.Currency;
import com.reto_2.models.ExchangeRateApiCurrencies;
import com.reto_2.services.CreateExchangeRateURL;
import com.reto_2.services.FetchAPI;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean ignite = true;
        int inputOption;
        Scanner scanner = new Scanner(System.in);
        String apiKey = "yourApiKey";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();

        System.out.println("####### Bienvenido ######\n");

        while (ignite){
            String firstMessage = """
                    Menu de opciones:
                    
                    1- Realizar una conversion
                    0- Finalizar el programa
                    """;
            System.out.println(firstMessage);

            while (true) {
                System.out.println("Por favor, ingrese una opción: ");
                try {
                    inputOption = scanner.nextInt();
                    if (inputOption == 0 || inputOption == 1) {
                        break;
                    }
                    System.out.println("Error: Por favor, ingrese un número válido");
                } catch (InputMismatchException e) {
                    System.out.println("Error: El dato ingresado es invalido");
                    scanner.next();
                }
            }


            switch (inputOption){
                case 0:
                    System.out.println("Fin del programa");
                    ignite = false;
                    break;
                case 1:
                    try{
                        System.out.println("Porfavor ingrese el codigo de la moneda que quiere cambiar:");
                        String baseCurrency = scanner.next();
                        System.out.println("Porfavor ingrese el monto que quiere cambiar:");
                        double amount = scanner.nextDouble();
                        System.out.println("Porfavor ingrese el codigo la moneda a la cual quiere cambiar:");
                        String finalCurrency = scanner.next();

                        String fetchData = FetchAPI.fetchData(CreateExchangeRateURL.createURL(apiKey, baseCurrency));
                        ExchangeRateApiCurrencies exchangeRateApiCurrencies = gson.fromJson(fetchData, ExchangeRateApiCurrencies.class);
                        Currency newCurrency = new Currency(exchangeRateApiCurrencies);
                        newCurrency.exchangeCurrency(amount, finalCurrency);
                        System.out.println(newCurrency);

                    } catch (InputMismatchException  e){
                        System.out.println("Error: el monto ingresado es invalido");
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}