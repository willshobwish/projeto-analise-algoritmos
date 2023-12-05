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
    private String code;
    private char caractere;
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

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public char getCaractere() {
        return caractere;
    }

    /**
     *
     * @param caractere
     */
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

}
