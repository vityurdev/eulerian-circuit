package com.vityur;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph(6);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

        graph.printEulerianCycle();
    }
}
