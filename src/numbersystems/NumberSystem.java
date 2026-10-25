package numbersystems;

public interface NumberSystem {

    long toDecimal(String value);

    String fromDecimal(long value);

    boolean isValid(String value);

    String getName();
}
