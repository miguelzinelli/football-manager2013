/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.clube;

/**
 *
 * @author Miguel
 */
public class Clube {
    
    private String nome;
    private String descricao;
    private double financas;
   // private String calendario;
    
    
    public Clube(String nome, double financas, String descricao){
        this.nome = nome;
        this.financas = financas;
        this.descricao = descricao;
    }
}
