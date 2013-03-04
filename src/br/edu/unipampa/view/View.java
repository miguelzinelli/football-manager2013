package br.edu.unipampa.view;

import br.edu.unipampa.config.SalvaConfig;
import br.edu.unipampa.entrada_saida.EntradaSaida;
import br.edu.unipampa.jogador.Jogador;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class View {

    private ArrayList<Jogador> escolhidos;
    
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
