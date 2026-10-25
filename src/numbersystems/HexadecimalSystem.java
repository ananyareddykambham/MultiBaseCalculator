package numbersystems;

public class HexadecimalSystem extends PositionalNumberSystem {

    public HexadecimalSystem() {
        super(16);
    }

    @Override
    public String getName() {
        return "Hexadecimal";
    }
}