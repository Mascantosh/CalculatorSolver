package input;

import command.CalculatorCommand;

public class InputData {
    private final int startValue;
    private final int moves;
    private final int expected;
    private final CalculatorCommand[] commands;

    public InputData(int startValue, int moves, int expected, CalculatorCommand[] commands) {
        this.startValue = startValue;
        this.moves = moves;
        this.expected = expected;
        this.commands = commands;
    }

    public int startValue() {
        return startValue;
    }

    public int moves() {
        return moves;
    }

    public int expected() {
        return expected;
    }

    public CalculatorCommand[] commands() {
        return commands;
    }
}
