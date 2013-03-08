package br.edu.unipampa.campeonato;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.CaracteristicaJogador;
import br.edu.unipampa.jogador.Jogador;
import java.util.Random;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class Partida {

    private int numeroSubstituicao;
    private Clube clubeMandante;
    private Clube clubeVisitante;
    private int golsMandante;
    private int golsVisitante;
    private Campeonato campeonato;

    /**
     * Método Construtor Default
     */
    public Partida() {
    }

    /**
     * Método Construtor com parâmetros
     *
     * @param clubeMandante - Clube
     * @param clubeVisitante - Clube
     * @param campeonato - Campeonato
     */
    public Partida(Clube clubeMandante, Clube clubeVisitante, Campeonato campeonato) {
        this.numeroSubstituicao = 0;
        this.golsMandante = 0;
        this.golsVisitante = 0;
        this.clubeMandante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
        this.campeonato = campeonato;
    }

    /**
     * Método para jogar primeiro tempo
     *
     * @return boolean - retorna o fim do primeiro tempo
     */
    public boolean jogarPrimeiroTempo() {
        jogar();
        return true;
    }

    /**
     * Método para jogar o segundo tempo
     *
     * @return boolean - retorna o fim do jogo
     */
    public boolean jogarSegundoTempo() {
        jogar();
        if (this.golsMandante == this.golsVisitante) {
            addPontosNaTabela(clubeMandante, 1);
            addPontosNaTabela(clubeVisitante, 1);
        } else {
            if (this.golsMandante > this.golsVisitante) {
                addPontosNaTabela(clubeMandante, 3);
            } else {
                addPontosNaTabela(clubeVisitante, 3);
            }
        }
        return true;
    }

    /**
     * Método para comparar os clubes
     */
    private void jogar() {
        for (int i = 0; i < 4; i++) {
            verificaForcaClubes(CaracteristicaJogador.ATAQUE, CaracteristicaJogador.DEFESA);
            verificaForcaClubes(CaracteristicaJogador.DEFESA, CaracteristicaJogador.ATAQUE);
        }
    }

    /**
     * Método para fazer gol
     *
     * @param clube - Clube
     */
    private void fazerGol(Clube clube) {
        if (clube == this.clubeMandante) {
            this.golsMandante++;
        } else {
            this.golsVisitante++;
        }
    }

    /**
     * Método para verificar forcas dos clubes pelas caracteristica
     *
     * @param caracteristicaMandante - CaracteristicaJogador mandante
     * @param caracteristicaVisitante - CaracteristicaJogador visitante
     */
    private void verificaForcaClubes(CaracteristicaJogador caracteristicaMandante,
            CaracteristicaJogador caracteristicaVisitante) {
        int forcaMandante = somaForcaJogadores(this.clubeMandante, caracteristicaMandante);
        int forcaVisitante = somaForcaJogadores(this.clubeVisitante, caracteristicaVisitante);
        if (forcaMandante > forcaVisitante) {
            fazerGol(clubeMandante);
        }
        if (forcaMandante < forcaVisitante) {
            fazerGol(clubeVisitante);
        }
    }

    /**
     * Método para somar forças dos jogadores por caracterisca
     *
     * @param clube - Clube
     * @param caracteristica - CaracteristicaJogador
     * @return int - retorna a força total
     */
    private int somaForcaJogadores(Clube clube, CaracteristicaJogador caracteristica) {
        Random k = new Random();
        int totalForca = 0;
        for (int i = 0; i < clube.getEscalacaoTitular().size(); i++) {
            if (clube.getEscalacaoTitular().get(i).getCaracteristica() == caracteristica) {
                totalForca += clube.getEscalacaoTitular().get(i).getForca();
            }
        }
        return (totalForca * k.nextInt(8));
    }

    /**
     * Método para adicionar pontos na tabela
     *
     * @param clube - CLube
     * @param pontosGanho - int
     */
    private void addPontosNaTabela(Clube clube, int pontosGanho) {
        for (int i = 0; i < this.campeonato.getTabela().size(); i++) {
            if (this.campeonato.getTabela().get(i).getClube() == clube) {
                this.campeonato.getTabela().get(i).setPontos(this.campeonato.getTabela().get(i).getPontos()
                        + pontosGanho);
            }
        }
    }

    /**
     * Método para substituir jogador
     *
     * @param jogadorEntra - Jogador
     * @param jogadorSai - Jogador
     * @return boolean - retorna se substituiu
     */
    public boolean substituicao(Jogador jogadorEntra, Jogador jogadorSai) {
        if (this.getNumeroSubstituicao() < 3) {
            if (this.campeonato.getClubeComandado() == this.clubeMandante) {
                substituir(clubeMandante, jogadorEntra, jogadorSai);
            } else {
                substituir(clubeVisitante, jogadorEntra, jogadorSai);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para realizar substituição
     *
     * @param clube - Clube
     * @param jogadorEntra - Jogador
     * @param jogadorSai - Jogador
     */
    private void substituir(Clube clube, Jogador jogadorEntra, Jogador jogadorSai) {
        clube.getEscalacaoTitular().remove(jogadorSai);
        clube.getEscalacaoReserva().remove(jogadorEntra);
        clube.getEscalacaoTitular().add(jogadorEntra);
        this.numeroSubstituicao++;
    }

    /**
     * Método para mostrar resultado
     *
     * @return String
     */
    public String mostrarResultado() {
        return this.clubeMandante.getNome() + " " + this.golsMandante + " x "
                + this.golsVisitante + " " + this.clubeVisitante.getNome();
    }

    /**
     * Método que retorna o clube mandante
     *
     * @return clubeMandante - Clube
     */
    public Clube getClubeMandante() {
        return this.clubeMandante;
    }

    /**
     * Método que retorna o clube visitante
     *
     * @return clubeVisitante - Clube
     */
    public Clube getClubeVisitante() {
        return this.clubeVisitante;
    }

    /**
     * Método que retorna o número de substituição feita
     *
     * @return numeroSubstituicao - int
     */
    public int getNumeroSubstituicao() {
        return this.numeroSubstituicao;
    }
}
