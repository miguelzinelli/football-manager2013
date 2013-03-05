package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;

/**
 *
 * @author Alex
 */
public class Partida {

    private int numeroSubstituicao;
    private Clube clubeMandante;
    private Clube clubeVisitante;
    private int golsMandante;
    private int golsVisitante;

    public Partida(Clube clubeMandante, Clube clubeVisitante) {
        this.numeroSubstituicao = 3;
        this.golsMandante = 0;
        this.golsVisitante = 0;
        this.clubeMandante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
    }

    public void iniciarJogo() {
    }

    public void terminarJogo() {
    }

    public void substituicao() {
    }

    /**
     * @return the clubeMandante
     */
    public Clube getClubeMandante() {
        return clubeMandante;
    }

    /**
     * @return the clubeVisitante
     */
    public Clube getClubeVisitante() {
        return clubeVisitante;
    }
}
