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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public NodeHuffman getLeft() {
        return left;
    }

    public void setLeft(NodeHuffman left) {
        this.left = left;
    }

    public NodeHuffman getRight() {
        return right;
    }

    public void setRight(NodeHuffman right) {
        this.right = right;
    }

}
