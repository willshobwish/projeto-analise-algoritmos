/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.AssignmentProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Willian Murayama
 */
public class AssignmentProblem {

    public void main() {
        Job job = new Job();
        int[][] costMatrix = {
            {9, 2, 7, 8},
            {6, 4, 3, 7},
            {5, 8, 1, 8},
            {7, 6, 9, 4}
        };
        job.findMinCost(costMatrix);
    }
}
