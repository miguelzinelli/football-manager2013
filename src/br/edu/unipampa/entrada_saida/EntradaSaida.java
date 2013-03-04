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
    private SalvarConfig sc;

    public EntradaSaida() {
        this.teclado = new Scanner(System.in);
        this.lerConfig = new LerConfig();
        this.jogo = new Partida();
        this.transferencia = new Transferencia();
    }

    public void iniciarJogo() {
        System.out.println("Bem Vindo ao FootballPampa!\n");
        String nomeTreinador = informarNomeTreinador();
        Clube timeComandado = escolherTime();
        timeComandado.setTecnico(nomeTreinador);
        this.lerConfig.getClubes().remove(escolhaInt - 1);

        this.transferencia.setJogadoresAVendaAtaque(this.lerConfig.getJogadoresAVendaAtaque());
        this.transferencia.setJogadoresAVendaDefesa(this.lerConfig.getJogadoresAVendaDefesa());

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
                int numeroPosJogador = 0;

                if (this.transferencia.getJogadoresAVendaDefesa().isEmpty()
                        && (this.transferencia.getJogadoresAVendaAtaque().isEmpty())) {
                    System.out.println("\nNenhum jogador disponível a compra.");
                } else {
                    System.out.println("\nJogadores disponíveis para compra:");
                    if (!this.transferencia.getJogadoresAVendaDefesa().isEmpty()) {
                        System.out.println("\n  --> Jogadores de Defesa:");
                        for (int x = 0; x < this.transferencia.getJogadoresAVendaDefesa().size(); x++) {
                            System.out.println("  '" + (numeroPosJogador + 1) + "' " + this.transferencia.getJogadoresAVendaDefesa().get(x).getNome()
                                    + " - Força: " + this.transferencia.getJogadoresAVendaDefesa().get(x).getForca()
                                    + " - Idade: " + this.transferencia.getJogadoresAVendaDefesa().get(x).getIdade()
                                    + " - Nacionalidade: " + this.transferencia.getJogadoresAVendaDefesa().get(x).getNacionalidade()
                                    + " - Posição: " + this.transferencia.getJogadoresAVendaDefesa().get(x).getPosicao()
                                    + " - Valor: " + this.transferencia.getJogadoresAVendaDefesa().get(x).getValor());
                            numeroPosJogador++;
                        }
                    }

                    if (!this.transferencia.getJogadoresAVendaAtaque().isEmpty()) {
                        System.out.println("\n  --> Jogadores de Ataque:");
                        for (int y = 0; y < this.transferencia.getJogadoresAVendaAtaque().size(); y++) {
                            System.out.println("  '" + (numeroPosJogador + 1) + "' " + this.transferencia.getJogadoresAVendaAtaque().get(y).getNome()
                                    + " - Força: " + this.transferencia.getJogadoresAVendaAtaque().get(y).getForca()
                                    + " - Idade: " + this.transferencia.getJogadoresAVendaAtaque().get(y).getIdade()
                                    + " - Nacionalidade: " + this.transferencia.getJogadoresAVendaAtaque().get(y).getNacionalidade()
                                    + " - Posição: " + this.transferencia.getJogadoresAVendaAtaque().get(y).getPosicao()
                                    + " - Valor: " + this.transferencia.getJogadoresAVendaAtaque().get(y).getValor());
                            numeroPosJogador++;
                        }
                    }

                    comprarJogador(numeroPosJogador - 1);
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
            this.escolhaInt = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return comprarJogador(numeroJogadoresAVenda);
        } else {
            if (this.escolhaInt >= 0 && this.escolhaInt <= numeroJogadoresAVenda) {
                if (this.escolhaInt == 0) {
                    mostrarMenuPrincipal();
                } else {
                    if (this.transferencia.comprarJogador(this.jogo.getClubeComandado(),
                            this.transferencia.getJogadoresAVendaDefesa().get(numeroJogadoresAVenda - this.transferencia.getJogadoresAVendaDefesa().size() - 1))) {
                        System.out.println("Jogador integrado ao seu plantel.\n"
                                + "O valor em caixa do clube está em: "
                                + this.jogo.getClubeComandado().getFinancas());
                    }
                }
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
