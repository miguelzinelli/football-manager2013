package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;

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
    private Campeonato campeonato;

    public Partida(Clube clubeMandante, Clube clubeVisitante, Campeonato campeonato) {
        this.numeroSubstituicao = 0;
        this.golsMandante = 0;
        this.golsVisitante = 0;
        this.clubeMandante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
        this.campeonato = campeonato;
    }

    public boolean jogarPrimeiroTempo() {
        //implementar regra do jogo

        return true;
    }

    public boolean jogarSegundoTempo() {
        //implementar regra do jogo

        if (this.golsMandante == this.golsVisitante) {
            addPontosNaTabela(clubeMandante, 1);
            addPontosNaTabela(clubeVisitante, 1);
        } else {
            if (this.golsMandante > this.golsVisitante) {
                addPontosNaTabela(clubeMandante, 3);
            } else {
                addPontosNaTabela(clubeVisitante, 3);
            }
        }
        return true;
    }

    private void addPontosNaTabela(Clube clube, int pontosGanho) {
        for (int i = 0; i < this.campeonato.getTabela().size(); i++) {
            if (this.campeonato.getTabela().get(i).getClube() == clube) {
                this.campeonato.getTabela().get(i).setPontos(this.campeonato.getTabela().get(i).getPontos()
                        + pontosGanho);
            }
        }
    }

    public boolean substituicao(Jogador jogadorEntra, Jogador jogadorSai) {
        if (this.getNumeroSubstituicao() < 3) {
            if (this.campeonato.getClubeComandado() == this.clubeMandante) {
                substituir(clubeMandante, jogadorEntra, jogadorSai);
            } else {
                substituir(clubeVisitante, jogadorEntra, jogadorSai);
            }
            return true;
        } else {
            return false;
        }
    }

    private void substituir(Clube clube, Jogador jogadorEntra, Jogador jogadorSai) {
        clube.getEscalacaoTitular().remove(jogadorSai);
        clube.getEscalacaoReserva().remove(jogadorEntra);
        clube.getEscalacaoTitular().add(jogadorEntra);
        this.numeroSubstituicao++;
    }

    public String mostrarResultado() {
        return this.clubeMandante.getNome() + " " + this.golsMandante + " x "
                + this.golsVisitante + " " + this.clubeVisitante.getNome();
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

    /**
     * @return the numeroSubstituicao
     */
    public int getNumeroSubstituicao() {
        return numeroSubstituicao;
    }
}
