package main;

import command.*;
import input.InputData;
import solver.Solver;

public class Main {

    public static void main(String[] args) {
        CalculatorCommand[] commands = new CalculatorCommand[2];

        commands[0] = new Reverse();
        commands[1] = new Minus(1);

        InputData data = new InputData(1101, 4, 100, commands);

        try (Solver solver = new Solver(data)) {
            solver.solve().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
