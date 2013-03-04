package br.edu.unipampa.entrada_saida;

import br.edu.unipampa.campeonato.Jogo;
import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.config.LeConfig;
import br.edu.unipampa.transferencia.Transferencia;
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
    private Jogo jogo;
    private Transferencia transferencia;

    public EntradaSaida() {
        this.teclado = new Scanner(System.in);
        this.leConfig = new LeConfig();
        this.jogo = new Jogo();
        this.transferencia = new Transferencia();
    }

    public void iniciarJogo() {
        System.out.println("Bem Vindo ao FootballPampa!\n");
        String nomeTreinador = informarNomeTreinador();
        Clube timeComandado = escolherTime();
        timeComandado.setTecnico(nomeTreinador);
        this.leConfig.getClubes().remove(escolhaInt - 1);

        this.transferencia.setJogadoresAVendaAtaque(this.leConfig.getJogadoresAVendaAtaque());
        this.transferencia.setJogadoresAVendaDefesa(this.leConfig.getJogadoresAVendaDefesa());

        iniciarCampeonato(timeComandado, this.leConfig.getClubes());
    }

    public String informarNomeTreinador() {
        System.out.println("Digite seu nome:");

        this.escolhaString = teclado.nextLine();
        if (this.escolhaString.equalsIgnoreCase("")) {
            System.out.println("\nNome não informado!!! Digite Novamente: ");
            return informarNomeTreinador();
        } else {
            return this.escolhaString;
        }
    }

    private Clube escolherTime() {
        System.out.println("\nEscolha o Time que deseja comandar:");
        for (int i = 0; i < this.leConfig.getClubes().size(); i++) {
            System.out.println(" --> Digite '" + (i + 1) + "' para treinar o " + this.leConfig.getClubes().get(i).getNome());
        }
        boolean caracterInvalido = false;
        try {
            this.escolhaInt = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return escolherTime();
        } else {
            if (this.escolhaInt >= 1 && this.escolhaInt <= this.leConfig.getClubes().size()) {
                return this.leConfig.getClubes().get(this.escolhaInt - 1);
            } else {
                System.out.println("\nTime não encontrado!!! Digite Novamente: ");
                return escolherTime();
            }
        }
    }

    private void iniciarCampeonato(Clube clubeComandado, ArrayList<Clube> clubes) {
        this.jogo.setClubeComandado(clubeComandado);
        this.jogo.setClubes(clubes);

        System.out.println("\nOlá " + this.jogo.getClubeComandado().getTecnico() + ", seja bem vindo ao "
                + this.jogo.getClubeComandado().getNome() + "!\n"
                + "O campeonato acaba de começar, e você terá " + this.jogo.getClubes().size()
                + " rodadas para conquistar o título. Boa sorte nessa caminhada!");

        mostrarMenuPrincipal();
    }

    private void proximoConfronto() {
        System.out.println("\nPróximo Confronto: " + this.jogo.proximoConfronto());
    }

    private String mostrarMenuPrincipal() {
        proximoConfronto();
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------"
                + "\nO que deseja fazer?\n     Tecle '1' para Escalar Time    -    Tecle '2' para Classificação    -    Tecle '3' para Iniciar Jogo    -    Tecle '4' para Comprar/Vender Jogador"
                + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.escolhaString = teclado.next();
        if (this.escolhaString.equals("1") || (this.escolhaString.equals("2")) || (this.escolhaString.equals("3")) || (this.escolhaString.equals("4"))) {
            return this.escolhaString;
        } else {
            System.out.println("Caracter Inválido!!! Digite Novamente: ");
            return mostrarMenuPrincipal();
        }
    }

    /**
     * @return the leConfig
     */
    public LeConfig getLeConfig() {
        return this.leConfig;
    }
}
