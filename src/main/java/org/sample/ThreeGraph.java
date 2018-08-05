package org.sample;

public class ThreeGraph extends Graph{
    public ThreeGraph()
    {
        // add 3 independent node groups
        long i = 1, k = i+POD.nodesNum/3 - 1;
        for(int j = 0;j<3;++j)
        {
            for (; i < k; ++i)
            {
                addEdge(i, i + 1);
            }
            ++i;
            k = i + POD.nodesNum/3 - 1;
        }
        System.out.println("3 ISLAND BENCHMARK");
        System.out.println("NODES: "+nodeList.size());
    }
}