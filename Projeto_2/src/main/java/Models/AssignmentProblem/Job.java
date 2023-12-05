/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AssignmentProblem;

import java.util.PriorityQueue;

/**
 *
 * @author Willian Murayama
 */
public class Job {

    final int N = 4;

    Node newNode(int x, int y, boolean[] assigned, Node parent) {
        return new Node(x, y, assigned, parent, N);
    }

    /**
     *
     * @param costMatrix
     * @param x
     * @param y
     * @param assigned
     * @return
     */
    public int calculateCost(int[][] costMatrix, int x, int y, boolean[] assigned) {
        int cost = 0;
        boolean[] available = new boolean[N];
        for (int i = 0; i < N; i++) {
            available[i] = true;
        }

        for (int i = x + 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < N; j++) {
                if (!assigned[j] && available[j] && costMatrix[i][j] < min) {
                    minIndex = j;
                    min = costMatrix[i][j];
                }
            }

            cost += min;
            available[minIndex] = false;
        }

        return cost;
    }

    /**
     *
     * @param min
     */
    public void printDesignacoes(Node min) {
        if (min.parent == null) {
            return;
        }
        printDesignacoes(min.parent);
    }

    /**
     *
     * @param costMatrix
     * @return
     */
    public int findMinCost(int[][] costMatrix) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());
        boolean[] designado = new boolean[N];
        Node raiz = newNode(-1, -1, designado, null);
        raiz.custoCaminho = raiz.custo = 0;
        raiz.identificacao = -1;
        priorityQueue.add(raiz);

        while (!priorityQueue.isEmpty()) {
            Node min = priorityQueue.poll();
            int i = min.identificacao + 1;

            if (i == N) {
                printDesignacoes(min);
                return min.custo;
            }

            for (int j = 0; j < N; j++) {
                if (!min.assigned[j]) {
                    Node child = newNode(i, j, min.assigned, min);
                    child.custoCaminho = min.custoCaminho + costMatrix[i][j];
                    child.custo = child.custoCaminho + calculateCost(costMatrix, i, j, child.assigned);
                    priorityQueue.add(child);
                }
            }
        }
        return -1;
    }
}
