package org.sample;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
public class FourIsland {


    @State(Scope.Benchmark)
    public static class GraphState
    {
        public Graph graphChars = new Graph();
        public GraphState() {
            // add 3 independent node groups
            long i = 1, k = i+POD.nodesNum/4 - 1;
            for(int j = 0;j<4;++j)
            {
                for (; i < k; ++i)
                {
                    graphChars.addEdge(i, i + 1);
                }
                ++i;
                k = i + POD.nodesNum/4 - 1;
            }
            System.out.println("4 ISLAND BENCHMARK");
            System.out.println("NODES: "+graphChars.nodeCount);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        return ""+graphState.graphChars.countGraphs();
    }

    ;
}