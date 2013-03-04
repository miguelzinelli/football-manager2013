package br.edu.unipampa.campeonato;

/**
 *
 * @author Alex
 */
public class Jogo extends Campeonato {

    public void iniciarJogo() {
    }

    public void escalarTime() {
    }

    public String proximoConfronto() {
        return this.getClubeComandado().getNome() + " x " + this.getClubes().get(this.numeroPartidas - 1).getNome();
    }
}
