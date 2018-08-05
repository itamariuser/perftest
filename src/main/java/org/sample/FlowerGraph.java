package org.sample;

public class FlowerGraph extends Graph {
    public FlowerGraph()
    {
        // add 1 continous node group
        for (int i = 0; i < POD.nodesNum - 1; ++i) {
            addEdge(1, i);
        }
        System.out.println("1 ISLAND BENCHMARK");
        System.out.println("NODES: " + nodeList.size());

    }
}