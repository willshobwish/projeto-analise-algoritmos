/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Knapsack;

/**
 *
 * @author Willian Murayama
 */
public class ItensKnapsack {

    private int peso;
    private int valor;
    private boolean selecionado;
    /**
     *
     * @param peso
     * @param valor
     */
    public ItensKnapsack(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public int getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    public int getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ItensMochila{" + "peso=" + peso + ", valor=" + valor + '}';
    }

}
