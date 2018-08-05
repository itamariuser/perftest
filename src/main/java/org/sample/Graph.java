package org.sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    }

    ArrayList<Edge> edgeList;
    ArrayList<E> nodeList;
    public long nodeCount;
    public Graph() {
        edgeList = new ArrayList<Edge>();
        nodeList = new ArrayList<E>();
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
        E start = null, end = null;
//        Node startN = new Node(startNode);
//        Node endN = new Node(endNode);
//        for (E node : nodeList) {
//            if (startNode.compareTo(node) == 0) {
//                start = node;
//            }
//            else if (endNode.compareTo(node) == 0) {
//                end = node;
//            }
//        }

        if(nodeList.contains(startNode))
            start = startNode;
        else if(nodeList.contains(endNode))
            end = endNode;
//        for (Node node : nodeList) {
//            System.out.println(node.name);
//        }
//        if(nodeList.contains(startN))
//            start = startN;
//        if(nodeList.contains(endN))
//            start = endN;

        if (start == null) {
            start = startNode;
            ++nodeCount;
            nodeList.add(start);
        }
        if (end == null) {
            end = endNode;
            ++nodeCount;
            nodeList.add(end);
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
        Set<E> markedNodes = new HashSet<E>();

        for (E n : nodeList) {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                markedNodes.addAll(depthFirstSearch(n, new ArrayList<E>()));
                count++;
            }
        }

        return count;
    }

    /**
     * Implementation of depth first search.
     *
     * @param n
     *            the actual visiting node
     *
     * @param visited
     *            A list of already visited nodes in the depth first search
     *
     * @return returns a set of visited nodes
     *
     */

    public ArrayList<E> depthFirstSearch(E n, ArrayList<E> visited) {
        visited.add(n);
        for (Edge e : edgeList) {
            if (e.startNode.equals(n) && !visited.contains(e.endNode)) {
                depthFirstSearch(e.endNode, visited);
            }
        }
        return visited;
    }

    public ArrayList<E> breadthFirstSearch(E n, ArrayList<E> visited) {
        visited.add(n);
        for (Edge e : edgeList) {
            if (e.startNode.equals(n) && !visited.contains(e.endNode)) {
                depthFirstSearch(e.endNode, visited);
            }
        }
        return visited;
    }
}