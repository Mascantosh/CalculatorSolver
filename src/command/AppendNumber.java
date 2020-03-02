package command;

public class AppendNumber extends BaseCommand {
    private final int appendDigit;

    public AppendNumber(int appendDigit) {
        super(String.valueOf(appendDigit));
        this.appendDigit = appendDigit;
    }

    @Override
    public String toString() {
        return String.valueOf(appendDigit);
    }

    @Override
    public int execute(int digit) throws CalculatorCommandExecuteException {
        return digit * 10 + appendDigit;
    }
}
