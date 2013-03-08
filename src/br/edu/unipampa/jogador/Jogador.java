package br.edu.unipampa.jogador;

import br.edu.unipampa.clube.Clube;
import java.io.Serializable;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
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

    /**
     * Método Construtor Default
     */
    public Jogador() {
    }

    /**
     * Método Construtor com parâmetros
     *
     * @param nome - String
     * @param forca - int
     * @param valor - double
     * @param nacionalidade - String
     * @param idade - int
     * @param posicao - PosicaoJogador
     * @param caracteristica - CaracteristicaJogador
     * @param clubeAtual - Clube
     */
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
     * Método que retorna o Nome jo jogador
     *
     * @return nome - String
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que retorna a força
     *
     * @return forca - int
     */
    public int getForca() {
        return this.forca;
    }

    /**
     * Método que retorna o valor
     *
     * @return valor - double
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * Método que retorna a nacionalidade
     *
     * @return nacionalidade - String
     */
    public String getNacionalidade() {
        return this.nacionalidade;
    }

    /**
     * Método que retorna a idade
     *
     * @return idade - int
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Método que retorna a posição do jogador
     *
     * @return posicao - PosicaoJogador
     */
    public PosicaoJogador getPosicao() {
        return this.posicao;
    }

    /**
     * Método que retorna a caracteristica do jogador
     *
     * @return caracteristica - CaracteristicaJogador
     */
    public CaracteristicaJogador getCaracteristica() {
        return this.caracteristica;
    }

    /**
     * Método que retorna o clube atual
     *
     * @return clubeAtual - Clube
     */
    public Clube getClubeAtual() {
        return this.clubeAtual;
    }

    /**
     * Métod que seta o clube atual
     *
     * @param clubeAtual - Clube
     */
    public void setClubeAtual(Clube clubeAtual) {
        this.clubeAtual = clubeAtual;
    }
}
