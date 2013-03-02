/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.jogador;

import java.util.ArrayList;
import br.edu.unipampa.jogador.PosicaoJogador;
/**
 *
 * @author Miguel
 */
public class Jogador {
    
    private String nome;
    private int forca;
    private int idade;
    private double valor;
    private String nacionalidade;
    private PosicaoJogador posicao;
    
    
    
    public Jogador(String nome, int forca, double valor, String nacionalidade, int idade, PosicaoJogador posicao){
        this.nome = nome;
        this.forca = forca;
        this.valor = valor;
        this.nacionalidade = nacionalidade;
        this.idade= idade;
        this.posicao= posicao;
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
