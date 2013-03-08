package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class Campeonato {

    private Clube clubeComandado;
    private ArrayList<Clube> clubes;
    private Partida[][] partidas;
    private int rodadaAtual;
    private ArrayList<Tabela> tabela;

    /**
     * Método Construtor Default
     */
    public Campeonato() {
        this.rodadaAtual = 1;
    }

    /**
     * Método para montar o campeonato
     */
    public void montarCampeonato() {
        this.partidas = new Partida[7][4];

        //primeira rodada
        this.partidas[0][0] = new Partida(this.clubeComandado, this.clubes.get(5), this);
        this.partidas[0][1] = new Partida(this.clubes.get(2), this.clubes.get(3), this);
        this.partidas[0][2] = new Partida(this.clubes.get(1), this.clubes.get(4), this);
        this.partidas[0][3] = new Partida(this.clubes.get(0), this.clubes.get(6), this);

        //segunda rodada
        this.partidas[1][0] = new Partida(this.clubeComandado, this.clubes.get(4), this);
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

    /**
     * Método que retorna o próximo confronto do clube comandado
     *
     * @return String
     */
    public String proximoConfronto() {
        return this.getPartidas()[this.getRodadaAtual() - 1][0].getClubeMandante().getNome()
                + " x "
                + this.getPartidas()[this.getRodadaAtual() - 1][0].getClubeVisitante().getNome();
    }

    /**
     * Método que retorna a rodada atual
     *
     * @return rodadaAtual - int
     */
    public int getRodadaAtual() {
        return this.rodadaAtual;
    }

    /**
     * Método que seta a rodada atual
     *
     * @param rodadaAtual - int
     */
    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    /**
     * Método que retorna as partidas do campeonato
     *
     * @return partidas - Partida[][]
     */
    public Partida[][] getPartidas() {
        return this.partidas;
    }

    /**
     * Método que retorna a tabela
     *
     * @return tabela - ArrayList<Tabela>
     */
    public ArrayList<Tabela> getTabela() {
        return this.tabela;
    }

    /**
     * Método que ordena a classificação da tabela
     *
     * @return ArrayList<Tabela>
     */
    public ArrayList<Tabela> ordenarClassificacao(ArrayList<Tabela> tabela) {
        //ordena tabela
        Collections.sort(tabela, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Tabela p1 = (Tabela) o1;
                Tabela p2 = (Tabela) o2;
                return p1.getPontos() < p2.getPontos() ? -1 : (p1.getPontos() > p2.getPontos() ? +1 : 0);
            }
        });

        //ordena tabela inversa
        Collections.reverse(tabela);

        //retorna a tabela
        return tabela;
    }

    /**
     * Método que retorna os outros clubes do campeonato
     *
     * @return clubes - ArrayList<Clube>
     */
    public ArrayList<Clube> getClubes() {
        return this.clubes;
    }

    /**
     * Método que seta os outros clubes do campeonato
     *
     * @param clubes - ArrayList<Clube>
     */
    public void setClubes(ArrayList<Clube> clubes) {
        this.clubes = clubes;
    }

    /**
     * Método que retorna o clube comandado
     *
     * @return clubeComandado - Clube
     */
    public Clube getClubeComandado() {
        return this.clubeComandado;
    }

    /**
     * Método que seta o clube comandado
     *
     * @param clubeComandado - Clube
     */
    public void setClubeComandado(Clube clubeComandado) {
        this.clubeComandado = clubeComandado;
    }
}
