package com.vityur;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjLists;

    Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    Graph(Graph graph) {
        numVertices = graph.getNumVertices();
        adjLists = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = (LinkedList<Integer>) graph.getAdjList(i).clone();
        }
    }

    int getNumVertices() {
        return numVertices;
    }

    LinkedList<Integer>[] getAdjLists() {
        return adjLists;
    }

    LinkedList<Integer> getAdjList(int index) {
        return adjLists[index];
    }

    void addEdge(int src, int dest) {
        adjLists[src].add((Integer) dest);
        adjLists[dest].add((Integer) src);
    }

    void removeEdge(int src, int dest) {
        adjLists[src].remove((Integer) dest);
        adjLists[dest].remove((Integer) src);
    }

    void print() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjLists[i].size(); j++) {
                System.out.print(adjLists[i].get(j) + " ");
            }

            System.out.println();
        }
    }

    void printEulerianCycle() {
        // Checking whether graph is eulerian
        for (int i = 0; i < numVertices; i++) {
            if (adjLists[i].isEmpty() || adjLists[i].size() % 2 == 1) {
                System.out.println("This graph is not eulerian.");
                return;
            }
        }

        // Making a copy of graph
        Graph graph = new Graph(this);

        Stack<Integer> stack = new Stack<>();                     // Creating of stack instance
        stack.push(0);                                       // Pushing any vertex to stack

        while (!stack.empty()) {                                  // While stack is not empty
            Integer top = stack.peek();                           // Take the top vertex (V) of our stack

            if (graph.adjLists[top].isEmpty()) {                  // If deg(V) = 0 Then
                System.out.print(stack.pop() + " ");              //    Pop V out of stack and print it
            }
            else {                                                // Else
                Integer second = graph.adjLists[top].getFirst();  //    Take any edge that comes out of V
                graph.removeEdge(top, second);                    //    Remove that edge
                stack.push(second);                               //    Push second vertex to the stack
            }
        }

        System.out.println();
    }
}
