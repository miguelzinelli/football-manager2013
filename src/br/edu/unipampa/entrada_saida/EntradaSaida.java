package br.edu.unipampa.entrada_saida;

import br.edu.unipampa.campeonato.Partida;
import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.config.LerConfig;
import br.edu.unipampa.config.SalvarConfig;
import br.edu.unipampa.jogador.Jogador;
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
    private LerConfig lerConfig;
    private Partida jogo;
    private Transferencia transferencia;

    public EntradaSaida() {
        this.teclado = new Scanner(System.in);
        this.lerConfig = new LerConfig();
        this.jogo = new Partida();
        this.transferencia = new Transferencia();
    }

    public void iniciarJogo() {
        System.out.println("***** Bem Vindo ao FootballPampa! *****\n");
        String nomeTreinador = informarNomeTreinador();
        Clube timeComandado = escolherTime();
        timeComandado.setTecnico(nomeTreinador);
        this.lerConfig.getClubes().remove(escolhaInt - 1);

        this.transferencia.setJogadoresAVenda(this.lerConfig.getJogadoresAVenda());

        iniciarCampeonato(timeComandado, this.lerConfig.getClubes());
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
        for (int i = 0; i < this.lerConfig.getClubes().size(); i++) {
            System.out.println(" --> Digite '" + (i + 1) + "' para treinar o " + this.lerConfig.getClubes().get(i).getNome());
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
            if (this.escolhaInt >= 1 && this.escolhaInt <= this.lerConfig.getClubes().size()) {
                return this.lerConfig.getClubes().get(this.escolhaInt - 1);
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

        proximoConfronto();
        mostrarMenuPrincipal();
    }

    private void proximoConfronto() {
        System.out.println("\nPróximo Confronto: " + this.jogo.proximoConfronto());
    }

    private boolean mostrarMenuPrincipal() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------"
                + "-----------------------------------------------------------"
                + "\nO que deseja fazer?\n     Tecle '1' para Escalar Time    -    Tecle '2' para Classificação    "
                + "-    Tecle '3' para Iniciar Jogo    -    Tecle '4' para Comprar/Vender Jogador"
                + "\n----------------------------------------------------------------------------------------------"
                + "--------------------------------------------------------------");
        this.escolhaString = teclado.next();
        if (this.escolhaString.equals("1") || (this.escolhaString.equals("2")) || (this.escolhaString.equals("3"))
                || (this.escolhaString.equals("4"))) {
            executarAcaoEscolhidaMenuPrincipal(this.escolhaString);
            return true;
        } else {
            System.out.println("Caracter Inválido!!!\n");
            return mostrarMenuPrincipal();
        }
    }

    private void executarAcaoEscolhidaMenuPrincipal(String escolha) {
        if (escolha.equals("4")) {
            escolha = mostrarMenuCompraVendeJogador();
            if (escolha.equals("1")) {
                if (this.transferencia.getJogadoresAVenda().isEmpty()) {
                    System.out.println("\nNenhum jogador disponível para compra.");
                } else {
                    System.out.println("\nSaldo disponível na conta do clube: " + this.jogo.getClubeComandado().getFinancas());
                    System.out.println("\nJogadores disponíveis para compra:");
                    int i;
                    for (i = 0; i < this.transferencia.getJogadoresAVenda().size(); i++) {
                        System.out.println("  '" + (i + 1) + "' " + this.transferencia.getJogadoresAVenda().get(i).getNome()
                                + " - Força: " + this.transferencia.getJogadoresAVenda().get(i).getForca()
                                + " - Idade: " + this.transferencia.getJogadoresAVenda().get(i).getIdade()
                                + " - Nacionalidade: " + this.transferencia.getJogadoresAVenda().get(i).getNacionalidade()
                                + " - Posição: " + this.transferencia.getJogadoresAVenda().get(i).getPosicao()
                                + " - Característica: " + this.transferencia.getJogadoresAVenda().get(i).getCaracteristica()
                                + " - Valor: " + this.transferencia.getJogadoresAVenda().get(i).getValor());
                    }
                    comprarJogador(i);
                }
            } else {
            }
        }
    }

    private String mostrarMenuCompraVendeJogador() {
        System.out.println("O que você deseja fazer:\n --> '1' - Comprar\n --> '2' - Vender");
        escolhaString = teclado.next();
        if (this.escolhaString.equals("1") || (this.escolhaString.equals("2"))) {
            return escolhaString;
        } else {
            System.out.println("Caracter Inválido!!! Digite Novamente: ");
            return mostrarMenuCompraVendeJogador();
        }
    }

    public boolean comprarJogador(int numeroJogadoresAVenda) {
        System.out.println("Digite o número do jogador que deseja comprar. Digite ZERO para cancelar compra:");
        boolean caracterInvalido = false;
        try {
            this.escolhaInt = Integer.parseInt(teclado.next());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return comprarJogador(numeroJogadoresAVenda);
        } else {
            if (this.escolhaInt >= 0 && this.escolhaInt <= numeroJogadoresAVenda) {
                if (this.escolhaInt != 0) {
                    if (this.transferencia.comprarJogador(this.jogo.getClubeComandado(),
                            this.transferencia.getJogadoresAVenda().get(escolhaInt - 1))) {
                        System.out.println("\nParabéns!! Você fez um excelente negócio ao contratar o jogador "
                                + this.transferencia.getJogadoresAVenda().get(escolhaInt - 1).getNome()
                                + ", e ele já está integrado ao seu plantel.\n"
                                + "O valor em caixa do clube está em: "
                                + this.jogo.getClubeComandado().getFinancas() + "\n");
                    } else {
                        System.out.println("\nVocê não possui dinheiro para compra o jogador "
                                + this.transferencia.getJogadoresAVenda().get(escolhaInt - 1).getNome() + "\n");
                    }
                }
                for (int x = 0; x < this.jogo.getClubeComandado().getAtaque().size(); x++) {
                    System.out.println("ataque " + this.jogo.getClubeComandado().getAtaque().get(x).getNome());
                }
                for (int x = 0; x < this.jogo.getClubeComandado().getDefesa().size(); x++) {
                    System.out.println("defesa " + this.jogo.getClubeComandado().getDefesa().get(x).getNome());
                }
                mostrarMenuPrincipal();
                return true;
            } else {
                System.out.println("Jogador não encontrado!!! Digite Novamente: ");
                return comprarJogador(numeroJogadoresAVenda);
            }
        }
    }

    /**
     * @return the leConfig
     */
    public LerConfig getLeConfig() {
        return this.lerConfig;
    }

    public void escalarTime() {
        System.out.println("******** Definir Escalação ********");
        System.out.println("*****Escolha os jogadores para respectiva posição entre os titulares: ");
        escolhaInt = teclado.nextInt();

    }

    private void definirFormacao(ArrayList escolhidos, Jogador jogadorEscolhido) {

        for (int i = 0; i < this.jogo.getClubeComandado().getAtaque().size(); i++) {

            if (this.jogo.getClubeComandado().getAtaque().contains(jogadorEscolhido)) {
                escolhidos.add(jogadorEscolhido);

            }
        }

    }
}
