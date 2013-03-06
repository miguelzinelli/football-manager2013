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
    private Partida[][] partidas;
    private int rodadaAtual;

    public Campeonato() {
        this.rodadaAtual = 1;
        this.partidas = new Partida[7][4];
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
        return this.partidas[this.rodadaAtual - 1][0].getClubeMandante().getNome()
                + " x "
                + this.partidas[this.rodadaAtual - 1][0].getClubeVisitante().getNome();
    }

    public void montarCampeonato() {
        //primeira rodada
        this.partidas[0][0] = new Partida(this.clubeComandado, this.clubes.get(5));
        this.partidas[0][1] = new Partida(this.clubes.get(2), this.clubes.get(3));
        this.partidas[0][2] = new Partida(this.clubes.get(1), this.clubes.get(4));
        this.partidas[0][3] = new Partida(this.clubes.get(0), this.clubes.get(6));

        //segunda rodada
        this.partidas[1][0] = new Partida(this.clubeComandado,this.clubes.get(4));
        this.partidas[1][1] = new Partida(this.clubes.get(5), this.clubes.get(6));
        this.partidas[1][2] = new Partida(this.clubes.get(2), this.clubes.get(0));
        this.partidas[1][3] = new Partida(this.clubes.get(3), this.clubes.get(1));

        //terceira rodada
        this.partidas[2][0] = new Partida(this.clubeComandado, this.clubes.get(3));
        this.partidas[2][1] = new Partida(this.clubes.get(0), this.clubes.get(5));
        this.partidas[2][2] = new Partida(this.clubes.get(1), this.clubes.get(2));
        this.partidas[2][3] = new Partida(this.clubes.get(6), this.clubes.get(4));

        //quarta rodada
        this.partidas[3][0] = new Partida(this.clubeComandado, this.clubes.get(2));
        this.partidas[3][1] = new Partida(this.clubes.get(1), this.clubes.get(0));
        this.partidas[3][2] = new Partida(this.clubes.get(3), this.clubes.get(6));
        this.partidas[3][3] = new Partida(this.clubes.get(4), this.clubes.get(5));

        //quinta rodada
        this.partidas[4][0] = new Partida(this.clubeComandado, this.clubes.get(1));
        this.partidas[4][1] = new Partida(this.clubes.get(6), this.clubes.get(2));
        this.partidas[4][2] = new Partida(this.clubes.get(0), this.clubes.get(4));
        this.partidas[4][3] = new Partida(this.clubes.get(5), this.clubes.get(3));

        //sexta rodada
        this.partidas[5][0] = new Partida(this.clubeComandado, this.clubes.get(0));
        this.partidas[5][1] = new Partida(this.clubes.get(1), this.clubes.get(6));
        this.partidas[5][2] = new Partida(this.clubes.get(2), this.clubes.get(5));
        this.partidas[5][3] = new Partida(this.clubes.get(3), this.clubes.get(4));

        //setima rodada
        this.partidas[6][0] = new Partida(this.clubeComandado, this.clubes.get(6));
        this.partidas[6][1] = new Partida(this.clubes.get(1), this.clubes.get(5));
        this.partidas[6][2] = new Partida(this.clubes.get(4), this.clubes.get(2));
        this.partidas[6][3] = new Partida(this.clubes.get(0), this.clubes.get(3));
        
        imprimirJogos();
    }

    public void imprimirJogos() {
        System.out.println("");
        for (int i = 0; i < this.partidas.length; i++) {
            System.out.println("rodada: " + (i + 1));
            for (int j = 0; j < 4; j++) {
                System.out.println("" + this.partidas[i][j].getClubeMandante().getNome()
                        + " x "
                        + this.partidas[i][j].getClubeVisitante().getNome());
            }
        }
        System.out.println("");
    }
}
