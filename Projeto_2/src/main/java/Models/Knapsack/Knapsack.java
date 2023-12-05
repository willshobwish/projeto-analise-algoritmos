/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Knapsack;

import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class Knapsack {

    private ArrayList<ItensKnapsack> itens = new ArrayList<>();
    private int capacidadeMochila = 0;

    /**
     *
     */
    public Knapsack() {
    }

    /**
     *
     * @param item
     */
    public void adicionarItem(ItensKnapsack item) {
        itens.add(item);
        System.out.println("Item %s adicionado na mochila".formatted(item.toString()));
    }

    /**
     *
     * @return
     */
    public int calcula() {
        for (ItensKnapsack i : itens) {
            i.setSelecionado(false);
        }
        return knapsackRecursivo(capacidadeMochila, itens.size());
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     *
     * @param capacidadeMochila
     * @param quantidadeItem
     * @return
     */
    public int knapsackRecursivo(int capacidadeMochila, int quantidadeItem) {
//        Criamos uma tabela dinamica
        int tabela[][] = new int[quantidadeItem + 1][capacidadeMochila + 1];
//        Iteramos toda a tabela com "-1"
        for (int i = 0; i < quantidadeItem + 1; i++) {
            for (int j = 0; j < capacidadeMochila + 1; j++) {
                tabela[i][j] = -1;
            }
        }
//        Fazemos as checagens
        if (quantidadeItem == 0 || capacidadeMochila == 0) {
            return 0;
        }
        if (tabela[quantidadeItem][capacidadeMochila] != -1) {
            return tabela[quantidadeItem][capacidadeMochila];
        }
        if (itens.get(quantidadeItem - 1).getPeso() > capacidadeMochila) {
            itens.get(quantidadeItem - 1).setSelecionado(true);
            return tabela[quantidadeItem][capacidadeMochila] = knapsackRecursivo(capacidadeMochila, quantidadeItem - 1);
        } else {
            itens.get(quantidadeItem - 1).setSelecionado(false);
            return tabela[quantidadeItem][capacidadeMochila] = max((itens.get(quantidadeItem - 1).getValor() + knapsackRecursivo(capacidadeMochila - itens.get(quantidadeItem - 1).getPeso(), quantidadeItem - 1)), knapsackRecursivo(capacidadeMochila, quantidadeItem - 1));
        }
    }

    /**
     *
     * @return
     */
    public int getTamanho() {
        return capacidadeMochila;
    }

    /**
     *
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.capacidadeMochila = tamanho;
    }

    /**
     *
     * @return
     */
    public ArrayList<ItensKnapsack> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<ItensKnapsack> itens) {
        this.itens = itens;
    }

}
