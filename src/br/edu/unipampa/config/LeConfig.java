package br.edu.unipampa.config;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class LeConfig {

    private ArrayList<Clube> clubes;
    private ArrayList<Jogador> jogadoresAVendaAtaque;
    private ArrayList<Jogador> jogadoresAVendaDefesa;

    public LeConfig() {
    }

    public void le() throws Exception {
        clubes = new ArrayList<>();
        jogadoresAVendaAtaque = new ArrayList<>();
        jogadoresAVendaDefesa = new ArrayList<>();

        FileInputStream fis = new FileInputStream("build\\config.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        for (int i = 0; i < 8; i++) {
            getClubes().add((Clube) ois.readObject());
        }
        
        for (int i = 8; i < 18; i++) {
            getJogadoresAVendaAtaque().add((Jogador) ois.readObject());
        }
        
        for (int i = 18; i < 28; i++) {
            getJogadoresAVendaDefesa().add((Jogador) ois.readObject());
        }

        ois.close();
        fis.close();
    }

    /**
     * @return the clubes
     */
    public ArrayList<Clube> getClubes() {
        return clubes;
    }

    /**
     * @return the jogadoresAVendaAtaque
     */
    public ArrayList<Jogador> getJogadoresAVendaAtaque() {
        return jogadoresAVendaAtaque;
    }

    /**
     * @return the jogadoresAVendaDefesa
     */
    public ArrayList<Jogador> getJogadoresAVendaDefesa() {
        return jogadoresAVendaDefesa;
    }
}
