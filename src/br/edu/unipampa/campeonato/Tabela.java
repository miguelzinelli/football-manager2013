package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;

/**
 *
 * @author Alex
 */
public class Tabela {

    private Clube clube;
    private int pontos;
    
    public Tabela(Clube clube){
        this.clube = clube;
        this.pontos = 0;
    }

    /**
     * @return the clube
     */
    public Clube getClube() {
        return clube;
    }

    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
