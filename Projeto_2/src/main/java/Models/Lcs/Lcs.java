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
    private int len_string_1;
    private int len_string_2;
    private String resultado;
    private int max;

    public Lcs() {
    }

    public int calcula(String string_a, String string_b, int len_string_a, int len_string_b) {
        if (len_string_a == 0 || len_string_b == 0) {
            return 0;
        }
        if (string_a.charAt(len_string_a - 1) == string_b.charAt(len_string_b - 1)) {
            return 1 + calcula(string_a, string_b, len_string_a - 1, len_string_b - 1);
        } else {
            return max(calcula(string_a, string_b, len_string_a, len_string_b - 1),
                    calcula(string_a, string_b, len_string_a - 1, len_string_b));
        }
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public String getString_1() {
        return string_1;
    }

    public void setString_1(String string_1) {
        this.string_1 = string_1;
        len_string_1 = this.string_1.length();
    }

    public void setString_2(String string_2) {
        this.string_2 = string_2;
        len_string_2 = this.string_2.length();
    }

    public String getStirng_2() {
        return string_2;
    }

    public void setStirng_2(String stirng_2) {
        this.string_2 = stirng_2;
        len_string_2 = this.string_2.length();
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
