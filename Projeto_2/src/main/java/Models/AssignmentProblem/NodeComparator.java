/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AssignmentProblem;

import java.util.Comparator;

/**
 *
 * @author Willian Murayama
 */
public class NodeComparator implements Comparator<Node> {

    /**
     *
     * @param lhs
     * @param rhs
     * @return
     */
    public int compare(Node lhs, Node rhs) {
        return Integer.compare(lhs.custo, rhs.custo);
    }
}
