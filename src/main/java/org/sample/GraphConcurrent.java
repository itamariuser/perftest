package org.sample;

import java.util.LinkedList;
import java.util.Objects;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

public class GraphConcurrent {

    /**
     * ConcurrentHashMap supports full concurrency of retrievals and high expected concurrency for updates.
     * All operations are thread-safe, retrieval operations do not entail locking
     */


    /**
     * Map between a Node's number and it's corresponding object, effectively representing a tree.
     */
    public ConcurrentHashMap<Integer, Node> nodeTree;


    /**
     * Map between a Node and it's neighbors.
     */
    private ConcurrentHashMap<Integer, List<Integer>> neighbors;


    /**
     *  Map between a Node and it's discovery status, i.e. if it was visited already.
     */
    private ConcurrentHashMap<Integer, AtomicBoolean> visitedNodesMapper;
    public GraphConcurrent() {
        nodeTree = new ConcurrentHashMap<>();
        neighbors = new ConcurrentHashMap<>();
        visitedNodesMapper = new ConcurrentHashMap<>();
    }


    /**
     * Start the Connected Component search with a set number of threads
     * @Param startAlgorithm - number of threads to run
     */
    public int startAlgorithm(Integer threadCount) {
        execute(threadCount);
        return 1;
    }

    /**
     * Executes the parallel DFS.
     * Use a "work-stealing" ExecutorService for running ForkJoinTasks
     */
    private void execute(int threadCount) {

        ForkJoinPool pool = new ForkJoinPool(threadCount);
        // check each node, because the graph may not be connected
        for(Integer node : visitedNodesMapper.keySet()) {
            if(visitedNodesMapper.get(node).get())
                continue;
            System.out.println("New connected component");
            ++StaticCounter.counter;
            DFS dfs = new DFS(node);
            pool.invoke(dfs);
        }
    }

/*
    /**
     * Write the graph data to a file.
     * @param fileName

    public void writeToFile(String fileName) {
        File file = new File(fileName);
        try(BufferedWriter bwr = new BufferedWriter(new FileWriter(file))) {

            for(Node node : nodeTree.values()) {
                bwr.write("Node number: " + node.getNode());
                bwr.newLine();

                if(node.getParent() != null){
                    bwr.write("Node parent: " + node.getParent().getNode());
                    bwr.newLine();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, "Failed to create output stream for the graph data.", ex);
        }

    }


    /**
     * Generates a graph in memory.
     * @param nodeCount

    private void generateGraph(int nodeCount) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        visitedNodesMapper = new ConcurrentHashMap<>(nodeCount);
        for(int i=0 ; i < nodeCount ; i++) {

            List<Integer> neighbours = new LinkedList<>();
            for(int j=0; j < nodeCount ; j++) {
                int choice = random.nextInt(2);
                if(choice == 1) {
                    neighbours.add(j);
                }
            }
            neighbors.put(i, neighbours);
            visitedNodesMapper.put(i, new AtomicBoolean(false));
            nodeTree.put(i, new Node(i));
        }
    }*/

    public void addNode(int key)
    {
        if(!nodeTree.contains(key))
        {
            nodeTree.put(key, new Node(key));
            neighbors.putIfAbsent(key, new LinkedList<>());
            visitedNodesMapper.put(key, new AtomicBoolean(false));
        }
    }

    public void addEdge(int key, int target)
    {
        if(nodeTree.keySet().contains(key) && nodeTree.keySet().contains(target) && !neighbors.get(key).contains(target) && !neighbors.get(target).contains(key))
        {
            neighbors.get(key).add(target);
        }

    }

    /**
     * Class implementing {@link RecursiveAction} which does the actual computation.
     * A recursive resultless ForkJoinTask
     */
    private class DFS extends RecursiveAction {

        int node;
        public DFS(int node) {
            this.node = node;
        }

        @Override
        protected void compute() {
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicBoolean isVisited = visitedNodesMapper.get(node);
            if(isVisited.getAndSet(true)) {
                atomicInteger.set(1);
                return;
            }
            List<Integer> adjList = neighbors.get(node);
            Node parent = nodeTree.get(node);

            for(Integer neighbour : adjList) {

                Node child = nodeTree.get(neighbour);

                Integer childNode = child.getNode();
                if(visitedNodesMapper.get(childNode).get()) {
                    continue;
                }
                child.setParent(parent);
                DFS dfs = new DFS(neighbour);
                dfs.fork();
            }
        }

    }

    /**
     * Inner Class representing a node in the graph.
     *
     */
    private class Node {
        private Integer node;
        private Node parent;

        public Node(int node) {
            this.node = node;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 79 * hash + Objects.hashCode(this.node);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (!Objects.equals(this.node, other.node)) {
                return false;
            }
            return true;
        }

        public Integer getNode() {
            return node;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

    }

}

