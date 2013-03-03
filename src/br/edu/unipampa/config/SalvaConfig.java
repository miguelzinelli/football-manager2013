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

    public void SalvaConfig() {
    }

    public void criarTimesJogadores() {
        clubes = new ArrayList<>();
        jogadoresAVendaAtaque = new ArrayList<>();
        jogadoresAVendaDefesa = new ArrayList<>();
        
        //cria times
        Clube gremio = new Clube("Grêmio", 50000, "Luxemburgo", null, null);
        Clube juventude = new Clube("Juventude", 50000, "Luxemburgo", null, null);
        Clube vereanopolis = new Clube("Vereanópolis", 50000, "Luxemburgo", null, null);
        Clube guaraniBage = new Clube("Guarani - Bagé", 50000, "Luxemburgo", null, null);
        Clube coloridos = new Clube("Internacional", 50000, "Luxemburgo", null, null);
        Clube caxias = new Clube("Caxias", 50000, "Luxemburgo", null, null);
        Clube saoLuizIjui = new Clube("São Luiz - Ijuí", 50000, "Luxemburgo", null, null);
        Clube passoFundo = new Clube("Passo Fundo", 50000, "Luxemburgo", null, null);

        //cria jogadores
        ArrayList<Jogador> jogadorGremioAtaque = new ArrayList<>();
        jogadorGremioAtaque.add(new Jogador("Vargas Él Matador", 99, 15000, "Argentino", 21, PosicaoJogador.ATACANTE, CaracteristicaJogador.ATAQUE, gremio));
        gremio.setAtaque(jogadorGremioAtaque);
        
        ArrayList<Jogador> jogadorGremioDefesa = new ArrayList<>();
        jogadorGremioDefesa.add(new Jogador("Werley", 70, 4000, "Brasil", 26, PosicaoJogador.ZAGUEIRO, CaracteristicaJogador.DEFESA, gremio));
        gremio.setDefesa(jogadorGremioDefesa);
        
        //add no arraylist do clubes
        this.clubes.add(gremio);
        this.clubes.add(juventude);
        this.clubes.add(vereanopolis);
        this.clubes.add(guaraniBage);
        this.clubes.add(coloridos);
        this.clubes.add(caxias);
        this.clubes.add(saoLuizIjui);
        this.clubes.add(passoFundo);
        
        //cria jogadores a venda
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
}
