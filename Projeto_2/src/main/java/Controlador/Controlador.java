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
    private Controlador(){
        
    }
    
    public static Controlador getInstance(){
        return instance;
    }
    
}
