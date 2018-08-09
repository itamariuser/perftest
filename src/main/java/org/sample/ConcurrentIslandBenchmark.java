package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
public class ConcurrentIslandBenchmark {

    @State(Scope.Benchmark)
    public static class GraphState {
        public static CGraph cGraph = new CGraph();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void testtest(GraphState graphState, Blackhole b) {
        b.consume(graphState.cGraph.graphConcurrent.startAlgorithm(4));
    }
}