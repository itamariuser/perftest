package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class ConcurrentIslandBenchmark {

    @State(Scope.Benchmark)
    public static class GraphState {
        public GraphConcurrent graphConcurrent = new GraphConcurrent();
        public GraphState()
        {
            for(int i = 0; i< 503223;++i) {
                graphConcurrent.addNode(i);
            }
            graphConcurrent.addNode(2);
            graphConcurrent.addNode(5642);
            graphConcurrent.addNode(645642435);
            graphConcurrent.addEdge(1,2);
            graphConcurrent.addEdge(1,23);
            graphConcurrent.startAlgorithm(3);
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