/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.FractionalKnapsack;

/**
 *
 * @author Willian Murayama
 */
public class ItemFractionalKnapsack {
    private int valor;
    private int peso;
    private double fracao;

    public ItemFractionalKnapsack(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getFracao() {
        return fracao;
    }

    public void setFracao(double fracao) {
        this.fracao = fracao;
    }
    
}
