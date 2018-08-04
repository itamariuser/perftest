package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class OneIsland {

    @State(Scope.Benchmark)
    public static class GraphState {
        public Graph graphChars = new Graph();

        public GraphState() {
            // add 1 continous node group
            for (int i = 0; i < POD.nodesNum - 1; ++i) {
                graphChars.addEdge(1, i);
            }
            System.out.println("1 ISLAND BENCHMARK");
            System.out.println("NODES: " + graphChars.nodeCount);

        }
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