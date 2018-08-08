package org.sample;

import java.io.IOException;
//TODO: Debug GraphConcurrent?

public class Main {
    public static void main(String args[])
    {
        try{System.in.read();}catch(IOException e){}
//        FlowerGraph cg = new FlowerGraph();
//        System.out.println(cg.countGraphs());
//        cg.countGraphs();
        FourCliqueGraph z = new FourCliqueGraph();
//        for(int i = 1; i < POD.nodesNum+1; ++i)
//        {
//            q.addNode(i);
//            q.addEdge(1, i);
//        }
//        q.addNode(31231);
//        q.addEdge(1, 31231);
//
//        int size = q.nodeTree.size();
//        for(int z = 1; z < POD.nodesNum+1;++z)
//        {
//            for(int y = 1; y < POD.nodesNum+1;++y)
//            {
//                if(y!=z) {
//                    q.addNode(y);
//                    q.addEdge(z, y);
//                }
//            }
//        }
        System.out.println("CCs: "+z.countGraphs());
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
