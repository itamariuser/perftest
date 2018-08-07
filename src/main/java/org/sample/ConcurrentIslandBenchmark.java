package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class ConcurrentIslandBenchmark {

    @State(Scope.Benchmark)
    public static class GraphState {
        public static CGraph cGraph = new CGraph();
    }

    //DeepBenchmark.testtest  avgt    5  3643.870 ± 309.231  us/op
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        graphState.cGraph.graphConcurrent.startAlgorithm(4);
        return "";
    }
}