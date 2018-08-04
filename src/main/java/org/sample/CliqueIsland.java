/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

public class CliqueIsland {
    @State(Scope.Benchmark)
    public static class GraphState
    {
        public Graph graphChars = new Graph();
        public GraphState() {
            for(int i = 1; i < POD.nodesNum-1; ++i)
            {
                graphChars.addEdge(1, i);
            }

            for(int z = 1; z < graphChars.nodeList.size();++z)
            {
                for(int y = z+1; y < graphChars.nodeList.size();++y)
                {
                    graphChars.addEdge(z,y);
                }
            }
            System.out.println("CLIQUE ISLAND BENCHMARK");
            System.out.println("NODES: "+graphChars.nodeCount);
//            graphChars.addEdge('a', 'b');
//            graphChars.addEdge('a', 'c');
//            graphChars.addEdge('a', 'd');
//            graphChars.addEdge('a', 'e');
//            graphChars.addEdge('a', 'f');
//            graphChars.addEdge('a', 'g');
//            graphChars.addEdge('a', 'y');
//            graphChars.addEdge('a', 'z');
//            graphChars.addEdge('a', 'w');
        }
    }
    //    @Setup(Level.Trial)
//    public void doSetup() {
//        public static int i = 0;
//        System.out.println("Do Setup #" + i);
//    }
//
//    @TearDown(Level.Trial)
//    public void doTearDown() {
//        System.out.println("Do TearDown #" + i);
//    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public static String testtest(GraphState graphState) {
        return ""+graphState.graphChars.countGraphs();
    }

    public void test1()
    {
        Graph graphChars = new Graph();
        for(int i = 0; i < POD.nodesNum-1; ++i)
        {
            graphChars.addEdge(1, i);
        }
        System.out.println(graphChars.countGraphs());
    }
}
