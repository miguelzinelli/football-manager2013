package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Campeonato {
    
    private ArrayList<Clube> clubes;
    private Clube clubeComandado;
    
    public Campeonato(){
        
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
    
    
}
