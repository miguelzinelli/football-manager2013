package br.edu.unipampa.clube;

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
    private ArrayList<Jogador> defesa;
    private ArrayList<Jogador> ataque;

    public Clube(String nome, double financas, String tecnico,
            ArrayList<Jogador> defesa, ArrayList<Jogador> ataque) {
        this.nome = nome;
        this.financas = financas;
        this.tecnico = tecnico;
        this.defesa = defesa;
        this.ataque = ataque;
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
     * @return the defesa
     */
    public ArrayList<Jogador> getDefesa() {
        return defesa;
    }

    /**
     * @return the ataque
     */
    public ArrayList<Jogador> getAtaque() {
        return ataque;
    }

    /**
     * @return the tecnico
     */
    public String getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @param defesa the defesa to set
     */
    public void setDefesa(ArrayList<Jogador> defesa) {
        this.defesa = defesa;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(ArrayList<Jogador> ataque) {
        this.ataque = ataque;
    }
}
