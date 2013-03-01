/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.jogador;

/**
 *
 * @author Miguel
 */
public class Jogador {
    
    private String nome;
    private int forca;
    private double valor;
    private String nacionalidade;
    
    
    public Jogador(String nome, int forca, double valor, String nacionalidade){
        this.nome = nome;
        this.forca = forca;
        this.valor = valor;
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return a forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * @return o valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return a nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }
}
