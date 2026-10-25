import numbersystems.*;

public class NumberSystemTest {

    public static void main(String[] args) {

        NumberSystem decimal = new DecimalSystem();
        NumberSystem binary = new BinarySystem();
        NumberSystem octal = new OctalSystem();
        NumberSystem hex = new HexadecimalSystem();

        // 1. Convert different bases to decimal
        System.out.println("=== TO DECIMAL TESTS ===");

        System.out.println("Decimal 25 = "
                + decimal.toDecimal("25"));

        System.out.println("Binary 1010 = "
                + binary.toDecimal("1010"));

        System.out.println("Octal 17 = "
                + octal.toDecimal("17"));

        System.out.println("Hexadecimal 1A = "
                + hex.toDecimal("1A"));

        System.out.println("Binary 11111111 = "
                + binary.toDecimal("11111111"));

        System.out.println("Hexadecimal FF = "
                + hex.toDecimal("FF"));


        // 2. Convert decimal to different bases
        System.out.println("\n=== FROM DECIMAL TESTS ===");

        System.out.println("26 to Binary = "
                + binary.fromDecimal(26));

        System.out.println("26 to Octal = "
                + octal.fromDecimal(26));

        System.out.println("26 to Hexadecimal = "
                + hex.fromDecimal(26));

        System.out.println("26 to Decimal = "
                + decimal.fromDecimal(26));


        // 3. Validate input
        System.out.println("\n=== VALIDATION TESTS ===");

        System.out.println("Binary 102 valid? "
                + binary.isValid("102"));

        System.out.println("Octal 89 valid? "
                + octal.isValid("89"));

        System.out.println("Hexadecimal 1G valid? "
                + hex.isValid("1G"));

        System.out.println("Hexadecimal 1a valid? "
                + hex.isValid("1a"));

        System.out.println("Binary -101 valid? "
                + binary.isValid("-101"));

        System.out.println("Empty input valid? "
                + binary.isValid(""));

        System.out.println("Null input valid? "
                + binary.isValid(null));


        // 4. Negative numbers
        System.out.println("\n=== NEGATIVE VALUE TESTS ===");

        System.out.println("Binary -101 to decimal = "
                + binary.toDecimal("-101"));

        System.out.println("Decimal -5 to binary = "
                + binary.fromDecimal(-5));


        // 5. Zero
        System.out.println("\n=== ZERO TESTS ===");

        System.out.println("Decimal 0 to binary = "
                + binary.fromDecimal(0));

        System.out.println("Binary 0 to decimal = "
                + binary.toDecimal("0"));


        // 6. Large numbers
        System.out.println("\n=== LARGE NUMBER TESTS ===");

        System.out.println("Maximum long to hexadecimal = "
                + hex.fromDecimal(Long.MAX_VALUE));

        System.out.println("Minimum long to hexadecimal = "
                + hex.fromDecimal(Long.MIN_VALUE));

        System.out.println("Minimum long converted back = "
                + hex.toDecimal(hex.fromDecimal(Long.MIN_VALUE)));
    }
}