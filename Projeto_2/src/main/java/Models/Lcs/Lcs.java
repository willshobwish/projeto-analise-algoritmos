/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Lcs;

/**
 *
 * @author Willian Murayama
 */
public class Lcs {

    private String string_1;
    private String string_2;
    private String resultado;
    private int max;

    public Lcs() {
    }

    public int calcula(String string_a, String string_b, int len_string_a, int len_string_b) {
//        Implementacao recursiva do LCS
//Caso as strings sao vazias, retorna zero
        if (len_string_a == 0 || len_string_b == 0) {
            return 0;
        }
//Caso as letras sejam iguais em dadas posicoes, retorna 1 mais o restante que sao iguais (recursao)
        if (string_a.charAt(len_string_a - 1) == string_b.charAt(len_string_b - 1)) {
            return 1 + calcula(string_a, string_b, len_string_a - 1, len_string_b - 1);
//            Caso acabe de analisar a string, retorna o maximo entre os dois
        } else {
            return max(calcula(string_a, string_b, len_string_a, len_string_b - 1),
                    calcula(string_a, string_b, len_string_a - 1, len_string_b));
        }
    }

    public int max(int a, int b) {
//        Operador ternario
        return (a > b) ? a : b;
    }

    public String getString_1() {
        return string_1;
    }

    public void setString_1(String string_1) {
        this.string_1 = string_1;
    }

    public void setString_2(String string_2) {
        this.string_2 = string_2;
    }

    public String getString_2() {
        return string_2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
