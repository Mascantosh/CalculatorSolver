package input;

import command.CalculatorCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommandInput {
    private final Map<Integer, CalculatorCommand> inputMapper;
    private final String inputInfo;

    public CommandInput(CalculatorCommand[] commands) {
        this.inputMapper = initMapper(commands);
        inputInfo = initInfo();
    }

    private Map<Integer, CalculatorCommand> initMapper(CalculatorCommand[] commands) {
        return IntStream.range(0, commands.length)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), ind -> commands[ind]));
    }

    private String initInfo() {
        return inputMapper.entrySet().stream()
                .map(integerCalculatorCommandEntry -> integerCalculatorCommandEntry.getKey() + ". " + integerCalculatorCommandEntry.getValue().toString())
                .collect(Collectors.joining("\n"));
    }

    public Set<CalculatorCommand> readInput() {
        System.out.println("To end input print \"Done\"");
        System.out.println(inputInfo);

        Set<CalculatorCommand> commands = new HashSet<>();

        try {
            //Don't close BufferedReader because we will close System.in
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String cmd;
            while (!"done".equalsIgnoreCase(cmd = reader.readLine())) {
                final Integer choose = Integer.valueOf(cmd);

                if (inputMapper.containsKey(choose)) {
                    commands.add(inputMapper.get(choose));
                } else {
                    System.out.println("Chosen wrong number, please choose correct one");
                }

                System.out.println(inputInfo);
            }
        } catch (IOException ignore) {

        }

        return commands;
    }
}
