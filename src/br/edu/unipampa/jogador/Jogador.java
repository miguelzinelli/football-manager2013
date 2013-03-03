package br.edu.unipampa.jogador;

import br.edu.unipampa.clube.Clube;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class Jogador implements Serializable {

    private String nome;
    private int forca;
    private int idade;
    private double valor;
    private String nacionalidade;
    private PosicaoJogador posicao;
    private CaracteristicaJogador caracteristica;
    private Clube clubeAtual;

    public Jogador(String nome, int forca, double valor, String nacionalidade,
            int idade, PosicaoJogador posicao, CaracteristicaJogador caracteristica,
            Clube clubeAtual) {
        this.nome = nome;
        this.forca = forca;
        this.valor = valor;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.posicao = posicao;
        this.caracteristica = caracteristica;
        this.clubeAtual = clubeAtual;
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return a forca
     */
    public int getForca() {
        return this.forca;
    }

    /**
     * @return o valor
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * @return a nacionalidade
     */
    public String getNacionalidade() {
        return this.nacionalidade;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the posicao
     */
    public PosicaoJogador getPosicao() {
        return this.posicao;
    }

    /**
     * @return the caracteristica
     */
    public CaracteristicaJogador getCaracteristica() {
        return this.caracteristica;
    }

    /**
     * @return the clubeAtual
     */
    public Clube getClubeAtual() {
        return this.clubeAtual;
    }

    /**
     * @param clubeAtual the clubeAtual to set
     */
    public void setClubeAtual(Clube clubeAtual) {
        this.clubeAtual = clubeAtual;
    }
}
