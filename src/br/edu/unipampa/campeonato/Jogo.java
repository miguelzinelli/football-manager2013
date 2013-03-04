package br.edu.unipampa.campeonato;

/**
 *
 * @author Alex
 */
public class Jogo extends Campeonato {

    private int numeroSubstituicao;

    public Jogo() {
        this.numeroSubstituicao = 3;
    }

    public void iniciarJogo() {
    }

    public void terminarJogo() {
    }

    public void substituicao() {
    }

    public String proximoConfronto() {
        return this.getClubeComandado().getNome() + " x " + this.getClubes().get(this.numeroPartidas - 1).getNome();
    }
}
