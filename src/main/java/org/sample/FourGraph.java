package org.sample;

public class FourGraph extends Graph{
    public FourGraph()
    {
        // add 3 independent node groups
        long i = 1, k = i+POD.nodesNum/4 - 1;
        for(int j = 0;j<4;++j)
        {
            for (; i < k; ++i)
            {
                addEdge(i, i + 1);
            }
            ++i;
            k = i + POD.nodesNum/4 - 1;
        }
        System.out.println("4 ISLAND BENCHMARK");
        System.out.println("NODES: "+nodeList.size());
    }
}