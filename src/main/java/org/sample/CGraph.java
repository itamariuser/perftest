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
        long i = 1, k = (long)(i+POD.nodesNum/4 - 1);
        for(int j = 0;j<4;++j)
        {
            for (; i < k; ++i)
            {
                graphConcurrent.addNode((int)i);
                graphConcurrent.addEdge((int)i, (int)i + 1);
            }
            ++i;
            k = i + POD.nodesNum/4 - 1;
        }
        System.out.println("CONCURRENT ISLAND BENCHMARK");
        System.out.println("NODES: "+graphConcurrent.nodeTree.size());
    }
}