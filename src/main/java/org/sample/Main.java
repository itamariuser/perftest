package org.sample;

import java.io.IOException;

public class Main {
    public static void main(String args[])
    {
        try{System.in.read();}catch(IOException e){}
//        CliqueGraph cg = new CliqueGraph();
//        System.out.println(cg.countGraphs());

        GraphConcurrent graphConcurrent = new GraphConcurrent();
        graphConcurrent.addNode(1);
        graphConcurrent.addNode(2);
        graphConcurrent.addNode(5642);
        graphConcurrent.addNode(645642435);
        graphConcurrent.addEdge(1,2);
        graphConcurrent.addEdge(1,23);
    }
}