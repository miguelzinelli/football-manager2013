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
    
    private ArrayList<Jogador> jogadoresAVendaAtaque;
    private ArrayList<Jogador> jogadoresAVendaDefesa;
    
    public boolean comprarJogador(Clube clube, Jogador jogador){
        if (clube.getFinancas() >= jogador.getValor()) {
            clube.addJogadorDefesa(jogador);
            return true;
        } else {
            return false;   
        }        
    }
    
    public void venderJogador(){
        
    }

    /**
     * @return the jogadoresAVendaAtaque
     */
    public ArrayList<Jogador> getJogadoresAVendaAtaque() {
        return this.jogadoresAVendaAtaque;
    }

    /**
     * @param jogadoresAVendaAtaque the jogadoresAVendaAtaque to set
     */
    public void setJogadoresAVendaAtaque(ArrayList<Jogador> jogadoresAVendaAtaque) {
        this.jogadoresAVendaAtaque = jogadoresAVendaAtaque;
    }

    /**
     * @return the jogadoresAVendaDefesa
     */
    public ArrayList<Jogador> getJogadoresAVendaDefesa() {
        return this.jogadoresAVendaDefesa;
    }

    /**
     * @param jogadoresAVendaDefesa the jogadoresAVendaDefesa to set
     */
    public void setJogadoresAVendaDefesa(ArrayList<Jogador> jogadoresAVendaDefesa) {
        this.jogadoresAVendaDefesa = jogadoresAVendaDefesa;
    }
    
}
