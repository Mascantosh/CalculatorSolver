package command;

public class Divide extends BaseCommand {
    private final int divider;

    public Divide(int digit) {
        super("/");
        this.divider = digit;
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        if (digit % divider != 0) {
            throw new CalculatorCommandExecuteException();
        }
        return digit / divider;
    }

    @Override
    public String toString() {
        return sign + divider;
    }
}
