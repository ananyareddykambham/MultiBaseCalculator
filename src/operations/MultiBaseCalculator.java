
package operations;

import numbersystems.NumberSystem;
import numbersystems.DecimalSystem;
import numbersystems.BinarySystem;
import numbersystems.OctalSystem;
import numbersystems.HexadecimalSystem;
import numbersystems.RomanNumeralSystem;

import exceptions.DivisionByZeroException;
import exceptions.InvalidNumberException;

import java.util.HashMap;
import java.util.Map;

public class MultiBaseCalculator implements Calculator {

    private final Map<String, NumberSystem> numberSystems =
            new HashMap<>();

    public MultiBaseCalculator() {
        numberSystems.put("Decimal", new DecimalSystem());
        numberSystems.put("Binary", new BinarySystem());
        numberSystems.put("Octal", new OctalSystem());
        numberSystems.put("Hexadecimal", new HexadecimalSystem());
        numberSystems.put("Roman", new RomanNumeralSystem());
    }

    public NumberSystem getNumberSystem(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "Number system cannot be null."
            );
        }

        NumberSystem system = numberSystems.get(name);

        if (system == null) {
            throw new IllegalArgumentException(
                    "Unsupported number system: " + name
            );
        }

        return system;
    }

    @Override
    public long calculate(long a, long b, String operator) {
        if (operator == null) {
            throw new IllegalArgumentException(
                    "Operator cannot be null."
            );
        }

        switch (operator) {
            case "+":
                return Math.addExact(a, b);

            case "-":
                return Math.subtractExact(a, b);

            case "*":
                return Math.multiplyExact(a, b);

            case "/":
                if (b == 0) {
                    throw new DivisionByZeroException(
                            "Division by zero is not allowed."
                    );
                }

                if (a == Long.MIN_VALUE && b == -1) {
                    throw new ArithmeticException(
                            "Division overflow."
                    );
                }

                return a / b;

            default:
                throw new IllegalArgumentException(
                        "Unsupported operator: " + operator
                );
        }
    }

    public String calculateInSystem(
            String firstValue,
            String secondValue,
            String systemName,
            String operator) {

        NumberSystem system = getNumberSystem(systemName);

        if (!system.isValid(firstValue)) {
            throw new InvalidNumberException(
                    "Invalid first operand for "
                            + systemName + ": " + firstValue
            );
        }

        if (!system.isValid(secondValue)) {
            throw new InvalidNumberException(
                    "Invalid second operand for "
                            + systemName + ": " + secondValue
            );
        }

        long a = system.toDecimal(firstValue);
        long b = system.toDecimal(secondValue);

        long result = calculate(a, b, operator);

        return system.fromDecimal(result);
    }
}
