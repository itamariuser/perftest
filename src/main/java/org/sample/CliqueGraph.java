package org.sample;

//Basically a clique the size of POD.nodesNum
class  CliqueGraph extends Graph {
    public CliqueGraph()
    {
        for(int i = 1; i < POD.nodesNum+1; ++i)
        {
            nodeList.add(i);
        }
        for(int i = 1; i <nodeList.size()+1;++i)
        {
            for(int j = 1; j < nodeList.size()+1;++j)
            {
                if(i!=j)
                    addEdge(i,j);
            }
        }
        System.out.println("CLIQUE ISLAND");
        System.out.println("NODES: "+nodeList.size());
    }
}