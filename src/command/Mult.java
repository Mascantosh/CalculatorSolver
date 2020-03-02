package command;

public class Mult extends BaseCommand {
    private final int mult;

    public Mult(int mult) {
        super("*");
        this.mult = mult;
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        return digit * mult;
    }

    @Override
    public String toString() {
        return sign + mult;
    }
}
