package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
public class ThreeIsland {


    @State(Scope.Benchmark)
    public static class GraphState
    {
        public Graph graphChars = new Graph();
        public GraphState() {
            // add 3 independent node groups
            long i = 1, k = i+POD.nodesNum/3 - 1;
            for(int j = 0;j<3;++j)
            {
                for (; i < k; ++i)
                {
                    graphChars.addEdge(i, i + 1);
                }
                ++i;
                k = i + POD.nodesNum/3 - 1;
            }
            System.out.println("3 ISLAND BENCHMARK");
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