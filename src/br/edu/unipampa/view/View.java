package br.edu.unipampa.view;

import br.edu.unipampa.config.SalvaConfig;
import br.edu.unipampa.entrada_saida.EntradaSaida;

/**
 *
 * @author Alex
 */
public class View {

    public static void main(String[] args) throws Exception {
        EntradaSaida entradaSaida = new EntradaSaida();
        try {
            entradaSaida.getLeConfig().le();
        } catch (Exception e) {
            SalvaConfig salvaConfig = new SalvaConfig();
            salvaConfig.criarTimesJogadores();
            salvaConfig.salvar();
            entradaSaida.getLeConfig().le();
        }
        entradaSaida.iniciarJogo();
    }
}
