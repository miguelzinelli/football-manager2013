package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Campeonato {

    private Clube clubeComandado;
    private ArrayList<Clube> clubes;    
    protected int numeroPartidas;
    private ArrayList<Partida> partidas;
    private int rodadaAtual;

    public Campeonato() {
        this.partidas = new ArrayList<>();
        this.rodadaAtual = 1;
        montarCampeonato();
    }

    /**
     * @return the clubes
     */
    public ArrayList<Clube> getClubes() {
        return this.clubes;
    }

    /**
     * @param clubes the clubes to set
     */
    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
        this.numeroPartidas = this.clubes.size();
    }

    /**
     * @return the clubeComandado
     */
    public Clube getClubeComandado() {
        return this.clubeComandado;
    }

    /**
     * @param clubeComandado the clubeComandado to set
     */
    public void setClubeComandado(Clube clubeComandado) {
        this.clubeComandado = clubeComandado;
    }

    public String proximoConfronto() {
        return this.getClubeComandado().getNome() + " x " + this.getClubes().get(this.numeroPartidas - 1).getNome();
    }
    
    private void montarCampeonato(){

    }
}
