package org.sample;

//"islandsNumber" independent cliques
public class XCliqueGraph extends Graph {
    public XCliqueGraph(int islandsNumber)
    {
        if(islandsNumber < 0)
            islandsNumber = 4;
        for(int i = 1; i < POD.nodesNum+1; ++i)
        {
            nodeList.add(i);
        }
        int currentNode;
        int islandSize = POD.nodesNum/(islandsNumber-1);
        for(int island = 0; island<islandsNumber; ++island,++currentNode)
        {
            currentNode = island*islandSize;
            for(int i = currentNode;i<currentNode+islandSize-1;++i)
                addEdge(i,i+1);
        }
    }
}