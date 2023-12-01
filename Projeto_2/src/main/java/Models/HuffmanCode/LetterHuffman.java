/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.HuffmanCode;

/**
 *
 * @author Willian Murayama
 */
public class LetterHuffman {

    private int frequencia;
    private char caractere;
    private String codigo;

    public LetterHuffman(int frequencia, char caractere, String codigo) {
        this.frequencia = frequencia;
        this.caractere = caractere;
        this.codigo = codigo;
    }

    public char getCaractere() {
        return caractere;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
