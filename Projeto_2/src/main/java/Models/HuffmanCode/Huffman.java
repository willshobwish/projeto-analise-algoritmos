/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.HuffmanCode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Willian Murayama
 */
public class Huffman {

    private ArrayList<LetterHuffman> letras = new ArrayList<LetterHuffman>();
    private ArrayList<LetterHuffman> letrasCodificado = new ArrayList<LetterHuffman>();

    public void codifica() {
        letrasCodificado.clear();
        int quantidadeLetras = letras.size();
//        Cria uma fila de prioridade
        PriorityQueue<NodeHuffman> priorityQueue = new PriorityQueue<NodeHuffman>(quantidadeLetras, new NodeComparator());

        for (LetterHuffman i : letras) {
            NodeHuffman nodehuffman = new NodeHuffman();

            nodehuffman.setCaractere(i.getCaractere());
            nodehuffman.setData(i.getFrequencia());

            nodehuffman.setLeft(null);
            nodehuffman.setRight(null);

            priorityQueue.add(nodehuffman);
        }

//        Criamos a raiz da arvore
        NodeHuffman root = null;

        while (priorityQueue.size() > 1) {
            NodeHuffman x = priorityQueue.peek();
            priorityQueue.poll();
            NodeHuffman y = priorityQueue.peek();
            priorityQueue.poll();
            NodeHuffman f = new NodeHuffman();
            f.setData(x.getData() + y.getData());
            f.setCaractere('-');
            f.setLeft(x);
            f.setRight(y);
            root = f;
            priorityQueue.add(f);
        }

        printCode(root, "");
        letras.clear();
    }

    /**
     *
     * @param root
     * @param s
     */
    public void printCode(NodeHuffman root, String s) {
//        Eh construido uma arvore e obtemos o codigo correndo pela arvore
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getCaractere())) {
            letrasCodificado.add(new LetterHuffman(root.getData(), root.getCaractere(), s));
            return;
        }

//        Caso va para a esquerda, sera "0"
//        Caso va para a direita, sera "1"
//        O algoritmo eh recursivo
        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }

    /**
     *
     * @param text
     */
    public void slice(String text) {
        for (char i : text.replaceAll("\\s", "").toCharArray()) {
            push(i);
        }
        codifica();
    }

    /**
     *
     * @param letter
     */
    public void push(char letter) {
        boolean found = false;

        for (LetterHuffman i : letras) {
            if (i.getCaractere() == letter) {
                i.setFrequencia(i.getFrequencia() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            letras.add(new LetterHuffman(1, letter, null));
        }
    }

    /**
     *
     * @param texto
     * @return
     */
    public String getTextoCodificado(String texto) {
        String textoCodificado = "";
        for (char j : texto.toCharArray()) {
            for (LetterHuffman i : letrasCodificado) {
                if (j == ' ') {
                    textoCodificado += ' ';
                }
                if (i.getCaractere() == j) {
                    textoCodificado += i.getCodigo();
                }
            }
        }
        return textoCodificado;
    }

    /**
     *
     * @return
     */
    public ArrayList<LetterHuffman> getLetras() {
        return letras;
    }

    /**
     *
     * @param letras
     */
    public void setLetras(ArrayList<LetterHuffman> letras) {
        this.letras = letras;
    }

    /**
     *
     * @return
     */
    public ArrayList<LetterHuffman> getLetrasCodificado() {
        return letrasCodificado;
    }

    /**
     *
     * @param letrasCodificado
     */
    public void setLetrasCodificado(ArrayList<LetterHuffman> letrasCodificado) {
        this.letrasCodificado = letrasCodificado;
    }

}
