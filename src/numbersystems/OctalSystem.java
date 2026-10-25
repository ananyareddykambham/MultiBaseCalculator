package numbersystems;

public class OctalSystem extends PositionalNumberSystem {

    public OctalSystem() {
        super(8);
    }

    @Override
    public String getName() {
        return "Octal";
    }
}
