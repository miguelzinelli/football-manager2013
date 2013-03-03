package br.edu.unipampa.view;

import br.edu.unipampa.config.LeConfig;
import br.edu.unipampa.config.SalvaConfig;

/**
 *
 * @author Alex
 */
public class View {

    public static void main(String[] args) throws Exception {
        LeConfig leConfig = new LeConfig();
        try {
            leConfig.le();
        } catch (Exception e) {
            SalvaConfig salvaConfig = new SalvaConfig();
            salvaConfig.criarTimesJogadores();
            salvaConfig.salvar();
            leConfig.le();
        }
        
        System.out.println("Clubes");
        for (int i = 0; i < leConfig.getClubes().size(); i++) {
            System.out.println("" + leConfig.getClubes().get(i).getNome());
        }
        
        System.out.println("Jogadores venda ataque");
        for (int i = 0; i < leConfig.getJogadoresAVendaAtaque().size(); i++) {
            System.out.println("" + leConfig.getJogadoresAVendaAtaque().get(i).getNome());
        }
        
        System.out.println("Jogadores venda defesa");
        for (int i = 0; i < leConfig.getJogadoresAVendaDefesa().size(); i++) {
            System.out.println("" + leConfig.getJogadoresAVendaDefesa().get(i).getNome());
        }
    }
}
