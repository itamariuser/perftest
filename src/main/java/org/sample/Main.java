package org.sample;

import java.io.IOException;

public class Main {
    public static void main(String args[])
    {
        try{System.in.read();}catch(IOException e){}
//        CliqueGraph cg = new CliqueGraph();
//        System.out.println(cg.countGraphs());

        GraphConcurrent graphConcurrent = new GraphConcurrent();

    }
}