package org.sample;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
public class FourIsland {


//    @State(Scope.Benchmark)
    public static class GraphState
    {
        public FourGraph graphChars = new FourGraph();
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        return ""+graphState.graphChars.countGraphs();
    }

    ;
}