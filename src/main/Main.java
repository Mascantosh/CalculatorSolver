package main;

import command.*;
import input.InputData;
import solver.CommandsResult;
import solver.Solver;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final int size = 3;
        final CalculatorCommand[] commands = new CalculatorCommand[size];

        commands[0] = new Plus(2);
        commands[1] = new Divide(5);
        commands[2] = new Append(0);

        final int startValue = 15;
        final int moves      = 4;
        final int expected   = 10;

        InputData data = new InputData(startValue, moves, expected, commands);

//        Checker checker = new Checker();
//        final int check = checker.check(commands, data.startValue(), data.expected());

//        TODO collect solutions with identical paths
//        example:
//        Solution #1
//        1. /5
//        2. +2
//        3. /5
//        4. 0
//        Solution #2
//        1. /5
//        2. +2
//        3. 0
//        4. /5
        try (Solver solver = new Solver(data)) {
            final List<CommandsResult> results = solver.solve(commands.length);
            IntStream.range(0, results.size())
                    .mapToObj(value -> "Solution #" + (value + 1) + "\n" + results.get(value))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
