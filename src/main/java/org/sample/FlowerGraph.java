package org.sample;

public class FlowerGraph extends Graph {
    public FlowerGraph()
    {
        nodeList.add(1);
        // add 1 continous node group
        for (int i = 2; i < POD.nodesNum + 1; ++i) {
            nodeList.add(i);
            addEdge(1, i);
        }

    }
}