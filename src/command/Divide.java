package command;

public class Divide implements CalculatorCommand {
    private final int divider;
    public Divide(int digit) {
        this.divider = digit;
    }

    @Override
    public int execute(int digit) {
        return digit / divider;
    } //TODO we cannot get double result check it
}
