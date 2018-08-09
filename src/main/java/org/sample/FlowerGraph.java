package org.sample;
//Basically a star graph
public class FlowerGraph extends Graph {
    public FlowerGraph()
    {
        nodeList.add(1);
        for (int i = 2; i < POD.nodesNum + 1; ++i) {
            nodeList.add(i);
            addEdge(1, i);
        }

    }
}