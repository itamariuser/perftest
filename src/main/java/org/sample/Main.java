package org.sample;

import java.io.IOException;


public class Main {
    public static void main(String args[])
    {
        try{System.in.read();}catch(IOException e){}
//        FlowerGraph cg = new FlowerGraph();
//        System.out.println(cg.countGraphs());
//        cg.countGraphs();
        GraphConcurrent q = new GraphConcurrent();
        for(int i = 2; i < POD.nodesNum+1; ++i)
        {
            q.addNode(i);
            q.addEdge(1, i);
        }
        int size = q.nodeTree.size();
        for(int z = 1; z < size;++z)
        {
            for(int y = z+1; y < size;++y)
            {
                q.addNode(y);
                q.addEdge(z,y);
            }
        }
        q.startAlgorithm(4);
        System.out.println();
//        GraphConcurrent graphConcurrent = new GraphConcurrent();
//        for(int i = 0; i< 503223;++i)
//            graphConcurrent.addNode(i);
//        graphConcurrent.addNode(2);
//        graphConcurrent.addNode(5642);
//        graphConcurrent.addNode(645642435);
//        graphConcurrent.addEdge(1,2);
//        graphConcurrent.addEdge(1,23);
//        graphConcurrent.startAlgorithm(3);

    }
}