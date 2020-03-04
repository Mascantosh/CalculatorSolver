package command;

public class Shift extends BaseCommand {
    public Shift() {
        super("<<");
    }

    @Override
    public String toString() {
        return sign;
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        return digit / 10;
    }
}
