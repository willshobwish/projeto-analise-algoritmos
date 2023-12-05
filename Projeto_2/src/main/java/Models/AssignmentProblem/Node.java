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
    int custoCaminho;
    int custo;
    int identificacao;
    int jobID;
    boolean[] assigned;

    Node(int x, int y, boolean[] assigned, Node parent, int quantidadeTrabalho) {
        this.parent = parent;
        this.assigned = new boolean[quantidadeTrabalho];  // Corrected line
        System.arraycopy(assigned, 0, this.assigned, 0, quantidadeTrabalho);
        this.assigned[y] = true;
        this.identificacao = x;
        this.jobID = y;
    }
}
