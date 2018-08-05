package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class InitBenchmarks {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static int CliqueInit(CliqueIsland.GraphState graphState) {
        CliqueGraph cliqueGraph = new CliqueGraph();
        return 1;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static int FlowerIslandInit(CliqueIsland.GraphState graphState) {
        FlowerGraph flowerGraph = new FlowerGraph();
        return 1;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static int ThreeIslandInit(CliqueIsland.GraphState graphState) {
        ThreeGraph threeGraph = new ThreeGraph();
        return 1;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static int FourIslandInit(CliqueIsland.GraphState graphState) {
        FourGraph fourGraph = new FourGraph();
        return 1;
    }



}