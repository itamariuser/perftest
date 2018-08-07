package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class ConcurrentIslandBenchmark {

    @State(Scope.Benchmark)
    public static class GraphState {
        public GraphConcurrent graphConcurrent = new GraphConcurrent();
        public GraphState()
        {
            graphConcurrent.addNode(1);
            for (int i = 2; i < POD.nodesNum + 1; ++i) {
                graphConcurrent.addEdge(1, i);
            }
        }
    }

    //DeepBenchmark.testtest  avgt    5  3643.870 ± 309.231  us/op
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        graphState.graphConcurrent.startAlgorithm(4);
        return "";
    }
}