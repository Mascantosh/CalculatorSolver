package command;

public class Reverse extends BaseCommand {
    public Reverse() {
        super("Reverse");
    }

    @Override
    public String toString() {
        return sign;
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        StringBuilder builder = new StringBuilder(String.valueOf(digit));
        return Integer.parseInt(builder.reverse().toString());
    }
}
