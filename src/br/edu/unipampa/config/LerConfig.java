package br.edu.unipampa.config;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class LerConfig {

    private ArrayList<Clube> clubes;
    private ArrayList<Jogador> jogadoresAVenda;

    /**
     * Método Construtor Default
     */
    public LerConfig() {
        this.clubes = new ArrayList<>();
        this.jogadoresAVenda = new ArrayList<>();
    }

    /**
     * Método para ler o arquivo de configuração
     *
     * @throws Exception
     */
    public void ler() throws Exception {
        FileInputStream fis = new FileInputStream("config\\config.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        for (int i = 0; i < 8; i++) {
            this.clubes.add((Clube) ois.readObject());
        }

        for (int i = 8; i < 18; i++) {
            this.jogadoresAVenda.add((Jogador) ois.readObject());
        }

        ois.close();
        fis.close();
    }

    /**
     * Método que retorna os clubes
     *
     * @return clubes - Clube
     */
    public ArrayList<Clube> getClubes() {
        return this.clubes;
    }

    /**
     * Método que retorna os jogadores a venda
     *
     * @return jogadoresAVenda - Jogador
     */
    public ArrayList<Jogador> getJogadoresAVenda() {
        return this.jogadoresAVenda;
    }
}
