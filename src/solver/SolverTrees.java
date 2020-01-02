package solver;

import command.CalculatorCommand;
import command.Sign;
import solver.tree.Node;

import java.lang.reflect.Array;

public class SolverTrees {
    private final Node<CalculatorCommand>[] roots;

    public SolverTrees(CalculatorCommand[] commands) {
        this.roots = buildTrees(commands);
    }

    private Node<CalculatorCommand>[] buildTrees(CalculatorCommand[] commands) {
        Node<CalculatorCommand>[] res = new Node[commands.length];



        return res;
    }
}
