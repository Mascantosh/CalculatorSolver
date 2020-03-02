package solver;

import command.CalculatorCommand;
import command.CalculatorCommandExecuteException;
import input.InputData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;

public class OneNodeSolver implements Callable<Collection<CommandsResult>> {
    private final InputData data;
    private final CalculatorCommand baseCommand;
    private final CalculatorCommand[] buffer;
    private final Collection<CommandsResult> results;

    public OneNodeSolver(InputData data, CalculatorCommand baseCommand) {
        this.data = data;
        this.baseCommand = baseCommand;
        buffer = new CalculatorCommand[data.moves()];
        buffer[0] = baseCommand;
        results = new ArrayList<>();
    }

    @Override
    public Collection<CommandsResult> call() throws Exception {
        final int curValue = baseCommand.execute(data.startValue());

        solve(curValue, 1);

        return results;
    }

    private void solve(int curValue, int level) {
        if (level == buffer.length) {
            return;
        }
        for (CalculatorCommand currentCommand : data.commands()) {
            try {
                buffer[level] = currentCommand;
                final int commandValue = currentCommand.execute(curValue);
                if (commandValue == data.expected()) {
                    results.add(new CommandsResult(buffer));
                    continue;
                }
                solve(commandValue, level + 1);
            } catch (CalculatorCommandExecuteException ignore) {
                return;
            }
            Arrays.fill(buffer, level, buffer.length, null);
        }
    }
}
