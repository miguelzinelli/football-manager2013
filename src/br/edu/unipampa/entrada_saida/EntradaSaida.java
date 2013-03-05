package br.edu.unipampa.entrada_saida;

import br.edu.unipampa.campeonato.Campeonato;
import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.config.LerConfig;
import br.edu.unipampa.jogador.Jogador;
import br.edu.unipampa.transferencia.Transferencia;
import java.util.ArrayList;
import java.util.Random;
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
    private Campeonato campeonato;
    private Transferencia transferencia;

    public EntradaSaida() {
        this.teclado = new Scanner(System.in);
        this.lerConfig = new LerConfig();
        this.campeonato = new Campeonato();
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

    private String informarNomeTreinador() {
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
        this.campeonato.setClubeComandado(clubeComandado);
        this.campeonato.setClubes(clubes);
        this.campeonato.getClubeComandado().setTimeEscalado(false);

        System.out.println("\nOlá " + this.campeonato.getClubeComandado().getTecnico() + ", seja bem vindo ao "
                + this.campeonato.getClubeComandado().getNome() + "!\n"
                + "O campeonato acaba de começar, e você terá " + this.campeonato.getClubes().size()
                + " rodadas para conquistar o título. Boa sorte nessa caminhada!");

        proximoConfronto();
        mostrarMenuPrincipal();
    }

    private void proximoConfronto() {
        System.out.println("\nPróximo Confronto: " + this.campeonato.proximoConfronto());
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
        if (escolha.equals("1")) {
            escalarTime();
        } else {
            if (escolha.equals("2")) {
                //
            } else {
                if (escolha.equals("3")) {
                    if (!this.campeonato.getClubeComandado().isTimeEscalado()) {
                        System.out.println("\nTime não escalado para essa partida.\n");
                        mostrarMenuPrincipal();
                    } else{
                        //
                    }
                } else {
                    if (escolha.equals("4")) {
                        System.out.println("\nSaldo disponível na conta do clube: " + this.campeonato.getClubeComandado().getFinancas());
                        escolha = mostrarMenuCompraVendeJogador();
                        if (escolha.equals("1")) {
                            if (this.transferencia.getJogadoresAVenda().isEmpty()) {
                                System.out.println("\nNenhum jogador disponível para compra.");
                            } else {
                                System.out.println("\nJogadores disponíveis para compra:");
                                for (int i = 0; i < this.transferencia.getJogadoresAVenda().size(); i++) {
                                    System.out.println("  '" + (i + 1) + "' " + this.transferencia.getJogadoresAVenda().get(i).getNome()
                                            + " - Força: " + this.transferencia.getJogadoresAVenda().get(i).getForca()
                                            + " - Idade: " + this.transferencia.getJogadoresAVenda().get(i).getIdade()
                                            + " - Nacionalidade: " + this.transferencia.getJogadoresAVenda().get(i).getNacionalidade()
                                            + " - Posição: " + this.transferencia.getJogadoresAVenda().get(i).getPosicao()
                                            + " - Característica: " + this.transferencia.getJogadoresAVenda().get(i).getCaracteristica()
                                            + " - Valor: " + this.transferencia.getJogadoresAVenda().get(i).getValor());
                                }
                                comprarJogador();
                            }
                        } else {
                            if (this.campeonato.getClubeComandado().getJogadores().isEmpty()) {
                                System.out.println("\nNenhum jogador disponível para venda.");
                            } else {
                                System.out.println("\nJogadores disponíveis para venda:");
                                mostrarJogadoresClubeComandado();
                                venderJogador();
                            }

                        }
                    }
                }
            }
        }
    }

    private String mostrarMenuCompraVendeJogador() {
        System.out.println("\nO que você deseja fazer:\n --> '1' - Comprar\n --> '2' - Vender");
        escolhaString = teclado.next();
        if (this.escolhaString.equals("1") || (this.escolhaString.equals("2"))) {
            return escolhaString;
        } else {
            System.out.println("Caracter Inválido!!! Digite Novamente: ");
            return mostrarMenuCompraVendeJogador();
        }
    }

    private boolean comprarJogador() {
        System.out.println("Digite o número do jogador que deseja comprar. Digite ZERO para cancelar compra:");
        boolean caracterInvalido = false;
        try {
            this.escolhaInt = Integer.parseInt(teclado.next());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return comprarJogador();
        } else {
            if (this.escolhaInt >= 0 && this.escolhaInt <= this.transferencia.getJogadoresAVenda().size()) {
                if (this.escolhaInt != 0) {
                    if (this.transferencia.comprarJogador(this.campeonato.getClubeComandado(),
                            this.transferencia.getJogadoresAVenda().get(escolhaInt - 1))) {
                        System.out.println("\nParabéns!! Você fez um excelente negócio ao contratar o jogador "
                                + this.campeonato.getClubeComandado().getJogadores().get(this.campeonato.getClubeComandado().getJogadores().size() - 1)
                                + ", e ele já está integrado ao seu plantel.\n"
                                + "O valor em caixa do clube está em: "
                                + this.campeonato.getClubeComandado().getFinancas() + "\n");
                    } else {
                        System.out.println("\nVocê não possui dinheiro para compra o jogador "
                                + this.transferencia.getJogadoresAVenda().get(escolhaInt - 1).getNome() + "\n");
                    }
                }
                mostrarMenuPrincipal();
                return true;
            } else {
                System.out.println("Jogador não encontrado!!! Digite Novamente: ");
                return comprarJogador();
            }
        }
    }

    private boolean venderJogador() {
        System.out.println("Digite o número do jogador que deseja vender. Digite ZERO para cancelar venda:");
        boolean caracterInvalido = false;
        try {
            this.escolhaInt = Integer.parseInt(teclado.next());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return venderJogador();
        } else {
            if (this.escolhaInt >= 0 && this.escolhaInt <= this.campeonato.getClubeComandado().getJogadores().size()) {
                if (this.escolhaInt != 0) {
                    String nomeJogador = this.campeonato.getClubeComandado().getJogadores().get(escolhaInt - 1).getNome();
                    Clube clubeInteressado = sortearClubeInteressadoComprarJogador();
                    if (this.transferencia.venderJogador(this.campeonato.getClubeComandado(),
                            this.campeonato.getClubeComandado().getJogadores().get(escolhaInt - 1), clubeInteressado)) {
                        System.out.println("\nParabéns!! Você fez um excelente negócio ao vender o jogador "
                                + nomeJogador
                                + ", para o clube "
                                + clubeInteressado.getNome()
                                + " e ele não faz mais parte do seu plantel.\n"
                                + "O valor em caixa do clube está em: "
                                + this.campeonato.getClubeComandado().getFinancas() + "\n");
                    } else {
                        System.out.println("\nNenhum clube interessado ou com recursos financeiros para comprar o jogador "
                                + nomeJogador + "\n");
                    }
                }
                mostrarMenuPrincipal();
                return true;
            } else {
                System.out.println("Jogador não encontrado!!! Digite Novamente: ");
                return venderJogador();
            }
        }
    }

    private Clube sortearClubeInteressadoComprarJogador() {
        Random k = new Random();
        int sortear = k.nextInt(this.campeonato.getClubes().size() - 1);
        return this.campeonato.getClubes().get(sortear);
    }

    private void mostrarJogadoresClubeComandado() {
        for (int i = 0; i < this.campeonato.getClubeComandado().getJogadores().size(); i++) {
            System.out.println("  '" + (i + 1) + "' " + this.campeonato.getClubeComandado().getJogadores().get(i).getNome()
                    + " - Força: " + this.campeonato.getClubeComandado().getJogadores().get(i).getForca()
                    + " - Idade: " + this.campeonato.getClubeComandado().getJogadores().get(i).getIdade()
                    + " - Nacionalidade: " + this.campeonato.getClubeComandado().getJogadores().get(i).getNacionalidade()
                    + " - Posição: " + this.campeonato.getClubeComandado().getJogadores().get(i).getPosicao()
                    + " - Característica: " + this.campeonato.getClubeComandado().getJogadores().get(i).getCaracteristica()
                    + " - Valor: " + this.campeonato.getClubeComandado().getJogadores().get(i).getValor());
        }
    }

    private boolean escalarTime() {
        System.out.println("\n******** Definir Escalação ********");
        System.out.println("\nJogadores Disponíveis para partida:");
        mostrarJogadoresClubeComandado();
        System.out.println("\nEscolha 11 jogadores titular. Digite ZERO caso deseja sair da escalação.");
        ArrayList<Jogador> titular = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            System.out.println("\nDigite o Código do " + (i + 1) + " jogador:");
            this.escolhaInt = receberNumeroJogadorEscalacao();
            if (this.escolhaInt != 0) {
                if (!titular.contains(this.campeonato.getClubeComandado().getJogadores().get(this.escolhaInt - 1))) {
                    titular.add(this.campeonato.getClubeComandado().getJogadores().get(this.escolhaInt - 1));
                } else {
                    System.out.println("Jogador já escalado. Escolhe outro jogador:");
                    i--;
                }
            } else {
                mostrarMenuPrincipal();
                break;
            }
        }

        this.campeonato.getClubeComandado().setEscalacaoTitular(titular);

        System.out.println("\nEscolha até 4 jogadores reservas. Digite ZERO caso deseja sair da escalação.");
        ArrayList<Jogador> reservas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.println("\nDigite o Código do " + (i + 1) + " jogador:");
            this.escolhaInt = receberNumeroJogadorEscalacao();
            if (this.escolhaInt != 0) {
                if (titular.contains(this.campeonato.getClubeComandado().getJogadores().get(this.escolhaInt - 1))) {
                    System.out.println("Jogador já escalado no time titular. Escolhe outro jogador:");
                    i--;
                } else {
                    if (!reservas.contains(this.campeonato.getClubeComandado().getJogadores().get(this.escolhaInt - 1))) {
                        reservas.add(this.campeonato.getClubeComandado().getJogadores().get(this.escolhaInt - 1));
                        this.campeonato.getClubeComandado().setEscalacaoReserva(reservas);
                    } else {
                        System.out.println("Jogador já escalado na reserva. Escolhe outro jogador:");
                        i--;
                    }
                }
            } else {
                mostrarMenuPrincipal();
                break;
            }
        }
        return true;
    }

    public int receberNumeroJogadorEscalacao() {
        boolean caracterInvalido = false;
        try {
            this.escolhaInt = Integer.parseInt(teclado.next());
        } catch (NumberFormatException e) {
            caracterInvalido = true;
        }

        if (caracterInvalido) {
            System.out.println("\nCaracter Inválido!!! Digite Novamente: ");
            return receberNumeroJogadorEscalacao();
        } else {
            if (this.escolhaInt < 0 && this.escolhaInt > this.campeonato.getClubeComandado().getJogadores().size()) {
                System.out.println("Jogador não encontrado. Digite novamente:");
                return receberNumeroJogadorEscalacao();
            } else {
                return this.escolhaInt;
            }
        }
    }

    private void definirFormacao(ArrayList escolhidos, Jogador jogadorEscolhido) {
//        for (int i = 0; i < this.jogo.getClubeComandado().getAtaque().size(); i++) {
//
//            if (this.jogo.getClubeComandado().getAtaque().contains(jogadorEscolhido)) {
//                escolhidos.add(jogadorEscolhido);
//
//            }
//        }
    }

    /**
     * @return the leConfig
     */
    public LerConfig getLeConfig() {
        return this.lerConfig;
    }
}
