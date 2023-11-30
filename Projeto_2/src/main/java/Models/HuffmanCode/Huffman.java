/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.HuffmanCode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Willian Murayama
 */
public class Huffman {

    /**
     *
     */
    public void calcula() {
        Scanner s = new Scanner(System.in);

        // number of characters.
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charfreq = {5, 9, 12, 13, 16, 45};

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<NodeHuffman> q = new PriorityQueue<NodeHuffman>(n, new NodeComparator());

        for (int i = 0; i < n; i++) {

            // creating a Huffman node object
            // and add it to the priority queue.
            NodeHuffman hn = new NodeHuffman();

            hn.setC(charArray[i]);
            hn.setData(charfreq[i]);

            hn.setLeft(null);
            hn.setRight(null);

            // add functions adds
            // the huffman node to the queue.
            q.add(hn);
        }

        // create a root node
        NodeHuffman root = null;

        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.
        while (q.size() > 1) {

            // first min extract.
            NodeHuffman x = q.peek();
            q.poll();

            // second min extract.
            NodeHuffman y = q.peek();
            q.poll();

            // new node f which is equal
            NodeHuffman f = new NodeHuffman();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            f.setData(x.getData() + y.getData());
            f.setC('-');

            // first extracted node as left child.
            f.setLeft(x);

            // second extracted node as the right child.
            f.setRight(y);

            // marking the f node as the root node.
            root = f;

            // add this node to the priority-queue.
            q.add(f);
        }

        // print the codes by traversing the tree
        printCode(root, "");
    }

    /**
     *
     * @param root
     * @param s
     */
    public void printCode(NodeHuffman root, String s) {
        // base case; if the left and right are null
        // then its a leaf node and we print
        // the code s generated by traversing the tree.
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getC())) {

            // c is the character in the node
            System.out.println(root.getC() + ":" + s);

            return;
        }

        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.
        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }

}
