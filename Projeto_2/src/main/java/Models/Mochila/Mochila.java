/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Mochila;

import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class Mochila {

    private ArrayList<ItensMochila> itens = new ArrayList<>();
    private int tamanhoMochila = 0;

    /**
     *
     */
    public Mochila() {
    }

    // Returns the maximum value that 
        // can be put in a knapsack of 
        // capacity W 
    public int knapSack(int capacidadeMochila, int pesoItem[], int valorItem[], int quantidadeItem) {
        // Base Case 
        if (quantidadeItem == 0 || capacidadeMochila == 0) {
            return 0;
        }
    // If weight of the nth item is 
    // more than Knapsack capacity W, 
    // then this item cannot be included 
    // in the optimal solution 
    if (pesoItem[quantidadeItem - 1] > capacidadeMochila) {
        return knapSack(capacidadeMochila, pesoItem, valorItem, quantidadeItem - 1);
    } // Return the maximum of two cases: 
    // (1) nth item included 
    // (2) not included 
    else {
        return maximo(valorItem[quantidadeItem - 1]+ knapSack(capacidadeMochila - pesoItem[quantidadeItem - 1], pesoItem,valorItem, quantidadeItem - 1),knapSack(capacidadeMochila, pesoItem, valorItem, quantidadeItem - 1));
    }}
        
    // A utility function that returns 
    // maximum of two integers 
    public int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     *
     * @return
     */
    public int getTamanho() {
        return tamanhoMochila;
    }

    /**
     *
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanhoMochila = tamanho;
    }

    /**
     *
     * @param item
     */
    public void adicionarItem(ItensMochila item) {
        itens.add(item);
        System.out.println("Item %s adicionado na mochila".formatted(item.toString()));
    }

    /**
     *
     * @return
     */
    public ArrayList<ItensMochila> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<ItensMochila> itens) {
        this.itens = itens;
    }

}
