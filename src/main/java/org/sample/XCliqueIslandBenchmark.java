package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class XCliqueIslandBenchmark {
    @State(Scope.Benchmark)
    public static class GraphState
    {
        public XCliqueGraph graphChars = new XCliqueGraph(4);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void testtest(GraphState graphState, Blackhole b)
    {
        b.consume(graphState.graphChars.countGraphs());
    }
}