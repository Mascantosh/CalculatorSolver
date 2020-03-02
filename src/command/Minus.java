package command;

public class Minus extends BaseCommand {
    private final int commandDigit;

    public Minus(int commandDigit) {
        super("-");
        this.commandDigit = commandDigit;
    }

    @Override
    public int execute(int digit) {
        return digit - commandDigit;
    }

    @Override
    public String toString() {
        return sign + commandDigit;
    }
}
