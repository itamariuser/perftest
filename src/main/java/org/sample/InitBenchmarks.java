package org.sample;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

public class InitBenchmarks {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void CliqueInit(Blackhole b) {
        b.consume(new CliqueGraph());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void XCliqueInit(Blackhole b) {
        b.consume(new XCliqueGraph(4));
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void XSnakeInit(Blackhole b) {
        b.consume(new XSnakeGraph());
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void FlowerInit(Blackhole b) {
        b.consume(new FlowerGraph());
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static void CInit(Blackhole b) {
        b.consume(new CGraph());
    }
}