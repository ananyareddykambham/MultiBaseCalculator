
package main;

import operations.MultiBaseCalculator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MultiBaseCalculator calculator = new MultiBaseCalculator();

        String[] systems = {
            "Decimal", "Binary", "Octal", "Hexadecimal", "Roman"
        };

        while (true) {
            System.out.println("\n=== MULTI-BASE CALCULATOR ===");
            System.out.println("1. Decimal");
            System.out.println("2. Binary");
            System.out.println("3. Octal");
            System.out.println("4. Hexadecimal");
            System.out.println("5. Roman Numerals");
            System.out.println("6. Exit");
            System.out.print("Choose a number system: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("6")) {
                System.out.println("Thank you for using the calculator!");
                break;
            }

            if (!choice.matches("[1-5]")) {
                System.out.println("Invalid choice. Please select 1-6.");
                continue;
            }

            String system = systems[Integer.parseInt(choice) - 1];

            System.out.println("\nSelected system: " + system);
            System.out.println("Operators: +, -, *, /");
            System.out.print("Enter operator: ");
            String operator = sc.nextLine().trim();

            if (!operator.matches("[+*/-]")) {
                System.out.println("Invalid operator.");
                continue;
            }

            System.out.print("Enter first number: ");
            String first = sc.nextLine().trim();

            System.out.print("Enter second number: ");
            String second = sc.nextLine().trim();

            try {
                String result = calculator.calculateInSystem(
                    first, second, system, operator
                );

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
