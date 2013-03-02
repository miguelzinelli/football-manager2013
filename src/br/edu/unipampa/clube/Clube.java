/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.clube;

import br.edu.unipampa.jogador.Jogador;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Clube {
    
    private String nome;
    private double financas;
    
    
    private ArrayList<Jogador> Defesa;
    private ArrayList<Jogador> Ataque;
    private int somaValoresAtaque;
    private int somaValoresDefesa;
    
    
    public Clube(String nome, double financas, String descricao){
        this.nome = nome;
        this.financas = financas;
        
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

   

    /**
     * @return as financas(valor)
     */
    public double getFinancas() {
        return financas;
    }
    /**
     * @return the somaValoresAtaque
     */
    public int getSomaValoresAtaque() {
        return somaValoresAtaque;
    }

    /**
     * @param somaValoresAtaque the somaValoresAtaque to set
     */
    public void setSomaValoresAtaque(int somaValoresAtaque) {
        this.somaValoresAtaque = somaValoresAtaque;
    }

    /**
     * @return the somaValoresDefesa
     */
    public int getSomaValoresDefesa() {
        return somaValoresDefesa;
    }

    /**
     * @param somaValoresDefesa the somaValoresDefesa to set
     */
    public void setSomaValoresDefesa(int somaValoresDefesa) {
        this.somaValoresDefesa = somaValoresDefesa;
    }
}
