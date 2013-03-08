package br.edu.unipampa.transferencia;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.Jogador;
import java.util.ArrayList;

/**
 *
 * @author Alex Malmann Becker
 * @author Miguel Zinelli
 */
public class Transferencia {

    private ArrayList<Jogador> jogadoresAVenda;

    /**
     * Método Construtor Default
     */
    public Transferencia() {
    }

    /**
     * Método para comprar jogador
     *
     * @param clube - Clube - Clube que comprou
     * @param jogador - Jogador - jogador comprado
     * @return boolean - retorna se comprou jogador
     */
    public boolean comprarJogador(Clube clube, Jogador jogador) {
        if (clube.getFinancas() >= jogador.getValor()) {
            clube.entraJogador(jogador);
            this.jogadoresAVenda.remove(jogador);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para vender jogador
     *
     * @param clubeVendedor - Clube - Clube que está vendendo
     * @param jogador - Jogador - Jogador a venda
     * @param clubeInteressado - Clube - Clube interessado
     * @return boolean - retorna se vendeu jogador
     */
    public boolean venderJogador(Clube clubeVendedor, Jogador jogador, Clube clubeInteressado) {
        if (clubeInteressado.getFinancas() >= jogador.getValor()) {
            clubeInteressado.entraJogador(jogador);
            clubeVendedor.saiJogador(jogador);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que retorna os jogadores a venda
     *
     * @return jogadoresAVenda - ArrayList<Jogador>
     */
    public ArrayList<Jogador> getJogadoresAVenda() {
        return this.jogadoresAVenda;
    }

    /**
     * Método que seta os jogadores a venda
     *
     * @param jogadoresAVenda - ArrayList<Jogador>
     */
    public void setJogadoresAVenda(ArrayList<Jogador> jogadoresAVenda) {
        this.jogadoresAVenda = jogadoresAVenda;
    }
}
