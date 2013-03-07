package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class Campeonato {

    private Clube clubeComandado;
    private ArrayList<Clube> clubes;
    private Partida[][] partidas;
    private int rodadaAtual;
    private ArrayList<Tabela> tabela;

    public Campeonato() {
        this.rodadaAtual = 1;
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

    public void montarCampeonato() {
        this.partidas = new Partida[7][4];
        
        //primeira rodada
        this.partidas[0][0] = new Partida(this.clubeComandado, this.clubes.get(5), this);
        this.partidas[0][1] = new Partida(this.clubes.get(2), this.clubes.get(3), this);
        this.partidas[0][2] = new Partida(this.clubes.get(1), this.clubes.get(4), this);
        this.partidas[0][3] = new Partida(this.clubes.get(0), this.clubes.get(6), this);

        //segunda rodada
        this.partidas[1][0] = new Partida(this.clubeComandado,this.clubes.get(4), this);
        this.partidas[1][1] = new Partida(this.clubes.get(5), this.clubes.get(6), this);
        this.partidas[1][2] = new Partida(this.clubes.get(2), this.clubes.get(0), this);
        this.partidas[1][3] = new Partida(this.clubes.get(3), this.clubes.get(1), this);

        //terceira rodada
        this.partidas[2][0] = new Partida(this.clubeComandado, this.clubes.get(3), this);
        this.partidas[2][1] = new Partida(this.clubes.get(0), this.clubes.get(5), this);
        this.partidas[2][2] = new Partida(this.clubes.get(1), this.clubes.get(2), this);
        this.partidas[2][3] = new Partida(this.clubes.get(6), this.clubes.get(4), this);

        //quarta rodada
        this.partidas[3][0] = new Partida(this.clubeComandado, this.clubes.get(2), this);
        this.partidas[3][1] = new Partida(this.clubes.get(1), this.clubes.get(0), this);
        this.partidas[3][2] = new Partida(this.clubes.get(3), this.clubes.get(6), this);
        this.partidas[3][3] = new Partida(this.clubes.get(4), this.clubes.get(5), this);

        //quinta rodada
        this.partidas[4][0] = new Partida(this.clubeComandado, this.clubes.get(1), this);
        this.partidas[4][1] = new Partida(this.clubes.get(6), this.clubes.get(2), this);
        this.partidas[4][2] = new Partida(this.clubes.get(0), this.clubes.get(4), this);
        this.partidas[4][3] = new Partida(this.clubes.get(5), this.clubes.get(3), this);

        //sexta rodada
        this.partidas[5][0] = new Partida(this.clubeComandado, this.clubes.get(0), this);
        this.partidas[5][1] = new Partida(this.clubes.get(1), this.clubes.get(6), this);
        this.partidas[5][2] = new Partida(this.clubes.get(2), this.clubes.get(5), this);
        this.partidas[5][3] = new Partida(this.clubes.get(3), this.clubes.get(4), this);

        //setima rodada
        this.partidas[6][0] = new Partida(this.clubeComandado, this.clubes.get(6), this);
        this.partidas[6][1] = new Partida(this.clubes.get(1), this.clubes.get(5), this);
        this.partidas[6][2] = new Partida(this.clubes.get(4), this.clubes.get(2), this);
        this.partidas[6][3] = new Partida(this.clubes.get(0), this.clubes.get(3), this);
        
        //monta tabela
        this.tabela = new ArrayList<>();
                
        this.getTabela().add(new Tabela(clubeComandado));
        for (int i = 0; i < this.clubes.size(); i++) {
            this.getTabela().add(new Tabela(this.clubes.get(i)));
        }
    }

    public String proximoConfronto() {
        return this.getPartidas()[this.getRodadaAtual() - 1][0].getClubeMandante().getNome()
                + " x "
                + this.getPartidas()[this.getRodadaAtual() - 1][0].getClubeVisitante().getNome();
    }    

    /**
     * @return the rodadaAtual
     */
    public int getRodadaAtual() {
        return rodadaAtual;
    }

    /**
     * @param rodadaAtual the rodadaAtual to set
     */
    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    /**
     * @return the partidas
     */
    public Partida[][] getPartidas() {
        return partidas;
    }

    /**
     * @return the tabela
     */
    public ArrayList<Tabela> getTabela() {
        return ordenarClassificacao(tabela);
    }
    
    private ArrayList<Tabela> ordenarClassificacao(ArrayList<Tabela> tabela) {
        Collections.sort(tabela, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Tabela p1 = (Tabela) o1;
                Tabela p2 = (Tabela) o2;
                return p1.getPontos() < p2.getPontos() ? -1 : (p1.getPontos() > p2.getPontos() ? +1 : 0);
            }
        });
        Collections.reverse(tabela);

        return tabela;
    }
}
