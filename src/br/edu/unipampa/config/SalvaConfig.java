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
public class SalvaConfig {

    private ArrayList<Clube> clubes;
    private ArrayList<Jogador> jogadoresAVendaAtaque;
    private ArrayList<Jogador> jogadoresAVendaDefesa;

    public SalvaConfig() {
        this.clubes = new ArrayList<>();
        this.jogadoresAVendaAtaque = new ArrayList<>();
        this.jogadoresAVendaDefesa = new ArrayList<>();
    }

    public void criarTimesJogadores() {
        //cria times
        Clube gremio = new Clube("Grêmio", 150.0, "Luxemburgo");
        Clube juventude = new Clube("Juventude", 50.0, "Luxemburgo");
        Clube vereanopolis = new Clube("Vereanópolis", 50000, "Luxemburgo");
        Clube guaraniBage = new Clube("Guarani - Bagé", 50000, "Luxemburgo");
        Clube internacional = new Clube("Internacional", 120.0, "Dunga");
        Clube caxias = new Clube("Caxias", 32.0, "Piccoli");
        Clube saoLuizIjui = new Clube("São Luiz - Ijuí", 28.0, "Paulo Porto");
        Clube passoFundo = new Clube("Passo Fundo", 50000, "Luxemburgo");

        //cria jogadores 
        criarGremio(gremio);
        criarInternacional(internacional);
        criarSaoLuiz(saoLuizIjui);
        criarCaxias(caxias);

        //add no arraylist os clubes
        this.clubes.add(gremio);
        this.clubes.add(juventude);
        this.clubes.add(vereanopolis);
        this.clubes.add(guaraniBage);
        this.clubes.add(internacional);
        this.clubes.add(caxias);
        this.clubes.add(saoLuizIjui);
        this.clubes.add(passoFundo);

        //cria jogadores a venda
        criarJogadoresAVenda();
    }

    public void salvar() throws Exception {
        FileOutputStream fos = new FileOutputStream("build\\config.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (int i = 0; i < clubes.size(); i++) {
            oos.writeObject(clubes.get(i));
        }

        for (int i = 0; i < jogadoresAVendaAtaque.size(); i++) {
            oos.writeObject(jogadoresAVendaAtaque.get(i));
        }

        for (int i = 0; i < jogadoresAVendaDefesa.size(); i++) {
            oos.writeObject(jogadoresAVendaDefesa.get(i));
        }

        oos.flush();
        oos.close();
        fos.close();
    }

