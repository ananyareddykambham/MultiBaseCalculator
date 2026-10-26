import operations.MultiBaseCalculator;

public class CalculatorTest {

    public static void main(String[] args) {

        MultiBaseCalculator calculator = new MultiBaseCalculator();

        System.out.println("Decimal: "
                + calculator.calculateInSystem("10", "5", "Decimal", "+"));

        System.out.println("Binary: "
                + calculator.calculateInSystem("1010", "101", "Binary", "+"));

        System.out.println("Octal: "
                + calculator.calculateInSystem("12", "5", "Octal", "+"));

        System.out.println("Hexadecimal: "
                + calculator.calculateInSystem("A", "5", "Hexadecimal", "+"));
   
                System.out.println("Subtraction: "
        + calculator.calculateInSystem("10", "5", "Decimal", "-"));

System.out.println("Multiplication: "
        + calculator.calculateInSystem("10", "5", "Decimal", "*"));

System.out.println("Division: "
        + calculator.calculateInSystem("10", "5", "Decimal", "/"));
    try {
    System.out.println(
            calculator.calculateInSystem("10", "0", "Decimal", "/")
    );
} catch (ArithmeticException e) {
    System.out.println("Division by zero handled: " + e.getMessage());
}       
try {
    calculator.calculate(Long.MAX_VALUE, 1, "+");
} catch (ArithmeticException e) {
    System.out.println("Addition overflow handled: " + e.getMessage());
}
try {
    calculator.calculateInSystem("102", "10", "Binary", "+");
} catch (IllegalArgumentException e) {
    System.out.println("Invalid binary input handled: " + e.getMessage());
}
try {
    calculator.calculate(Long.MIN_VALUE, 1, "-");
} catch (ArithmeticException e) {
    System.out.println("Subtraction overflow handled: " + e.getMessage());
}
try {
    calculator.calculate(Long.MAX_VALUE, 2, "*");
} catch (ArithmeticException e) {
    System.out.println("Multiplication overflow handled: " + e.getMessage());
}
try {
    calculator.calculate(Long.MIN_VALUE, -1, "/");
} catch (ArithmeticException e) {
    System.out.println("Division overflow handled: " + e.getMessage());
}
try {
    calculator.calculate(10, 5, "%");
} catch (IllegalArgumentException e) {
    System.out.println("Unsupported operator handled: " + e.getMessage());
}
System.out.println("Roman addition: "
        + calculator.calculateInSystem("X", "V", "Roman", "+"));

System.out.println("Roman subtraction: "
        + calculator.calculateInSystem("X", "V", "Roman", "-"));
    }
}