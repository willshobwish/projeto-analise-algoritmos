/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.HuffmanCode;

//import java.util.Comparator;

import java.util.Comparator;


/**
 *
 * @author Willian Murayama
 */
public class NodeComparator implements Comparator<Node>{
     public int compare(Node x, Node y) 
    { 
        return x.data - y.data; 
    } 
}
