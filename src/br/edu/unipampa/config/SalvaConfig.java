package br.edu.unipampa.config;

import br.edu.unipampa.clube.Clube;
import br.edu.unipampa.jogador.CaracteristicaJogador;
import br.edu.unipampa.jogador.Jogador;
import br.edu.unipampa.jogador.PosicaoJogador;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Alex
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
        Clube gremio = new Clube("Grêmio", 50000, "Luxemburgo");
        Clube juventude = new Clube("Juventude", 50000, "Luxemburgo");
        Clube vereanopolis = new Clube("Vereanópolis", 50000, "Luxemburgo");
        Clube guaraniBage = new Clube("Guarani - Bagé", 50000, "Luxemburgo");
        Clube internacional = new Clube("Internacional", 50000, "Luxemburgo");
        Clube caxias = new Clube("Caxias", 50000, "Luxemburgo");
        Clube saoLuizIjui = new Clube("São Luiz - Ijuí", 50000, "Luxemburgo");
        Clube passoFundo = new Clube("Passo Fundo", 50000, "Luxemburgo");

        //cria jogadores gremio
        criarGremio(gremio);

        //cria jogadores internacional
        criarInternacional(internacional);

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

    private void criarInternacional(Clube internacional) {
        ArrayList<Jogador> jogadorInterAtaque = new ArrayList<>();
        jogadorInterAtaque.add(new Jogador("Leandro Damião", 80, 25.1, "Brasileiro", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("Forlán", 82, 27.9, "Uruguaio", 32, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("D'alessandro", 84, 20.4, "Argentino", 30, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("Gilberto", 72, 13.0, "Brasileiro", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("Fred", 79, 15.0, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("J. Dátolo", 77, 11.6, "Argentino", 26, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, internacional));
        jogadorInterAtaque.add(new Jogador("Caio", 72, 12.4, "Brasileiro", 22, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, internacional));
        internacional.setAtaque(jogadorInterAtaque);
        
        // falta desefesa e escalação tituar e reservas
    }

    private void criarJogadoresAVenda() {
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));
        this.jogadoresAVendaAtaque.add(new Jogador("Messi", 35, 4000, "Argentino", 23, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, null));

        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
        this.jogadoresAVendaDefesa.add(new Jogador("Paulão", 34, 2000, "Africano", 34, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, null));
    }
    
    public void Imprimir(Clube gremio){
        
        for (int i = 0; i < gremio.getAtaque().size(); i++) {
            System.out.println(gremio.getAtaque().get(i));
        }
    }
}
