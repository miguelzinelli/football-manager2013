package br.edu.unipampa.clube;

import br.edu.unipampa.jogador.Jogador;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class Clube implements Serializable {

    private String nome;
    private double financas;
    private String tecnico;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Jogador> escalacaoTitular;
    private ArrayList<Jogador> escalacaoReserva;
    private boolean timeEscalado;

    /**
     * Construtor Default
     */
    public Clube() {
    }

    /**
     * Construtor recebendo alguns parâmetros
     *
     * @param nome - String
     * @param financas - double
     * @param tecnico - String
     */
    public Clube(String nome, double financas, String tecnico) {
        this.nome = nome;
        this.financas = financas;
        this.tecnico = tecnico;
        this.timeEscalado = false;
    }

    /**
     * Método que retorna o Nome do Clube
     *
     * @return o nome - String
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que retorna o valor de finanças do clube
     *
     * @return as financas - double
     */
    public double getFinancas() {
        return this.financas;
    }

    /**
     * Método que retorna o Nome do Técnico
     *
     * @return o tecnico - String
     */
    public String getTecnico() {
        return this.tecnico;
    }

    /**
     * Método que seta o nome do técnico
     *
     * @param tecnico - String
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * Método que retorna a lista de jogadores no clube
     *
     * @return os jogadores - ArrayList<Jogador>
     */
    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    /**
     * Método que seta os jogadores do clube
     *
     * @param jogadores - ArrayList<Jogador>
     */
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * Método que retorna a Escalação titular
     *
     * @return a escalacaoTitular - ArrayList<Jogador>
     */
    public ArrayList<Jogador> getEscalacaoTitular() {
        return this.escalacaoTitular;
    }

    /**
     * Método que seta a escalação titular
     *
     * @param escalacaoTitular - ArrayList<Jogador>
     */
    public void setEscalacaoTitular(ArrayList<Jogador> escalacaoTitular) {
        this.escalacaoTitular = escalacaoTitular;
        this.setTimeEscalado(true);
    }

    /**
     * Método que retorna a escalação reserva
     *
     * @return a escalacaoReserva - ArrayList<Jogador>
     */
    public ArrayList<Jogador> getEscalacaoReserva() {
        return this.escalacaoReserva;
    }

    /**
     * Método que seta a escalação reserva
     *
     * @param escalacaoReserva - ArrayList<Jogador>
     */
    public void setEscalacaoReserva(ArrayList<Jogador> escalacaoReserva) {
        this.escalacaoReserva = escalacaoReserva;
    }

    /**
     * Método que retorna se o time foi escalado
     *
     * @return timeEscalado - boolean
     */
    public boolean isTimeEscalado() {
        return this.timeEscalado;
    }

    /**
     * Método que seta se o time foi escalado
     *
     * @param timeEscalado - boolean
     */
    public void setTimeEscalado(boolean timeEscalado) {
        this.timeEscalado = timeEscalado;
    }

    /**
     * Método que entra jogador no clube (compra)
     *
     * @param jogador - Jogador
     */
    public void entraJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        this.escalacaoReserva.add(jogador);
        this.financas -= jogador.getValor();
    }

    /**
     * Método que sai jogador do clube (venda)
     *
     * @param jogador - Jogador
     */
    public void saiJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
        if (!this.escalacaoReserva.remove(jogador)) {
            this.escalacaoTitular.remove(jogador);
        }
        this.financas += jogador.getValor();
    }
}
