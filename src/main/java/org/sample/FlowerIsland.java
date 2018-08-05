package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class FlowerIsland {

    @State(Scope.Benchmark)
    public static class GraphState {
        public FlowerGraph graphChars = new FlowerGraph();
    }

    //DeepBenchmark.testtest  avgt    5  3643.870 ± 309.231  us/op
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        return ""+graphState.graphChars.countGraphs();
    }

    ;
}