package numbersystems;

public class BinarySystem extends PositionalNumberSystem {

    public BinarySystem() {
        super(2);
    }

    @Override
    public String getName() {
        return "Binary";
    }
}