    private void criarGremio(Clube gremio) {
        ArrayList<Jogador> jogadorGremioAtaque = new ArrayList<>();
        Jogador j1 = new Jogador("E.Vargas", 99, 50.4, "Chileno", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j1);
        Jogador j2 = new Jogador("H.Barcos", 79, 29.6, "Argentino", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j2);
        Jogador j3 = new Jogador("Welliton", 84, 36.4, "Brasileiro", 26, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j3);
        Jogador j4 = new Jogador("Marcelo Moreno", 77, 26.0, "Boliviano", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j4);
        Jogador j5 = new Jogador("Zé Roberto", 80, 10.0, "Brasileiro", 38, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j5);
        Jogador j6 = new Jogador("Elano", 77, 20.6, "Brasileiro", 31, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio)        ;
        jogadorGremioAtaque.add(j6);
        Jogador j7 = new Jogador("Jean Deretti", 72, 10.4, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio);
        jogadorGremioAtaque.add(j7);
        gremio.setAtaque(jogadorGremioAtaque);

        ArrayList<Jogador> jogadorGremioDefesa = new ArrayList<>();
        Jogador j8 = new Jogador("Werley", 75, 14.00, "Brasil", 24, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j8);
        Jogador j9 = new Jogador("Cris", 79, 7.00, "Brasil", 36, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j9);
        Jogador j10 = new Jogador("Dida", 75, 5.00, "Brasil", 39, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j10);
        Jogador j11 = new Jogador("Marcelo Grohe", 77, 15.0, "Brasil", 25, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j11);
        Jogador j12 = new Jogador("Fernando", 77, 17.2, "Brasil", 22, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j12);
        Jogador j13 = new Jogador("Souza", 76, 15.0, "Brasil", 24, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j13);
        Jogador j14 = new Jogador("Pará", 70, 10.0, "Brasil", 27, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j14);
        Jogador j15 = new Jogador("André Santos", 75, 14.0, "Brasil", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j15);
        Jogador j16 = new Jogador("Bressan", 71, 9.8, "Brasil", 20, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j16);
        Jogador j17 = new Jogador("Alex Telles", 69, 5.4, "Brasil", 20, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j17);
        Jogador j18 = new Jogador("Tony", 65, 3.2, "Brasil", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio);
        jogadorGremioDefesa.add(j18);
        gremio.setDefesa(jogadorGremioDefesa);
        
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

    private void criarInternacional(Clube internacional)    {
        ArrayList<Jogador> jogadorInterAtaque = new ArrayList<>();
        Jogador j1 = new Jogador("Leandro Damião", 80, 25.1, "Brasileiro", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j1);
        Jogador j2 = new Jogador("Forlán", 82, 27.9, "Uruguaio", 32, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j2);
        Jogador j3 =new Jogador("D'Alessandro", 84, 20.4, "Argentino", 30, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j3);
        Jogador j4 = new Jogador("Gilberto", 72, 13.0, "Brasileiro", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j4);
        Jogador j5 = new Jogador("Fred", 79, 15.0, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j5);
        Jogador j6 = new Jogador("J. Dátolo", 77, 11.6, "Argentino", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j6);
        Jogador j7 = new Jogador("Caio", 72, 12.4, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional);
        jogadorInterAtaque.add(j7);
        internacional.setAtaque(jogadorInterAtaque);
        
        
        ArrayList<Jogador> jogadorInterDefesa = new ArrayList<>();
        Jogador j8 = new Jogador("Muriel", 77, 12.0, "Brasileiro", 24, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j8);
        Jogador j9 = new Jogador("Rodrigo Moledo", 79, 17.0, "Brasileiro", 26, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j9);
        Jogador j10 = new Jogador("Renan", 69, 5.6, "Brasileiro", 27, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA,internacional);
        jogadorInterDefesa.add(j10);
        Jogador j11 = new Jogador("Indio", 77, 7.0, "Brasileiro", 37, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA,internacional);
        jogadorInterDefesa.add(j11);
        Jogador j12 = new Jogador("Willians", 77, 15.9, "Brasileiro", 28, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j12);
        Jogador j13 = new Jogador("Josimar", 74, 9.9, "Brasileiro", 54, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j13);
        Jogador j14 = new Jogador("Fabricio", 69, 5.6, "Brasileiro", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j14);
        Jogador j15 = new Jogador("Kleber", 79, 12.4, "Brasileiro", 32, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j15);
        Jogador j16 = new Jogador("Airton", 74, 9.8, "Brasileiro", 20, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j16);
        Jogador j17 = new Jogador("Gabriel", 69, 5.4, "Brasileiro", 31, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j17);
        Jogador j18 = new Jogador("Juan", 81, 3.9, "Brasil", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, internacional);
        jogadorInterDefesa.add(j18);
        internacional.setDefesa(jogadorInterDefesa);
        
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

    private void criarSaoLuiz(Clube saoLuizIjui){
        ArrayList<Jogador> jogadorSaoLuizAtaque = new ArrayList<>();
        Jogador j1 = new Jogador("Gavião", 70, 14.5, "Brasileiro", 31, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j1);
        Jogador j2 = new Jogador("Eraldo", 80, 17.9, "Brasileiro", 27, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j2);
        Jogador j3 =new Jogador("Juba", 84, 22.7, "Brasileiro", 30, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j3);
        Jogador j4 = new Jogador("Tiago Duarte", 69, 13.0, "Brasileiro", 35, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j4);
        Jogador j5 = new Jogador("Chicão", 71, 8.6, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j5);
        Jogador j6 = new Jogador("Fernando", 72, 9.4, "Argentino", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j6);
        Jogador j7 = new Jogador("Baiano", 65, 6.3, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, saoLuizIjui);
        jogadorSaoLuizAtaque.add(j7);
       saoLuizIjui.setAtaque(jogadorSaoLuizAtaque);
       
       ArrayList<Jogador> jogadorSaoLuizDefesa = new ArrayList<>();
        Jogador j8 = new Jogador("Alysson Cimas", 75, 12.0, "Brasileiro",35, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j8);
        Jogador j9 = new Jogador("Oliveira", 72, 3.2, "Brasileiro", 34, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j9);
        Jogador j10 = new Jogador("Adão", 75, 7.6, "Brasileiro", 33, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA,saoLuizIjui);
        jogadorSaoLuizDefesa.add(j10);
        Jogador j11 = new Jogador("Macaé", 72, 6.0, "Brasileiro", 29, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA,saoLuizIjui);
        jogadorSaoLuizDefesa.add(j11);
        Jogador j12 = new Jogador("Marcelo Oliveira", 69, 4.9, "Brasileiro", 31, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j12);
        Jogador j13 = new Jogador("Almeida", 74, 9.9, "Brasileiro", 34, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA,saoLuizIjui);
        jogadorSaoLuizDefesa.add(j13);
        Jogador j14 = new Jogador("Marcos Paraná", 69, 5.6, "Brasileiro", 23, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j14);
        Jogador j15 = new Jogador("Marcos Rogério", 79, 12.4, "Brasileiro", 32, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j15);
        Jogador j16 = new Jogador("Júnior Barbosa", 63, 5.8, "Brasileiro", 26, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
       jogadorSaoLuizDefesa.add(j16);
        Jogador j17 = new Jogador("Thiago Costa", 61,3.4, "Brasileiro", 18, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j17);
        Jogador j18 = new Jogador("Jucilei", 67, 5.9, "Brasileiro", 22, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, saoLuizIjui);
        jogadorSaoLuizDefesa.add(j18);
        saoLuizIjui.setDefesa(jogadorSaoLuizDefesa);
        
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
    
    private void criarCaxias(Clube caxias){
         ArrayList<Jogador> jogadorCaxiasAtaque = new ArrayList<>();
        Jogador j1 = new Jogador("Tinga", 69, 10.5, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j1);
        Jogador j2 = new Jogador("Zambi", 79, 20.9, "Brasileiro", 19, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j2);
        Jogador j3 =new Jogador("Rafael Santiago", 76, 15.5, "Brasileiro", 26, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j3);
        Jogador j4 = new Jogador("Alexandre Lando", 66, 13.0, "Brasileiro", 35, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j4);
        Jogador j5 = new Jogador("Paraná", 71, 8.6, "Brasileiro", 27, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j5);
        Jogador j6 = new Jogador("Marcelo Carvalho", 62, 5.4, "Brasileiro", 35, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j6);
        Jogador j7 = new Jogador("Umberto", 70, 9.3, "Brasileiro", 29, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE,  caxias);
        jogadorCaxiasAtaque.add(j7);
       caxias.setAtaque(jogadorCaxiasAtaque);
    }
    
    private void criarJogadoresAVenda() {
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 82, 140.0, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Cristiano Ronaldo", 90, 100.0, "Português", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Miguel", 98, 78.3, "Paraguaio", 23, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Delofeo", 85, 2.9, "Espanhol", 17, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Ewerson", 81, 13.6, "Brasileiro", 31, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        
        

        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 80, 20.0, "Africano", 31, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Arex", 77, 19.0, "Paraguaio", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Sebastião", 77, 13.1, "Brasileiro", 22, PosicaoJogador.VOLANTE, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Vinicius", 2, 0.1, "Argentino", 36, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Antoni", 79, 7.9, "Italiano", 18, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        
    }
    
    
    public void Imprimir(Clube gremio){
        
        for (int i = 0; i < gremio.getAtaque().size(); i++) {
            System.out.println(gremio.getAtaque().get(i));
        }
    }
}
