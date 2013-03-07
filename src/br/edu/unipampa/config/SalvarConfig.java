package br.edu.unipampa.config;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.CaracteristicaJogador;
import br.edu.unipampa.jogador.Jogador;
import br.edu.unipampa.jogador.PosicaoJogador;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alex and Miguel
 */
public class SalvarConfig {

    private ArrayList<Clube> clubes;
    private ArrayList<Jogador> jogadoresAVenda;

    public SalvarConfig() {
        this.clubes = new ArrayList<>();
        this.jogadoresAVenda = new ArrayList<>();
    }

    public void criarTimesJogadores() {
        //cria times
        Clube gremio = new Clube("Grêmio", 150.0, "Luxemburgo");
        Clube juventude = new Clube("Juventude", 34.8, "Lisca");
        Clube esportivo = new Clube("Esportivo", 43.6, "Luis Carlos Wink");
        Clube ceramica = new Clube("Cerâmica", 21.3, "Guilherme Macuglia");
        Clube internacional = new Clube("Internacional", 120.6, "Dunga");
        Clube caxias = new Clube("Caxias", 32.0, "Piccoli");
        Clube saoLuizIjui = new Clube("São Luiz - Ijuí", 28.0, "Paulo Porto");
        Clube saoJose = new Clube("São José", 50000, "Agenor Piccinini");

        //cria jogadores 
        criarGremio(gremio);
        criarInternacional(internacional);
        criarSaoLuiz(saoLuizIjui);
        criarCaxias(caxias);
        criarEsportivo(esportivo);
        criarJuventude(juventude);
        criarSaoJose(saoJose);
        criarCeramica(ceramica);

        //add no arraylist os clubes
        this.clubes.add(gremio);
        this.clubes.add(juventude);
        this.clubes.add(esportivo);
        this.clubes.add(ceramica);
        this.clubes.add(internacional);
        this.clubes.add(caxias);
        this.clubes.add(saoLuizIjui);
        this.clubes.add(saoJose);

        //cria jogadores a venda
        criarJogadoresAVenda();
    }

    public void salvar() throws Exception {
        FileOutputStream fos = new FileOutputStream("config\\config.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (int i = 0; i < this.clubes.size(); i++) {
            oos.writeObject(this.clubes.get(i));
        }

        for (int i = 0; i < this.jogadoresAVenda.size(); i++) {
            oos.writeObject(this.jogadoresAVenda.get(i));
        }

        oos.flush();
        oos.close();
        fos.close();
    }

