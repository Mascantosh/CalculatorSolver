package command;

public class Sign extends BaseCommand {
    public Sign() {
        super("+/-");
    }

    @Override
    public int execute(int digit) {
        return -digit;
    }

    @Override
    public String toString() {
        return sign;
    }
}
