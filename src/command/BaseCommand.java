package command;

public abstract class BaseCommand implements CalculatorCommand {
    protected final String sign;

    public BaseCommand(String sign) {
        this.sign = sign;
    }

    public abstract String toString();
}
