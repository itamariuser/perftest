package org.sample;

import java.io.IOException;
//TODO: Debug GraphConcurrent?

public class Main {
    public static void main(String args[])
    {
        try{System.in.read();}catch(IOException e){}
        XCliqueGraph cg = new XCliqueGraph(4);
        System.out.println(cg.countGraphs());
//        cg.countGraphs();
//        CliqueGraph z = new CliqueGraph();
////        for(int i = 1; i < POD.nodesNum+1; ++i)
////        {
////            q.addNode(i);
////            q.addEdge(1, i);
////        }
////        q.addNode(31231);
////        q.addEdge(1, 31231);
////
////        int size = q.nodeTree.size();
////        for(int z = 1; z < POD.nodesNum+1;++z)
////        {
////            for(int y = 1; y < POD.nodesNum+1;++y)
////            {
////                if(y!=z) {
////                    q.addNode(y);
////                    q.addEdge(z, y);
////                }
////            }
////        }
//        System.out.println("CCs: "+z.countGraphs());
//        CGraph z = new CGraph();
//        z.graphConcurrent.startAlgorithm(4);
//        System.out.println(StaticCounter.counter);
    }
}
