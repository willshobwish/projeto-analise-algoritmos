/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Mochila;

import java.util.ArrayList;

/**
 *
 * @author Willian Murayama
 */
public class Mochila {

    private ArrayList<ItensMochila> itens = new ArrayList<>();
    private int tamanhoMochila = 0;

    /**
     *
     */
    public Mochila() {
    }

    public int max(int a, int b) { return (a > b) ? a : b; } 
    
    public int knapSackRec(int W, int wt[], int val[],int n, int[][] dp) 
    {
        // Base condition 
        if (n == 0 || W == 0) 
            return 0;
        if (dp[n][W] != -1) 
            return dp[n][W];
        if (wt[n - 1] > W)
            // Store the value of function call 
            // stack in table before return 
            return dp[n][W] = knapSackRec(W, wt, val, n - 1, dp);
        else
            // Return value of table after storing 
            return dp[n][W]= max((val[n - 1]+ knapSackRec(W - wt[n - 1], wt, val,n - 1, dp)),knapSackRec(W, wt, val, n - 1, dp)); 
    } 

    public int knapSack(int W, int wt[], int val[], int N) 
    { 
  
        // Declare the table dynamically 
        int dp[][] = new int[N + 1][W + 1]; 
  
        // Loop to initially filled the 
        // table with -1 
        for (int i = 0; i < N + 1; i++) 
            for (int j = 0; j < W + 1; j++) 
                dp[i][j] = -1; 
  
        return knapSackRec(W, wt, val, N, dp); 
    } 
    /**
     *
     * @return
     */
    public int getTamanho() {
        return tamanhoMochila;
    }

    /**
     *
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanhoMochila = tamanho;
    }

    /**
     *
     * @param item
     */
    public void adicionarItem(ItensMochila item) {
        itens.add(item);
        System.out.println("Item %s adicionado na mochila".formatted(item.toString()));
    }

    /**
     *
     * @return
     */
    public ArrayList<ItensMochila> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<ItensMochila> itens) {
        this.itens = itens;
    }

}
