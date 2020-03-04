package solver;

import input.InputData;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solver implements AutoCloseable {
    private final InputData data;
    private final ExecutorService executor;

    public Solver(InputData data) {
        this.data = data;
        executor = Executors.newFixedThreadPool(data.commands().length);
    }


    public List<CommandsResult> solve(int bound) {
        final List<OneNodeSolver> tasks = Stream.iterate(0, baseNode -> ++baseNode)
                .limit(bound)
                .map(baseNode -> new OneNodeSolver(data, data.commands()[baseNode])).collect(Collectors.toList());
        try {
            return executor.invokeAll(tasks).stream()
                    .flatMap(collectionFuture -> collectResults(collectionFuture).stream())
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            return Collections.emptyList();
        }
    }

    private Collection<CommandsResult> collectResults(Future<Collection<CommandsResult>> task) {
        try {
            return task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void close() throws Exception {
        executor.shutdown();
    }
}
