package org.sample;

public class XSnakeGraph extends Graph{
    public XSnakeGraph()
    {
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
        System.out.println("XSnakeGraph");
        System.out.println("NODES: "+nodeList.size());
    }
}