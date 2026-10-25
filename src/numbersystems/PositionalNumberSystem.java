package numbersystems;

public abstract class PositionalNumberSystem implements NumberSystem {

    protected final int base;

    private static final char[] DIGITS =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public PositionalNumberSystem(int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException(
                    "Base must be between 2 and 36."
            );
        }

        this.base = base;
    }

    public int getBase() {
        return base;
    }

    // Convert a number from its current base to decimal manually
    @Override
    public long toDecimal(String value) {

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(
                    "Number cannot be empty."
            );
        }

        int start = 0;
        boolean negative = false;

        // Handle an optional sign
        if (value.charAt(0) == '-') {
            negative = true;
            start = 1;
        } else if (value.charAt(0) == '+') {
            start = 1;
        }

        if (start == value.length()) {
            throw new IllegalArgumentException(
                    "Number must contain at least one digit."
            );
        }

        /*
         * Accumulate the result as a negative number.
         * This approach also supports Long.MIN_VALUE safely.
         */
        long limit = negative
                ? Long.MIN_VALUE
                : -Long.MAX_VALUE;

        long multiplicationLimit = limit / base;

        long result = 0;

        for (int i = start; i < value.length(); i++) {

            char ch = Character.toUpperCase(value.charAt(i));

            int digit = getDigitValue(ch);

            // Reject invalid digits for this base
            if (digit < 0 || digit >= base) {
                throw new IllegalArgumentException(
                        "Invalid digit '" + ch
                                + "' for " + getName()
                                + " number system."
                );
            }

            // Check for overflow before multiplication
            if (result < multiplicationLimit) {
                throw new IllegalArgumentException(
                        "Number is too large."
                );
            }

            result = result * base;

            // Check for overflow before subtraction
            if (result < limit + digit) {
                throw new IllegalArgumentException(
                        "Number is too large."
                );
            }

            result = result - digit;
        }

        // Convert back to the appropriate signed result
        if (negative) {
            return result;
        }

        return -result;
    }

    // Convert a decimal number to the current base manually
    @Override
    public String fromDecimal(long value) {

        if (value == 0) {
            return "0";
        }

        boolean negative = value < 0;

        /*
         * Work with a non-positive number to avoid overflow
         * when the input is Long.MIN_VALUE.
         */
        long number;

        if (value > 0) {
            number = -value;
        } else {
            number = value;
        }

        char[] result = new char[65];

        int index = result.length;

        // Repeated division and remainder calculation
        while (number <= -base) {

            int remainder = (int) (-(number % base));

            result[--index] = DIGITS[remainder];

            number = number / base;
        }

        // Store the final digit
        result[--index] = DIGITS[(int) (-number)];

        // Add the negative sign when necessary
        if (negative) {
            result[--index] = '-';
        }

        // Return only the characters that contain the answer
        return new String(
                result,
                index,
                result.length - index
        );
    }

    // Validate input using our own conversion algorithm
    @Override
    public boolean isValid(String value) {

        if (value == null || value.isEmpty()) {
            return false;
        }

        try {
            toDecimal(value);
            return true;

        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Convert a digit character into its numeric value
    private int getDigitValue(char ch) {

        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }

        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A' + 10;
        }

        return -1;
    }
}