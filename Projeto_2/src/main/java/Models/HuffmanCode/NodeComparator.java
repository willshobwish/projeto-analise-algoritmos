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
public class NodeComparator implements Comparator<NodeHuffman> {

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public int compare(NodeHuffman x, NodeHuffman y) {

        return x.getData() - y.getData();
    }
}