    private void criarGremio(Clube gremio) {
        ArrayList<Jogador> jogadoresGremio = new ArrayList<>();
        Jogador j1 = new Jogador("E.Vargas", 99, 50.4, "Chileno", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j1);
        Jogador j2 = new Jogador("H.Barcos", 79, 29.6, "Argentino", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j2);
        Jogador j3 = new Jogador("Welliton", 84, 36.4, "Brasileiro", 26, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j3);
        Jogador j4 = new Jogador("Marcelo Moreno", 77, 26.0, "Boliviano", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j4);
        Jogador j5 = new Jogador("Zé Roberto", 80, 10.0, "Brasileiro", 38, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j5);
        Jogador j6 = new Jogador("Elano", 77, 20.6, "Brasileiro", 31, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j6);
        Jogador j7 = new Jogador("Jean Deretti", 72, 10.4, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio);
        jogadoresGremio.add(j7);
        Jogador j8 = new Jogador("Werley", 75, 14.00, "Brasil", 24, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j8);
        Jogador j9 = new Jogador("Cris", 79, 7.00, "Brasil", 36, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j9);
        Jogador j10 = new Jogador("Dida", 75, 5.00, "Brasil", 39, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j10);
        Jogador j11 = new Jogador("Marcelo Grohe", 77, 15.0, "Brasil", 25, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j11);
        Jogador j12 = new Jogador("Fernando", 77, 17.2, "Brasil", 22, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j12);
        Jogador j13 = new Jogador("Souza", 76, 15.0, "Brasil", 24, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j13);
        Jogador j14 = new Jogador("Pará", 70, 10.0, "Brasil", 27, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j14);
        Jogador j15 = new Jogador("André Santos", 75, 14.0, "Brasil", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j15);
        Jogador j16 = new Jogador("Bressan", 71, 9.8, "Brasil", 20, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j16);
        Jogador j17 = new Jogador("Alex Telles", 69, 5.4, "Brasil", 20, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j17);
        Jogador j18 = new Jogador("Tony", 65, 3.2, "Brasil", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadoresGremio.add(j18);
        gremio.setJogadores(jogadoresGremio);

        //escala padrão do time titular
        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j11);
        titular.add(j8);
        titular.add(j9);
        titular.add(j14);
        titular.add(j15);
        titular.add(j12);
        titular.add(j7);
        titular.add(j6);
        titular.add(j5);
        titular.add(j1);
        titular.add(j2);
        gremio.setEscalacaoTitular(titular);

        //escala padrão do time reserva
        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j3);
        reserva.add(j4);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j16);
        reserva.add(j17);
        reserva.add(j18);
        gremio.setEscalacaoReserva(reserva);
    }

    private void criarInternacional(Clube internacional) {
        ArrayList<Jogador> jogadoresInter = new ArrayList<>();
        Jogador j1 = new Jogador("Leandro Damião", 80, 25.1, "Brasileiro", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j1);
        Jogador j2 = new Jogador("Forlán", 82, 27.9, "Uruguaio", 32, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j2);
        Jogador j3 = new Jogador("D'Alessandro", 84, 20.4, "Argentino", 30, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j3);
        Jogador j4 = new Jogador("Gilberto", 72, 13.0, "Brasileiro", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j4);
        Jogador j5 = new Jogador("Fred", 79, 15.0, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j5);
        Jogador j6 = new Jogador("J. Dátolo", 77, 11.6, "Argentino", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j6);
        Jogador j7 = new Jogador("Caio", 72, 12.4, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadoresInter.add(j7);
        Jogador j8 = new Jogador("Muriel", 77, 12.0, "Brasileiro", 24, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j8);
        Jogador j9 = new Jogador("Rodrigo Moledo", 79, 17.0, "Brasileiro", 26, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j9);
        Jogador j10 = new Jogador("Renan", 69, 5.6, "Brasileiro", 27, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j10);
        Jogador j11 = new Jogador("Indio", 77, 7.0, "Brasileiro", 37, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j11);
        Jogador j12 = new Jogador("Willians", 77, 15.9, "Brasileiro", 28, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j12);
        Jogador j13 = new Jogador("Josimar", 74, 9.9, "Brasileiro", 54, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j13);
        Jogador j14 = new Jogador("Fabricio", 69, 5.6, "Brasileiro", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j14);
        Jogador j15 = new Jogador("Kleber", 79, 12.4, "Brasileiro", 32, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j15);
        Jogador j16 = new Jogador("Airton", 74, 9.8, "Brasileiro", 20, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j16);
        Jogador j17 = new Jogador("Gabriel", 69, 5.4, "Brasileiro", 31, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j17);
        Jogador j18 = new Jogador("Juan", 81, 3.9, "Brasil", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadoresInter.add(j18);
        internacional.setJogadores(jogadoresInter);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        internacional.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        internacional.setEscalacaoReserva(reserva);
    }

    private void criarSaoLuiz(Clube saoLuizIjui) {
        ArrayList<Jogador> jogadoresSaoLuiz = new ArrayList<>();
        Jogador j1 = new Jogador("Gavião", 70, 14.5, "Brasileiro", 31, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j1);
        Jogador j2 = new Jogador("Eraldo", 80, 17.9, "Brasileiro", 27, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j2);
        Jogador j3 = new Jogador("Juba", 84, 22.7, "Brasileiro", 30, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j3);
        Jogador j4 = new Jogador("Tiago Duarte", 69, 13.0, "Brasileiro", 35, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j4);
        Jogador j5 = new Jogador("Chicão", 71, 8.6, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j5);
        Jogador j6 = new Jogador("Fernando", 72, 9.4, "Argentino", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j6);
        Jogador j7 = new Jogador("Baiano", 65, 6.3, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadoresSaoLuiz.add(j7);
        Jogador j8 = new Jogador("Alysson Cimas", 75, 12.0, "Brasileiro", 35, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j8);
        Jogador j9 = new Jogador("Oliveira", 72, 3.2, "Brasileiro", 34, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j9);
        Jogador j10 = new Jogador("Adão", 75, 7.6, "Brasileiro", 33, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j10);
        Jogador j11 = new Jogador("Macaé", 72, 6.0, "Brasileiro", 29, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j11);
        Jogador j12 = new Jogador("Marcelo Oliveira", 69, 4.9, "Brasileiro", 31, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j12);
        Jogador j13 = new Jogador("Almeida", 74, 9.9, "Brasileiro", 34, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j13);
        Jogador j14 = new Jogador("Marcos Paraná", 69, 5.6, "Brasileiro", 23, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j14);
        Jogador j15 = new Jogador("Marcos Rogério", 79, 12.4, "Brasileiro", 32, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j15);
        Jogador j16 = new Jogador("Júnior Barbosa", 63, 5.8, "Brasileiro", 26, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j16);
        Jogador j17 = new Jogador("Thiago Costa", 61, 3.4, "Brasileiro", 18, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j17);
        Jogador j18 = new Jogador("Jucilei", 67, 5.9, "Brasileiro", 22, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadoresSaoLuiz.add(j18);
        saoLuizIjui.setJogadores(jogadoresSaoLuiz);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        saoLuizIjui.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        saoLuizIjui.setEscalacaoReserva(reserva);
    }

    private void criarCaxias(Clube caxias) {
        ArrayList<Jogador> jogadoresCaxias = new ArrayList<>();
        Jogador j1 = new Jogador("Tinga", 69, 10.5, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j1);
        Jogador j2 = new Jogador("Zambi", 79, 20.9, "Brasileiro", 19, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j2);
        Jogador j3 = new Jogador("Rafael Santiago", 76, 15.5, "Brasileiro", 26, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j3);
        Jogador j4 = new Jogador("Alexandre Lando", 66, 13.0, "Brasileiro", 35, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j4);
        Jogador j5 = new Jogador("Paraná", 71, 8.6, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j5);
        Jogador j6 = new Jogador("Marcelo Carvalho", 62, 5.4, "Brasileiro", 35, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j6);
        Jogador j7 = new Jogador("Umberto", 70, 9.3, "Brasileiro", 29, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, caxias);
        jogadoresCaxias.add(j7);
        Jogador j8 = new Jogador("Anderson", 70, 7.7, "Brasileiro", 26, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j8);
        Jogador j9 = new Jogador("André Zuba", 75, 12.6, "Brasileiro", 34, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j9);
        Jogador j10 = new Jogador("Lino", 74, 9.4, "Brasileiro", 28, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j10);
        Jogador j11 = new Jogador("Léo Norte", 69, 5.9, "Brasileiro", 23, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j11);
        Jogador j12 = new Jogador("Dener", 67, 3.7, "Brasileiro", 21, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j12);
        Jogador j13 = new Jogador("Jackson", 70, 7.3, "Brasileiro", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j13);
        Jogador j14 = new Jogador("Diego", 64, 4.7, "Brasileiro", 20, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j14);
        Jogador j15 = new Jogador("Alexandre", 75, 7.5, "Brasileiro", 24, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j15);
        Jogador j16 = new Jogador("Victor", 80, 25.8, "Brasileiro", 18, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j16);
        Jogador j17 = new Jogador("Marcelo Carvalho", 69, 3.4, "Brasileiro", 21, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j17);
        Jogador j18 = new Jogador("Umberto", 70, 9.3, "Brasileiro", 29, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, caxias);
        jogadoresCaxias.add(j18);
        caxias.setJogadores(jogadoresCaxias);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        caxias.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        caxias.setEscalacaoReserva(reserva);
    }

    private void criarEsportivo(Clube esportivo) {
        ArrayList<Jogador> jogadoresEsportivo = new ArrayList<>();
        Jogador j1 = new Jogador("Lucas Wink", 67, 5.7, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j1);
        Jogador j2 = new Jogador("Diego Campos", 80, 15.7, "Brasileiro", 27, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j2);
        Jogador j3 = new Jogador("Gilian", 79, 15.5, "Brasileiro", 27, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j3);
        Jogador j4 = new Jogador("Leo", 69, 7.8, "Brasileiro", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j4);
        Jogador j5 = new Jogador("Paulo Josué", 73, 11.3, "Brasileiro", 23, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j5);
        Jogador j6 = new Jogador("Mateus", 72, 10.5, "Brasileiro", 21, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j6);
        Jogador j7 = new Jogador("Fábio Oliveira", 75, 14.3, "Brasileiro", 31, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, esportivo);
        jogadoresEsportivo.add(j7);
        Jogador j8 = new Jogador("Lucas", 69, 6.4, "Brasileiro", 21, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j8);
        Jogador j9 = new Jogador("Fabiano", 80, 20.6, "Brasileiro", 35, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j9);
        Jogador j10 = new Jogador("Anderson Feijão", 72, 7.4, "Brasileiro", 21, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j10);
        Jogador j11 = new Jogador("Raone", 71, 7.9, "Brasileiro", 31, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j11);
        Jogador j12 = new Jogador("André", 70, 5.7, "Brasileiro", 30, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j12);
        Jogador j13 = new Jogador("Ediglê", 79, 13.3, "Brasileiro", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j13);
        Jogador j14 = new Jogador("Sávio", 69, 7.7, "Brasileiro", 28, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j14);
        Jogador j15 = new Jogador("Rafael Bittencourt", 78, 7.9, "Brasileiro", 25, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j15);
        Jogador j16 = new Jogador("Alex Deltasul", 83, 27.8, "Brasileiro", 18, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j16);
        Jogador j17 = new Jogador("Vitor Goiás ", 72, 6.4, "Brasileiro", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j17);
        Jogador j18 = new Jogador("Tcheguevara", 79, 12.3, "Brasileiro", 26, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, esportivo);
        jogadoresEsportivo.add(j18);
        esportivo.setJogadores(jogadoresEsportivo);
        
        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        esportivo.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        esportivo.setEscalacaoReserva(reserva);
    }

    private void criarJuventude(Clube juventude) {
        ArrayList<Jogador> jogadoresJuventude = new ArrayList<>();
        Jogador j1 = new Jogador("Léo", 69, 8.5, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j1);
        Jogador j2 = new Jogador("Zulu", 83, 12.7, "Brasileiro", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j2);
        Jogador j3 = new Jogador("Bérgson", 76, 10.1, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j3);
        Jogador j4 = new Jogador("Lucca", 72, 9.8, "Brasileiro", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j4);
        Jogador j5 = new Jogador("Jardel", 73, 10.3, "Brasileiro", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j5);
        Jogador j6 = new Jogador("Gustavo", 70, 8.5, "Brasileiro", 20, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j6);
        Jogador j7 = new Jogador("Rogerinho", 71, 12.3, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, juventude);
        jogadoresJuventude.add(j7);
        Jogador j8 = new Jogador("Fernando", 75, 12.7, "Brasileiro", 28, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j8);
        Jogador j9 = new Jogador("André Sangalli", 81, 18.6, "Brasileiro", 33, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j9);
        Jogador j10 = new Jogador("Gabriel Spessatto", 72, 10.4, "Brasileiro", 21, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j10);
        Jogador j11 = new Jogador("Vacaria", 75, 9.9, "Brasileiro", 33, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j11);
        Jogador j12 = new Jogador("Romano", 72, 7.7, "Brasileiro", 25, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j12);
        Jogador j13 = new Jogador("Murilo Silva", 76, 10.3, "Brasileiro", 26, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j13);
        Jogador j14 = new Jogador("Teco", 69, 3.7, "Brasileiro", 20, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j14);
        Jogador j15 = new Jogador("Leonardo", 74, 7.0, "Brasileiro", 24, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j15);
        Jogador j16 = new Jogador("Vicente", 77, 15.8, "Brasileiro", 16, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j16);
        Jogador j17 = new Jogador("Marcelo Carvalho", 69, 3.4, "Brasileiro", 21, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j17);
        Jogador j18 = new Jogador("Eduardo Brock", 72, 10.3, "Brasileiro", 21, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, juventude);
        jogadoresJuventude.add(j18);
        juventude.setJogadores(jogadoresJuventude);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        juventude.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        juventude.setEscalacaoReserva(reserva);
    }

    private void criarCeramica(Clube ceramica) {
        ArrayList<Jogador> jogadoresCeramica = new ArrayList<>();
        Jogador j1 = new Jogador("Soares", 72, 12.5, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j1);
        Jogador j2 = new Jogador("Dinei", 84, 15.7, "Brasileiro", 36, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j2);
        Jogador j3 = new Jogador("Zeferino", 70, 12.4, "Brasileiro", 31, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j3);
        Jogador j4 = new Jogador("Rafael Carvalho", 78, 15.4, "Brasileiro", 23, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j4);
        Jogador j5 = new Jogador("Berg", 72, 10.3, "Brasileiro", 24, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j5);
        Jogador j6 = new Jogador("Ramos", 66, 4.5, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j6);
        Jogador j7 = new Jogador("Zaquel", 69, 8.3, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, ceramica);
        jogadoresCeramica.add(j7);
        Jogador j8 = new Jogador("Cesar Luz", 79, 15.7, "Brasileiro", 26, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j8);
        Jogador j9 = new Jogador("Alexandre Villa", 75, 12.6, "Brasileiro", 29, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j9);
        Jogador j10 = new Jogador("Giordano", 70, 8.4, "Brasileiro", 19, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j10);
        Jogador j11 = new Jogador("Fábio Fidelis", 75, 12.9, "Brasileiro", 26, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j11);
        Jogador j12 = new Jogador("Rodrigão", 77, 9.7, "Brasileiro", 32, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j12);
        Jogador j13 = new Jogador("Xande", 76, 10.3, "Brasileiro", 19, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j13);
        Jogador j14 = new Jogador("Alexandre Bindé", 75, 5.7, "Brasileiro", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j14);
        Jogador j15 = new Jogador("Felipe Pinto", 69, 7.5, "Brasileiro", 27, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j15);
        Jogador j16 = new Jogador("Danilo Goiano", 75, 10.3, "Brasileiro", 29, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j16);
        Jogador j17 = new Jogador("Serginho Catarinense", 72, 9.4, "Brasileiro", 33, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j17);
        Jogador j18 = new Jogador("Geninho", 75, 13.3, "Brasileiro", 21, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, ceramica);
        jogadoresCeramica.add(j18);
        ceramica.setJogadores(jogadoresCeramica);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        ceramica.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        ceramica.setEscalacaoReserva(reserva);
    }

    private void criarSaoJose(Clube saoJose) {
        ArrayList<Jogador> jogadoresSaoJose = new ArrayList<>();
        Jogador j1 = new Jogador("Lucas Gaúcho", 81, 20.5, "Brasileiro", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j1);
        Jogador j2 = new Jogador("Leandro", 74, 12.7, "Brasileiro", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j2);
        Jogador j3 = new Jogador("Luizinho", 69, 7.4, "Brasileiro", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j3);
        Jogador j4 = new Jogador("Bruno Martins", 88, 6.4, "Brasileiro", 23, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j4);
        Jogador j5 = new Jogador("Negreiros", 72, 10.3, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j5);
        Jogador j6 = new Jogador("Rogério", 69, 7.5, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j6);
        Jogador j7 = new Jogador("Maycon", 70, 10.3, "Brasileiro", 28, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoJose);
        jogadoresSaoJose.add(j7);
        Jogador j8 = new Jogador("Luis Carlos", 81, 18.7, "Brasileiro", 24, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j8);
        Jogador j9 = new Jogador("Vitor", 72, 10.6, "Brasileiro", 27, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j9);
        Jogador j10 = new Jogador("Marco Militão", 81, 18.4, "Brasileiro", 22, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j10);
        Jogador j11 = new Jogador("Ronaldo Conceição", 79, 15.9, "Brasileiro", 25, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j11);
        Jogador j12 = new Jogador("Ganzer", 71, 9.7, "Brasileiro", 16, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j12);
        Jogador j13 = new Jogador("Fernando Belém", 76, 10.3, "Brasileiro", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j13);
        Jogador j14 = new Jogador("Thiago Matos", 72, 8.7, "Brasileiro", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j14);
        Jogador j15 = new Jogador("Fuska o", 75, 9.5, "Brasileiro", 29, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j15);
        Jogador j16 = new Jogador("Goiano", 81, 14.7, "Brasileiro", 33, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j16);
        Jogador j17 = new Jogador("Dinho", 81, 9.4, "Brasileiro", 29, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j17);
        Jogador j18 = new Jogador("Gabirú", 73, 6.3, "Brasileiro", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoJose);
        jogadoresSaoJose.add(j18);
        saoJose.setJogadores(jogadoresSaoJose);

        ArrayList<Jogador> titular = new ArrayList<>();
        titular.add(j8);
        titular.add(j9);
        titular.add(j11);
        titular.add(j17);
        titular.add(j14);
        titular.add(j16);
        titular.add(j12);
        titular.add(j5);
        titular.add(j3);
        titular.add(j1);
        titular.add(j2);
        saoJose.setEscalacaoTitular(titular);

        ArrayList<Jogador> reserva = new ArrayList<>();
        reserva.add(j4);
        reserva.add(j6);
        reserva.add(j7);
        reserva.add(j10);
        reserva.add(j13);
        reserva.add(j15);
        reserva.add(j18);
        saoJose.setEscalacaoReserva(reserva);
    }

    private void criarJogadoresAVenda() {
        //ataque
        this.jogadoresAVenda.add(new Jogador("Messi", 82, 90.0, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVenda.add(new Jogador("Cristiano Ronaldo", 90, 100.0, "Português", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVenda.add(new Jogador("Miguel", 98, 78.3, "Paraguaio", 23, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVenda.add(new Jogador("Delofeo", 85, 2.9, "Espanhol", 17, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVenda.add(new Jogador("Ewerson", 81, 13.6, "Brasileiro", 31, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));

        //defesa
        this.jogadoresAVenda.add(new Jogador("Paulão", 80, 20.0, "Africano", 31, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVenda.add(new Jogador("Arex", 77, 19.0, "Paraguaio", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVenda.add(new Jogador("Sebastião", 77, 13.1, "Brasileiro", 22, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVenda.add(new Jogador("Vinicius", 2, 0.1, "Argentino", 36, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVenda.add(new Jogador("Antoni", 79, 7.9, "Italiano", 18, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
    }
}
