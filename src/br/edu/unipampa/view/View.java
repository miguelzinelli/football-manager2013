package br.edu.unipampa.view;

import br.edu.unipampa.config.SalvarConfig;
import br.edu.unipampa.entrada_saida.EntradaSaida;

/**
 *
 * @author Alex
 */
public class View {

    public static void main(String[] args) throws Exception {
        EntradaSaida entradaSaida = new EntradaSaida();
        try {
            entradaSaida.getLeConfig().ler();
        } catch (Exception e) {
            SalvarConfig salvarConfig = new SalvarConfig();           
            salvarConfig.criarTimesJogadores();
            salvarConfig.salvar();
            entradaSaida.getLeConfig().ler();
        }
        entradaSaida.iniciarJogo();
    }
}
