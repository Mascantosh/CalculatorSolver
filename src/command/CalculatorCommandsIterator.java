package command;

import java.util.Iterator;

public class CalculatorCommandsIterator implements Iterable<String> {
    private final CalculatorCommand[] commands;

    public CalculatorCommandsIterator(CalculatorCommand[] commands) {
        this.commands = commands;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int curIndex;

            @Override
            public boolean hasNext() {
                return curIndex < commands.length && commands[curIndex] != null;
            }

            @Override
            public String next() {
                return commands[curIndex++].toString();
            }
        };
    }
}
