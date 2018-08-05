package org.sample;

import java.util.ArrayList;
import java.util.HashSet;

//Basically a clique the size of POD.nodesNum
class CliqueGraph extends Graph {
    public CliqueGraph()
    {
        edgeList = new ArrayList<Edge>();
        nodeList = new ArrayList<Integer>();
        for(int i = 1; i < POD.nodesNum-1; ++i)
        {
            addEdge(1, i);
        }
        int size = nodeList.size();
        for(int z = 1; z < size;++z)
        {
            for(int y = z+1; y < size;++y)
            {
                addEdge(z,y);
            }
        }
        System.out.println("CLIQUE ISLAND BENCHMARK");
        System.out.println("NODES: "+nodeList.size());
    }
}