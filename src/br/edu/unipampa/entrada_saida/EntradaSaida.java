package br.edu.unipampa.entrada_saida;

import br.edu.unipampa.campeonato.Campeonato;
import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.config.LeConfig;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class EntradaSaida {

    private Scanner teclado;
    private int escolhaInt;
    private String escolhaString;
    private LeConfig leConfig;
    private Campeonato campeonato;

    public EntradaSaida() {
        this.teclado = new Scanner(System.in);
        this.leConfig = new LeConfig();
        this.campeonato = new Campeonato();
    }

    public void iniciarJogo() {
        System.out.println("Bem Vindo ao FootballPampa!\n");
        String nomeTreinador = informarNomeTreinador();
        Clube timeComandado = escolherTime();
        timeComandado.setTecnico(nomeTreinador);
        this.leConfig.getClubes().remove(escolhaInt-1);
        
        iniciarCampeonato(timeComandado, this.leConfig.getClubes());
    }

    public String informarNomeTreinador() {
        System.out.println("Digite seu nome:");

        escolhaString = teclado.nextLine();
        if (escolhaString.equalsIgnoreCase("")) {
            System.out.println("\nNome não informado!!! Digite Novamente: ");
            return informarNomeTreinador();
        } else {
            return escolhaString;
        }
    }

    private Clube escolherTime() {
        System.out.println("\nEscolha o Time que deseja comandar:");
        for (int i = 0; i < this.leConfig.getClubes().size(); i++) {
            System.out.println(" --> Digite '" + (i + 1) + "' para treinar o " + this.leConfig.getClubes().get(i).getNome());
        }
        boolean caracterInvalido = false;
        try {
            escolhaInt = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return escolherTime();
        } else {
            if (escolhaInt >= 1 && escolhaInt <= this.leConfig.getClubes().size()) {
                return this.leConfig.getClubes().get(escolhaInt - 1);
            } else {
                System.out.println("\nTime não encontrado!!! Digite Novamente: ");
                return escolherTime();
            }
        }
    }
    
    private void iniciarCampeonato(Clube clubeComandado, ArrayList<Clube> clubes){
        this.campeonato.setClubeComandado(clubeComandado);
        this.campeonato.setClubes(clubes);        
    }
    
    /**
     * @return the leConfig
     */
    public LeConfig getLeConfig() {
        return this.leConfig;
    }
    
    
    public void Imprimir(Clube gremio){
        for (int i = 0; i < gremio.getAtaque().size(); i++) {
            System.out.println(gremio.getAtaque().get(i));
        }
    }
}
