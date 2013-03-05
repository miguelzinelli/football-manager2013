package br.edu.unipampa.clube;

import br.edu.unipampa.jogador.CaracteristicaJogador;
import br.edu.unipampa.jogador.Jogador;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Clube implements Serializable {

    private String nome;
    private double financas;
    private String tecnico;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Jogador> escalacaoTitular;
    private ArrayList<Jogador> escalacaoReserva;

    public Clube(String nome, double financas, String tecnico) {
        this.nome = nome;
        this.financas = financas;
        this.tecnico = tecnico;
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return as financas(valor)
     */
    public double getFinancas() {
        return this.financas;
    }

    /**
     * @return the jogadores
     */
    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    /**
     * @return the tecnico
     */
    public String getTecnico() {
        return this.tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @param jogadores the defesa to set
     */
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * @return the escalacaoTitular
     */
    public ArrayList<Jogador> getEscalacaoTitular() {
        return escalacaoTitular;
    }

    /**
     * @param escalacaoTitular the escalacaoTitular to set
     */
    public void setEscalacaoTitular(ArrayList<Jogador> escalacaoTitular) {
        this.escalacaoTitular = escalacaoTitular;
    }

    /**
     * @return the escalacaoReserva
     */
    public ArrayList<Jogador> getEscalacaoReserva() {
        return escalacaoReserva;
    }

    /**
     * @param escalacaoReserva the escalacaoReserva to set
     */
    public void setEscalacaoReserva(ArrayList<Jogador> escalacaoReserva) {
        this.escalacaoReserva = escalacaoReserva;
    }

    public void entraJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        this.escalacaoReserva.add(jogador);
        this.financas -= jogador.getValor();
    }

    public void saiJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
        if (!this.escalacaoReserva.remove(jogador)) {
            this.escalacaoTitular.remove(jogador);
        }
        this.financas += jogador.getValor();
    }
}
