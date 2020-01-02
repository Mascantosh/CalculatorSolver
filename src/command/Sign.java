package command;

public class Sign implements CalculatorCommand {
    @Override
    public int execute(int digit) {
        return -digit;
    }
}
