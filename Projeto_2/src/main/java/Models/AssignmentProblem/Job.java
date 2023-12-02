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
        return new Node(x, y, assigned, parent);
    }

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

    public void printAssignments(Node min) {
        if (min.parent == null) {
            return;
        }
        printAssignments(min.parent);
        System.out.println("Assign Worker " + (char) (min.workerID + 'A') + " to Job " + min.jobID);
    }

    public int findMinCost(int[][] costMatrix) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        boolean[] assigned = new boolean[N];
        Node root = newNode(-1, -1, assigned, null);
        root.pathCost = root.cost = 0;
        root.workerID = -1;
        pq.add(root);

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            int i = min.workerID + 1;

            if (i == N) {
                printAssignments(min);
                return min.cost;
            }

            for (int j = 0; j < N; j++) {
                if (!min.assigned[j]) {
                    Node child = newNode(i, j, min.assigned, min);
                    child.pathCost = min.pathCost + costMatrix[i][j];
                    child.cost = child.pathCost + calculateCost(costMatrix, i, j, child.assigned);
                    pq.add(child);
                }
            }
        }
        return -1;
    }
}
