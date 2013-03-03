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
        Clube gremio = new Clube("Grêmio", 50000, "Luxemburgo", null, null);
        Clube juventude = new Clube("Juventude", 50000, "Luxemburgo", null, null);
        Clube vereanopolis = new Clube("Vereanópolis", 50000, "Luxemburgo", null, null);
        Clube guaraniBage = new Clube("Guarani - Bagé", 50000, "Luxemburgo", null, null);
        Clube internacional = new Clube("Internacional", 50000, "Luxemburgo", null, null);
        Clube caxias = new Clube("Caxias", 50000, "Luxemburgo", null, null);
        Clube saoLuizIjui = new Clube("São Luiz - Ijuí", 50000, "Luxemburgo", null, null);
        Clube passoFundo = new Clube("Passo Fundo", 50000, "Luxemburgo", null, null);

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
        jogadorGremioAtaque.add(new Jogador("E.Vargas", 99, 50.4, "Chileno", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("H.Barcos", 79, 29.6, "Argentino", 29, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("Welliton", 84, 36.4, "Brasileiro", 26, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("Marcelo Moreno", 77, 26.0, "Boliviano", 25, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("Zé Roberto", 80, 10.0, "Brasileiro", 38, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("Elano", 77, 20.6, "Brasileiro", 31, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio));
        jogadorGremioAtaque.add(new Jogador("Jean Deretti", 72, 10.4, "Brasileiro", 19, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.ATAQUE, gremio));
        gremio.setAtaque(jogadorGremioAtaque);

        ArrayList<Jogador> jogadorGremioDefesa = new ArrayList<>();
        jogadorGremioDefesa.add(new Jogador("Werley", 75, 14.00, "Brasil", 24, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Cris", 79, 7.00, "Brasil", 36, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Dida", 75, 5.00, "Brasil", 39, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Marcelo Grohe", 77, 15.0, "Brasil", 25, PosicaoJogador.GOLEIRO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Fernando", 77, 17.2, "Brasil", 22, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Souza", 76, 15.0, "Brasil", 24, PosicaoJogador.MEIO_CAMPO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Pará", 70, 10.0, "Brasil", 27, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("André Santos", 75, 14.0, "Brasil", 29, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Bressan", 71, 9.8, "Brasil", 20, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Alex Telles", 69, 5.4, "Brasil", 20, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio));
        jogadorGremioDefesa.add(new Jogador("Tony", 65, 3.2, "Brasil", 23, PosicaoJogador.LATERAL, CaracteristicaJogador.DEFESA, gremio));
        gremio.setDefesa(jogadorGremioDefesa);
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
