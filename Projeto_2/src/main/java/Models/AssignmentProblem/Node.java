/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AssignmentProblem;

/**
 *
 * @author Willian Murayama
 */
public class Node {

    Node parent;
    int pathCost;
    int cost;
    int workerID;
    int jobID;
    boolean[] assigned;
    int N = 4;

    Node(int x, int y, boolean[] assigned, Node parent) {
        this.parent = parent;
        this.assigned = new boolean[N];
        System.arraycopy(assigned, 0, this.assigned, 0, N);
        this.workerID = x;
        this.jobID = y;
    }
}
