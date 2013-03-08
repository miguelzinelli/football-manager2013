package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class Tabela {

    private Clube clube;
    private int pontos;

    /**
     * Método Construtor Default
     */
    public Tabela() {
    }

    /**
     * Método Construtor com parâmetro
     *
     * @param clube - Clube
     */
    public Tabela(Clube clube) {
        this.clube = clube;
        this.pontos = 0;
    }

    /**
     * Método que retorna o clube da tabela
     *
     * @return clube - Clube
     */
    public Clube getClube() {
        return this.clube;
    }

    /**
     * Método que retorna os pontos do clube
     *
     * @return pontos - int
     */
    public int getPontos() {
        return this.pontos;
    }

    /**
     * Método que seta os pontos do clube
     *
     * @param pontos - int
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
