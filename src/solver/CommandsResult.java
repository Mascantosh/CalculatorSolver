package solver;

import command.CalculatorCommand;
import command.CalculatorCommandsIterator;

import java.util.Arrays;

public class CommandsResult {
    private final CalculatorCommandsIterator iterator;

    public CommandsResult(CalculatorCommand[] commands) {
        final CalculatorCommand[] clone = Arrays.copyOf(commands, commands.length);
        iterator = new CalculatorCommandsIterator(clone);
    }

    @Override
    public String toString() {
        return String.join(" -> ", iterator);
    }
}
