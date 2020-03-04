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
        final boolean negative = digit < 0;
        StringBuilder builder = new StringBuilder(String.valueOf(Math.abs(digit)));
        final int parse = Integer.parseInt(builder.reverse().toString());

        return negative ? -parse : parse;
    }
}
