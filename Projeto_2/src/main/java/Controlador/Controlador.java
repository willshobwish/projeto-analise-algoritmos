/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Models.FractionalKnapsack.FractionalKnapsack;
import Models.FractionalKnapsack.ItemFractionalKnapsack;
import Models.HuffmanCode.Huffman;
import Models.LongestCommonSubsequence.LongestCommonSubsequence;
import Models.Knapsack.Knapsack;
import java.util.ArrayList;

/**
 *
 * @author willianmurayama
 */
public class Controlador {

    private static final Controlador instance = new Controlador();
    private Knapsack mochila = new Knapsack();
    private Huffman huffman = new Huffman();
    private LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    private FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();

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
     * @param valor
     * @param peso
     */
    public void addFractionalKnapsack(int valor, int peso) {
        ArrayList<ItemFractionalKnapsack> itens = fractionalKnapsack.getItens();
        itens.add(new ItemFractionalKnapsack(valor, peso));
        fractionalKnapsack.setItens(itens);
    }

    /**
     *
     */
    public void removeFractionalKnapsack() {
        ArrayList<ItemFractionalKnapsack> itens = fractionalKnapsack.getItens();
        itens.removeLast();
        fractionalKnapsack.setItens(itens);
    }

    public void sliceTextHuffman(String text) {
        huffman.slice(text);
    }

    /**
     *
     * @param tamanho
     */
    public void setTamanhoFractionalKnapsack(int tamanho) {
        fractionalKnapsack.setCapacidadeMochila(tamanho);
    }

    /**
     *
     * @return
     */
    public FractionalKnapsack getFractionalKnapsack() {
        return fractionalKnapsack;
    }

    /**
     *
     * @param fractionalKnapsack
     */
    public void setFractionalKnapsack(FractionalKnapsack fractionalKnapsack) {
        this.fractionalKnapsack = fractionalKnapsack;
    }

    /**
     *
     * @return
     */
    public Knapsack getMochila() {
        return mochila;
    }

    /**
     *
     * @param mochila
     */
    public void setMochila(Knapsack mochila) {
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
    public LongestCommonSubsequence getLcs() {
        return lcs;
    }

    /**
     *
     * @param lcs
     */
    public void setLcs(LongestCommonSubsequence lcs) {
        this.lcs = lcs;
    }

}
