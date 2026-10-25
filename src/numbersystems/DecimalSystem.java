package numbersystems;

public class DecimalSystem extends PositionalNumberSystem {

    public DecimalSystem() {
        super(10);
    }

    @Override
    public String getName() {
        return "Decimal";
    }
}
