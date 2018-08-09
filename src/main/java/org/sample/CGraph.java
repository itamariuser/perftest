package org.sample;
//Check GraphConcurrent on a "snake graph"
class CGraph{
    public GraphConcurrent graphConcurrent;
    public CGraph()
    {
        graphConcurrent = new GraphConcurrent();
        graphConcurrent.addNode(POD.nodesNum);
        for(int i =0;i<POD.nodesNum-1;++i)
        {
            graphConcurrent.addNode(i);
            graphConcurrent.addEdge(i+1,i);
        }
        System.out.println("CONCURRENT SNAKE ISLAND");
        System.out.println("NODES: "+graphConcurrent.nodeTree.size());
    }
}