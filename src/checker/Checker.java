package checker;

import command.CalculatorCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checker {
    public int check(CalculatorCommand[] commands, int startValue, int expected) {
        //TODO sort array
        List<CalculatorCommand> calculatorCommands = new ArrayList<>(Arrays.asList(commands));

        if (startValue == 0) {
            //TODO enum
            final String[] discard = {"Reverse", "*", "/"};
            calculatorCommands.removeIf(
                    calculatorCommand -> Arrays.stream(discard)
                                                .anyMatch(s -> calculatorCommand.toString().startsWith(s)));
        }

        return calculatorCommands.size();
    }

}
