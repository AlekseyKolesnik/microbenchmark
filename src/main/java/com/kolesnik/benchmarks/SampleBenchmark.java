package com.kolesnik.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@Fork(value = 1)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
public class SampleBenchmark {

    @State(Scope.Thread)
    public static class SampleState {

        @Setup(Level.Trial)
        public void doSetup() {
            sum = 0;
            System.out.print("Do Setup ");
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
            System.out.print("Do TearDown ");
        }

        int a = 1;
        int b = 2;
        int sum;
    }


    @Benchmark
    public void badTestMethod() {
        int a = 1;
        int b = 2;
        int sum = a + b;
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void testMethod(SampleState state, Blackhole blackhole) {
        int sum = state.a + state.b;
        blackhole.consume(sum);
    }
}
