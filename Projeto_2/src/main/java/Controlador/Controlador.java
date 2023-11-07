/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author willianmurayama
 */
public class Controlador {
    private static final Controlador instance = new Controlador();
    
    private Controlador(){
        
    }
    
    public static Controlador getInstance(){
        return instance;
    }
    
}
