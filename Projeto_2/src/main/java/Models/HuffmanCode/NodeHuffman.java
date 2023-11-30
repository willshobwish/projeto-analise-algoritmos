/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.HuffmanCode;

/**
 *
 * @author Willian Murayama
 */
public class NodeHuffman {

    private int data;
    private char c;
    private NodeHuffman left;
    private NodeHuffman right;

    /**
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public char getC() {
        return c;
    }

    /**
     *
     * @param c
     */
    public void setC(char c) {
        this.c = c;
    }

    /**
     *
     * @return
     */
    public NodeHuffman getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(NodeHuffman left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public NodeHuffman getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(NodeHuffman right) {
        this.right = right;
    }

}
