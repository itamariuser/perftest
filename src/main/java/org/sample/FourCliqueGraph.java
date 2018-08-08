package org.sample;

import java.util.ArrayList;
import java.util.HashSet;

public class FourCliqueGraph extends Graph {
    public FourCliqueGraph()
    {
        edgeList = new ArrayList<Edge>();
        nodeList = new HashSet<Integer>();//nodeList = new ArrayList<Integer>();
        for(int i = 1; i < POD.nodesNum+1; ++i)
        {
            nodeList.add(i);
        }
        int size = nodeList.size();

        int islandsNumber = 4;

        int currentNode = 0;
        int islandSize = POD.nodesNum/(islandsNumber-1);
        for(int island = 0; island<islandsNumber; ++island,++currentNode)
        {
            currentNode = island*islandSize;
            System.out.println("first: "+currentNode);
            for(int i = currentNode;i<currentNode+islandSize-1;++i)
            {
                System.out.println("#1: "+i+", #2: "+(i+1));
                addEdge(i,i+1);
            }

        }
    }
}