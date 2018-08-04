package org.sample;

import java.util.ArrayList;

//Basically a clique the size of POD.nodesNum
class CliqueGraph extends Graph {
    public CliqueGraph()
    {
        edgeList = new ArrayList<Edge>();
        nodeList = new ArrayList<Node>();
        for(int i = 1; i < POD.nodesNum-1; ++i)
        {
            addEdge(1, i);
        }

        for(int z = 1; z < nodeList.size();++z)
        {
            for(int y = z+1; y < nodeList.size();++y)
            {
                addEdge(z,y);
            }
        }
        System.out.println("CLIQUE ISLAND BENCHMARK");
        System.out.println("NODES: "+nodeCount);
    }
}