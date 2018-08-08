package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

public class CliqueIslandsBenchmark {
    @State(Scope.Benchmark)
    public static class GraphState
    {
        public FourCliqueGraph graphChars = new FourCliqueGraph();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState)
    {
        graphState.graphChars.countGraphs();
        return "";
    }
}