/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.FractionalKnapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Willian Murayama
 */
public class FractionalKnapsack {

    private int capacidadeMochila;

    private ArrayList<ItemFractionalKnapsack> itens = new ArrayList<>();

    /**
     *
     */
    public FractionalKnapsack() {
    }

    /**
     *
     * @return
     */
    public double calcula() {
        for (ItemFractionalKnapsack i : itens) {
            i.setFracao(0);
        }
        return recursiveFractionalKnapsack(capacidadeMochila);
    }

    /**
     *
     * @param capacidadeMochila
     * @return
     */
    public double recursiveFractionalKnapsack(int capacidadeMochila) {
//        Implementacao de um comparador para organizar o arraylist
        Collections.sort(itens, new Comparator<ItemFractionalKnapsack>() {
            @Override
            public int compare(ItemFractionalKnapsack item1, ItemFractionalKnapsack item2) {
                double comparacao1 = (double) item1.getValor() / (double) item1.getPeso();
                double comparacao2 = (double) item2.getValor() / (double) item2.getPeso();
                if (comparacao1 < comparacao2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        double valorTotal = 0;
        for (ItemFractionalKnapsack item : itens) {
            int pesoAtual = (int) item.getPeso();
            int valorAtual = (int) item.getValor();
            if (capacidadeMochila - pesoAtual >= 0) {
//                O item pode ser pego por completo
                capacidadeMochila = capacidadeMochila - pesoAtual;
                valorTotal += valorAtual;
                item.setFracao(1);
            } else {
//                Senao, sera possivel pegar apenas uma porcao do item
                double fracao = (double) capacidadeMochila / (double) pesoAtual;
//                Determina a fracao no item para ser exibido
                item.setFracao(fracao);
                valorTotal += (valorAtual * fracao);
                capacidadeMochila = (int) (capacidadeMochila - (pesoAtual * fracao));
                break;
            }
        }
        return valorTotal;
    }

    /**
     *
     * @return
     */
    public ArrayList<ItemFractionalKnapsack> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<ItemFractionalKnapsack> itens) {
        this.itens = itens;
    }

    /**
     *
     * @return
     */
    public int getCapacidadeMochila() {
        return capacidadeMochila;
    }

    /**
     *
     * @param capacidadeMochila
     */
    public void setCapacidadeMochila(int capacidadeMochila) {
        this.capacidadeMochila = capacidadeMochila;
    }

}
