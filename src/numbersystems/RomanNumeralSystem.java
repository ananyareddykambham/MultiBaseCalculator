
package numbersystems;

import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidRomanException;
import exceptions.OutOfRangeException;

public class RomanNumeralSystem implements NumberSystem {

    private final Map<Character, Integer> values = new HashMap<>();

    private static final int[] DECIMAL_VALUES = {
            1000, 900, 500, 400, 100, 90, 50,
            40, 10, 9, 5, 4, 1
    };

    private static final String[] ROMAN_SYMBOLS = {
            "M", "CM", "D", "CD", "C", "XC", "L",
            "XL", "X", "IX", "V", "IV", "I"
    };

    public RomanNumeralSystem() {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    // Convert lowercase Roman symbols manually to uppercase.
    private char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 'a' + 'A');
        }
        return ch;
    }

    private String normalize(String value) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            result.append(toUpper(value.charAt(i)));
        }

        return result.toString();
    }

    @Override
    public long toDecimal(String value) {
        if (!isValid(value)) {
            throw new InvalidRomanException(
                    "Invalid Roman numeral: " + value);
        }

        String roman = normalize(value);
        long result = 0;

        for (int i = 0; i < roman.length(); i++) {
            int current = values.get(roman.charAt(i));

            if (i + 1 < roman.length()
                    && current < values.get(roman.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    @Override
    public String fromDecimal(long value) {
        if (value < 1 || value > 3999) {
            throw new OutOfRangeException(
                    "Value must be between 1 and 3999: " + value);
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < DECIMAL_VALUES.length; i++) {
            while (value >= DECIMAL_VALUES[i]) {
                roman.append(ROMAN_SYMBOLS[i]);
                value -= DECIMAL_VALUES[i];
            }
        }

        return roman.toString();
    }

    @Override
    public boolean isValid(String value) {
        if (value == null || value.length() == 0) {
            return false;
        }

        String roman = normalize(value);
        long result = 0;

        for (int i = 0; i < roman.length(); i++) {
            Integer current = values.get(roman.charAt(i));

            if (current == null) {
                return false;
            }

            if (i + 1 < roman.length()) {
                Integer next = values.get(roman.charAt(i + 1));

                if (next == null) {
                    return false;
                }

                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }
            } else {
                result += current;
            }
        }

        if (result < 1 || result > 3999) {
            return false;
        }

        String canonical = fromDecimal(result);

        if (canonical.length() != roman.length()) {
            return false;
        }

        for (int i = 0; i < roman.length(); i++) {
            if (canonical.charAt(i) != roman.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return "Roman";
    }
}
