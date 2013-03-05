package br.edu.unipampa.config;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class LerConfig {

    private ArrayList<Clube> clubes;
    private ArrayList<Jogador> jogadoresAVendaAtaque;
    private ArrayList<Jogador> jogadoresAVendaDefesa;

    public LerConfig() {
        this.clubes = new ArrayList<>();
        this.jogadoresAVendaAtaque = new ArrayList<>();
        this.jogadoresAVendaDefesa = new ArrayList<>();
    }

    public void ler() throws Exception {
        FileInputStream fis = new FileInputStream("build\\config.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        for (int i = 0; i < 8; i++) {
            this.clubes.add((Clube) ois.readObject());
        }

        for (int i = 8; i < 13; i++) {
            this.jogadoresAVendaAtaque.add((Jogador) ois.readObject());
        }

        for (int i = 13; i < 18; i++) {
            this.jogadoresAVendaDefesa.add((Jogador) ois.readObject());
        }

        ois.close();
        fis.close();
    }

    /**
     * @return the clubes
     */
    public ArrayList<Clube> getClubes() {
        return this.clubes;
    }

    /**
     * @return the jogadoresAVendaAtaque
     */
    public ArrayList<Jogador> getJogadoresAVendaAtaque() {
        return this.jogadoresAVendaAtaque;
    }

    /**
     * @return the jogadoresAVendaDefesa
     */
    public ArrayList<Jogador> getJogadoresAVendaDefesa() {
        return this.jogadoresAVendaDefesa;
    }
}