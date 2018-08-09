package org.sample;

import java.util.ArrayList;
import java.util.HashSet;

//Basically a clique the size of POD.nodesNum
class CGraph{
    public GraphConcurrent graphConcurrent;
    public CGraph()
    {
        graphConcurrent = new GraphConcurrent();
//        graphConcurrent.addNode(1);
//        for (int i = 2; i < POD.nodesNum + 1; ++i) {
//            graphConcurrent.addNode(i);
//            graphConcurrent.addEdge(1, i);
//        }
//        long i = 1, k = (long)(i+POD.nodesNum/4 - 1);
        graphConcurrent.addNode(1);
        graphConcurrent.addNode(2);
        graphConcurrent.addNode(3);
        graphConcurrent.addEdge(1,2);
        graphConcurrent.addEdge(1,3);
//        graphConcurrent.addEdge(3,2);
//        graphConcurrent.addNode(3);
//        graphConcurrent.addNode(4);
//        graphConcurrent.addNode(5);
//        for(int z = 1;z <2;++z)
//        {
//            for(int q = 1; q<2;++q)
//            {
//                if(q!=z)
//                    graphConcurrent.addEdge(q,z);
//            }
//        }

        graphConcurrent.addNode(6);
        graphConcurrent.addNode(7);
        graphConcurrent.addNode(8);
        graphConcurrent.addEdge(6,7);
        graphConcurrent.addEdge(6,8);
//        graphConcurrent.addEdge(8,7);
//        graphConcurrent.addNode(8);
//        graphConcurrent.addNode(9);
//        graphConcurrent.addNode(10);
//        for(int z = 6;z <7;++z)
//        {
//            for(int q = 6; q<7;++q)
//            {
//                if(q!=z)
//                    graphConcurrent.addEdge(q,z);
//            }
//        }


//        graphConcurrent.addEdge(1,2);
//        graphConcurrent.addEdge(2,1);
//        graphConcurrent.addEdge(3,4);
//        for(int j = 0;j<4;++j)
//        {
//            for (; i < k; ++i)
//            {
//                graphConcurrent.addNode((int)i);
//                graphConcurrent.addEdge((int)i, (int)i + 1);
//            }
//            ++i;
//            k = i + POD.nodesNum/4 - 1;
//        }
        System.out.println("CONCURRENT ISLAND BENCHMARK");
        System.out.println("NODES: "+graphConcurrent.nodeTree.size());
    }
}