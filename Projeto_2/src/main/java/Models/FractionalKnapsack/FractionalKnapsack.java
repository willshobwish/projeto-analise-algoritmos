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

    public FractionalKnapsack() {
    }

    public double calcula() {
        for (ItemFractionalKnapsack i : itens) {
            i.setFracao(0);
        }
        return recursiveFractionalKnapsack(capacidadeMochila);
    }

    public double recursiveFractionalKnapsack(int capacidadeMochila) {
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
        double valorTotal = 0d;
        for (ItemFractionalKnapsack i : itens) {
            int pesoAtual = (int) i.getPeso();
            int valorAtual = (int) i.getValor();
            if (capacidadeMochila - pesoAtual >= 0) {
                // This weight can be picked whole
                capacidadeMochila = capacidadeMochila - pesoAtual;
                valorTotal += valorAtual;
                i.setFracao(1);
            } else {
                // Item cant be picked whole
                double fraction = (double) capacidadeMochila / (double) pesoAtual;
                i.setFracao(fraction);
                valorTotal += (valorAtual * fraction);
                capacidadeMochila = (int) (capacidadeMochila - (pesoAtual * fraction));
                break;
            }
        }
        return valorTotal;
    }

    public ArrayList<ItemFractionalKnapsack> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemFractionalKnapsack> itens) {
        this.itens = itens;
    }

    public int getCapacidadeMochila() {
        return capacidadeMochila;
    }

    public void setCapacidadeMochila(int capacidadeMochila) {
        this.capacidadeMochila = capacidadeMochila;
    }

}
