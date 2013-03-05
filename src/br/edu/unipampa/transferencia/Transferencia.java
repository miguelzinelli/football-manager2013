/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.transferencia;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Transferencia {
    
    private ArrayList<Jogador> jogadoresAVenda;
    
    public boolean comprarJogador(Clube clube, Jogador jogador){
        if (clube.getFinancas() >= jogador.getValor()) {
            clube.comprarJogador(jogador);
            this.jogadoresAVenda.remove(jogador);
            return true;
        } else {
            return false;   
        }        
    }
    
    public boolean venderJogador(Clube clubeVendedor, Jogador jogador, ArrayList<Clube> clubesInteressados){
        
        return false;
    }

    /**
     * @return the jogadoresAVenda
     */
    public ArrayList<Jogador> getJogadoresAVenda() {
        return this.jogadoresAVenda;
    }

    /**
     * @param jogadoresAVenda the jogadoresAVenda to set
     */
    public void setJogadoresAVenda(ArrayList<Jogador> jogadoresAVenda) {
        this.jogadoresAVenda = jogadoresAVenda;
    }   
}
