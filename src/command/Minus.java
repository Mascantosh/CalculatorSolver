package command;

public class Minus implements CalculatorCommand {
    private final int commandDigit;

    public Minus(int commandDigit) {
        this.commandDigit = commandDigit;
    }

    @Override
    public int execute(int digit) {
        return digit - commandDigit;
    }
}
