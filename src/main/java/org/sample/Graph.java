package org.sample;

import javafx.util.Pair;

import java.util.*;

class Graph<E extends Comparable<E>> {
//    class Node {
//        E name;
//
//        public Node(E name) {
//            this.name = name;
//        }
//
//        @Override
//        public int hashCode() {
//            return name.hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return ((Node)obj).name.equals(this.name);
//        }
//    }

    class Edge {
        E startNode, endNode;
        public Edge(E startNode, E endNode) {
            this.startNode = startNode;
            this.endNode = endNode;
        }

        @Override
        public int hashCode() {
            return new Pair<E,E>(startNode,endNode).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return ((Edge)obj).startNode == startNode && ((Edge)obj).endNode == endNode;
        }
    }

    HashSet<Edge> edgeList;
    HashSet<E> nodeList; //ArrayList<E> nodeList;
    public long nodeCount;
    public Graph() {
        edgeList = new HashSet<Edge>();
        nodeList = new HashSet<E>();
    }

    /**
     * Adds a new Edge to the graph. If the nodes aren't yet in nodeList, they
     * will be added to it.
     *
     * @param startNode
     *            the starting Node from the edge
     *
     * @param endNode
     *            the ending Node from the edge
     */
    public void addEdge(E startNode, E endNode) {
//        System.out.println("START: "+startNode);
//        System.out.println("END: "+endNode);
//      #2 ArrayList
//        E start = null, end = null;
//        for (E node : nodeList) {
//            if (startNode.compareTo(node) == 0) {
//                start = node;
//            }
//            else if (endNode.compareTo(node) == 0) {
//                end = node;
//            }
//        }
//        if (start == null) {
//            start = startNode;
//            ++nodeCount;
////            nodeList.add(start);
//        }
//        if (end == null) {
//            end = endNode;
//            ++nodeCount;
////            nodeList.add(end);
//        }
//      #1 HashSet
        E start = null, end = null;
        if(nodeList.contains(startNode))
            start = startNode;
        else if(nodeList.contains(endNode))
            end = endNode;

        if (start == null) {
            start = startNode;
            ++nodeCount;
//            nodeList.add(start);
        }
        if (end == null) {
            end = endNode;
            ++nodeCount;
//            nodeList.add(end);
        }

        edgeList.add(new Edge(start, end));
    }

    /**
     * Main method used for counting the connected components. Iterates through
     * the array of nodes to do a depth first search to get all nodes of the
     * graph from the actual node. These nodes are added to the array
     * markedNodes and will be ignored if they are chosen in the nodeList.
     *
     * @return returns the amount of unconnected graphs
     *
     */
    public int countGraphs() {
        int count = 0;
        Set<E> markedNodes = new HashSet<>();

        for (E n : nodeList) {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                markedNodes.addAll(depthFirstSearchIterativeEdges(n));
                count++;
            }
        }

        return count;
    }

//    public HashSet<E> searchIterativeEdges(boolean isDFS)
//    {
//        Stack<E> stack;
//        Queue<E> queue;
//        if(isDFS)
//            stack = new Stack<>();
//        else
//            queue = new LinkedList<E>();
//
//        //TODO
//
//    }

    public HashSet<E> depthFirstSearchIterativeEdges(E node) {


        HashSet<E> visited = new HashSet<>();
        Stack<E> stack=new Stack<E>();
        stack.add(node);
        visited.add(node);
        while (!stack.isEmpty())
        {
            E element=stack.pop();
            for (Edge e: edgeList) {
                if (e.startNode.equals(element) && !visited.contains(e.endNode))
                {
                    E n = e.endNode;
                    if(n!=null && !visited.contains(n))
                    {
                        stack.add(n);
                        visited.add(n);
                    }
                }
            }
        }
        return visited;
    }

    public HashSet<E> breadthFirstSearchIterativeEdges(E node) {
        Queue<E> queue = new LinkedList<>();
        HashSet<E> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty())
        {

            E element=queue.remove();
            for (Edge e: edgeList) {
                if (e.startNode.equals(node) && !visited.contains(e.endNode)) {
                    E n = e.endNode;
                    if (n != null && !visited.contains(node)) {
                        queue.add(n);
                        visited.add(n);

                    }
                }
            }

        }
        return visited;
    }

    public ArrayList<E> depthFirstSearchRecursive(E n, ArrayList<E> visited) {
        visited.add(n);
        for (Edge e : edgeList) {
            if (e.startNode.equals(n) && !visited.contains(e.endNode)) {
                depthFirstSearchRecursive(e.endNode, visited);
            }
        }
        return visited;
    }

}