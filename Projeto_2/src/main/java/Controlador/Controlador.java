/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Models.HuffmanCode.Huffman;
import Models.Lcs.Lcs;
import Models.Mochila.Mochila;

/**
 *
 * @author willianmurayama
 */
public class Controlador {

    private static final Controlador instance = new Controlador();
    private Mochila mochila = new Mochila();
    private Huffman huffman = new Huffman();
    private Lcs lcs = new Lcs();

    private Controlador() {

    }

    /**
     *
     * @return
     */
    public static Controlador getInstance() {
        return instance;
    }

    /**
     *
     * @return
     */
    public Mochila getMochila() {
        return mochila;
    }

    /**
     *
     * @param mochila
     */
    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    /**
     *
     * @return
     */
    public Huffman getHuffman() {
        return huffman;
    }

    /**
     *
     * @param huffman
     */
    public void setHuffman(Huffman huffman) {
        this.huffman = huffman;
    }

    /**
     *
     * @return
     */
    public Lcs getLcs() {
        return lcs;
    }

    /**
     *
     * @param lcs
     */
    public void setLcs(Lcs lcs) {
        this.lcs = lcs;
    }

}
