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

    public int max(int a, int b) { return (a > b) ? a : b; } 
    
    public int knapSackRec(int capacidadeMochila, int pesoItem[], int valorItem[],int quantidadeItem) 
    {
        // Declare the table dynamically 
        int tabela[][] = new int[quantidadeItem + 1][capacidadeMochila + 1]; 
  
        // Loop to initially filled the 
        // table with -1 
        for (int i = 0; i < quantidadeItem + 1; i++) 
            for (int j = 0; j < capacidadeMochila + 1; j++) 
                tabela[i][j] = -1; 
        // Base condition 
        if (quantidadeItem == 0 || capacidadeMochila == 0) 
            return 0;
        if (tabela[quantidadeItem][capacidadeMochila] != -1) 
            return tabela[quantidadeItem][capacidadeMochila];
        if (pesoItem[quantidadeItem - 1] > capacidadeMochila)
            // Store the value of function call 
            // stack in table before return 
            return tabela[quantidadeItem][capacidadeMochila] = knapSackRec(capacidadeMochila, pesoItem, valorItem, quantidadeItem - 1);
        else
            // Return value of table after storing 
            return tabela[quantidadeItem][capacidadeMochila]= max((valorItem[quantidadeItem - 1]+ knapSackRec(capacidadeMochila - pesoItem[quantidadeItem - 1], pesoItem, valorItem,quantidadeItem - 1)),knapSackRec(capacidadeMochila, pesoItem, valorItem, quantidadeItem - 1)); 
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
