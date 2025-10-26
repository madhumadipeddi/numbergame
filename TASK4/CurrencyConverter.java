import java.util.Scanner;
import java.util.HashMap;
public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.93);
        rates.put("GBP", 0.81);
        rates.put("INR", 83.50);
        rates.put("JPY", 144.20);
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY");
        System.out.print("Enter base currency: ");
        String base = sc.next().toUpperCase();
        while (!rates.containsKey(base)) {
            System.out.print("Invalid currency. Enter again: ");
            base = sc.next().toUpperCase();
        }

        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();
        while (!rates.containsKey(target)) {
            System.out.print("Invalid currency. Enter again: ");
            target = sc.next().toUpperCase();
        }

        System.out.print("Enter amount in " + base + ": ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a number: ");
            sc.next();
        }
        double amount = sc.nextDouble();
        double converted = amount / rates.get(base) * rates.get(target);
        System.out.printf("%.2f %s = %.2f %s%n", amount, base, converted, target);
        sc.close();
    }
}
