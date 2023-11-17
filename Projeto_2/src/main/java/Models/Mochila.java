/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class Mochila {
    private ArrayList<ItensMochila> itens = new ArrayList<>();
    private int tamanho=0;
    
    public Mochila() {
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public void adicionarItem(ItensMochila item){
        itens.add(item);
        System.out.println("Item %s adicionado na mochila".formatted(item.toString()));
    }

    public ArrayList<ItensMochila> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItensMochila> itens) {
        this.itens = itens;
    }
    
    
    
}
