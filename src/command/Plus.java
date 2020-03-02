package command;

public class Plus extends BaseCommand {
    private final int plus;

    public Plus(int plus) {
        super("+");
        this.plus = plus;
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        return this.plus + digit;
    }

    @Override
    public String toString() {
        return sign + plus;
    }
}
