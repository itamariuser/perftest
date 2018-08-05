package org.sample;

import java.io.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.*;


public class GraphConcurrent {

    /**
     * ConcurrentHashMap supports full concurrency of retrievals and high expected concurrency for updates.
     * All operations are thread-safe, retrieval operations do not entail locking
     */


    /**
     * Map between a Node's number and it's corresponding object, effectively representing a tree.
     */
    private ConcurrentHashMap<Integer, Node> nodeTree;


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
     * Choose whether or not to output the built tree to a file.
     * @param cmd
     * @param graph
     */
//    protected static void chooseOutputToFile(CommandLine cmd, Graph graph) {
//        if(cmd.hasOption("gf")) {
//            String outputFileName = cmd.getOptionValue("gf");
//            graph.writeToFile(outputFileName);
//        }
//    }

    /**
     * Choose how many threads should subtask the search.
     * @param cmd
     * @param graph
     */
//    protected static void numOfExecutingThreads(CommandLine cmd, Graph graph) {
//        if(cmd.hasOption("t")) {
//            String threadCountString = cmd.getOptionValue("t");
//            Integer threadCount = Integer.valueOf(threadCountString);
//            graph.execute(threadCount);
//        } else {
//            graph.execute(1);
//        }
//    }

    /**
     * Determines if the graph should be created from a file or on the go.
     * @param cmd
     * @param graph
     */
//    protected static void determineGraphOrigin(CommandLine cmd, Graph graph) {
//        if(cmd.hasOption("n")) {
//            String nodeCountString = cmd.getOptionValue("n", "1");
//            Integer nodeCount = Integer.valueOf(nodeCountString);
//            graph.generateGraph(nodeCount);
//        } else if (cmd.hasOption("i")) {
//            String fileName = cmd.getOptionValue("i");
//            graph.constructGraphFromFile(fileName);
//        }
//    }

    /**
     * Determines the location of the print file in which the
     * thread execution time and data should be written.
     * @param cmd
     */
//    protected static void determinePrintLocation(CommandLine cmd) {
//        if(cmd.hasOption("q")) {
//            System.setOut(new NullPrintStream());
//        } else if(cmd.hasOption("o")) {
//            String fileName = cmd.getOptionValue("o", "output_file.txt");
//            try {
//                System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(fileName)), true));
//            } catch (FileNotFoundException e) {
//                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, "Failed to create output stream.", e);
//            }
//
//        }
//    }

    /**
     * Sets the command line options.
     * @param options
     */
//    protected static void setOptions(Options options) {
//        options.addOption("n", true, "The number of nodes of the graph.");
//        options.addOption("i", true, "The input file for the graph.");
//        options.addOption("o", true, "The output file for the application");
//        options.addOption("t", true, "The amount of threads to be used");
//        options.addOption("q", false, "Determine if there should be output");
//        options.addOption("gf",true, "File to which to write the graph information");
//    }


    /**
     * Executes the parallel DFS.
     * Use a "work-stealing" ExecutorService for running ForkJoinTasks
     * Think of paralleling a task like fibonacci computation...
     */
    private void execute(int threadCount) {

        ForkJoinPool pool = new ForkJoinPool(threadCount);
        // check each node, because the graph may not be connected
        System.out.println("Algorithm execution started with " + threadCount + " threads");
        long startTime = System.nanoTime();
        for(Integer node : visitedNodesMapper.keySet()) {
            if(visitedNodesMapper.get(node).get()) {
                continue;
            }
            DFS dfs = new DFS(node);
            pool.invoke(dfs);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Algorithm execution took " + elapsedTime + " nanoseconds");

    }

    /**
     * Write the graph data to a file.
     * @param fileName
     */
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
     */
    private void generateGraph(int nodeCount) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        visitedNodesMapper = new ConcurrentHashMap<>(nodeCount);

        System.out.println("Started graph creation.");

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

        System.out.println("Graph created.");
    }

    public void addNode(int key)
    {
        nodeTree.put(key, new Node(key));
        neighbors.putIfAbsent(key, new LinkedList<>());

        visitedNodesMapper.put(key, new AtomicBoolean(false));
    }

    public void addEdge(int key, int target)
    {
//        visitedNodesMapper.put(key, new AtomicBoolean(false));// DO WE NEED THIS HERE?
        if(nodeTree.keySet().contains(key) && nodeTree.keySet().contains(target))
        {
            neighbors.get(key).add(target);
        }
    }


    /**
     * Construct a graph from an adjacency matrix in a file.
     * @param fileName
     */
//    public void constructGraphFromFile(String fileName) {
//
//        System.out.println("Construction of graph from file started");
//
//        File file = new File(fileName);
//
//        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
//
//            String numberLine = br.readLine();
//            int nodeCount = Integer.valueOf(numberLine);
//
//            visitedNodesMapper = new ConcurrentHashMap<>(nodeCount);
//            int count = 0;
//            for(String line; (line = br.readLine()) != null; ) {
//                String[] data = line.split("\\s+");
//
//                List<Integer> neighbours = new LinkedList<>();
//
//                for(int i = 0; i < data.length ; i++) {
//                    if(data[i].equals("1")) {
//                        neighbours.add(i);
//                    }
//                }
//
//                neighbors.put(count, neighbours);
//
//                nodeTree.put(count, new Node(count));
//                visitedNodesMapper.put(count, new AtomicBoolean(false));
//
//                count++;
//
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, "Failed to construct graph from file.", ex);
//            return;
//        }
//        System.out.println("Construction of graph from file finished");
//    }

    private void constructGraphFile(String fileName, int size) {
        System.out.println("Construction of graph file started.");
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, "Failed to create file with name: " + fileName, ex);
        }
        try(BufferedWriter bwr = new BufferedWriter(new FileWriter(file))){
            bwr.write(String.valueOf(size));
            bwr.newLine();

            ThreadLocalRandom random = ThreadLocalRandom.current();

            for(int i=0; i < size; i++) {
                StringBuilder builder = new StringBuilder();
                for(int j=0; j < size; j++) {
                    builder.append(random.nextInt(2));
                    builder.append(" ");
                }
                String trimed = builder.toString().trim();
                bwr.write(trimed);
                bwr.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, "Failed to construct adjecancy matrix file.", ex);
            return;
        }
        System.out.println("Construction of graph file finished.");

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
            //atomicInteger. threadName = Thread.currentThread().getName();

            AtomicBoolean isVisited = visitedNodesMapper.get(node);
            if(isVisited.getAndSet(true)) {
                atomicInteger.set(1);
                System.out.println("New Connected Component");
                return;
            }


            //System.out.println("Executing thread " + threadName + ". For node " + node);
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

            // System.out.println("Thread " + threadName + ". Finished work on node " + node + " and returned to thread pool");
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

