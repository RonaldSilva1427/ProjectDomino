package br.edu.univas.main;

import br.edu.univas.vo.Player;
import java.util.Scanner;

/**
 * Uma interface de texto que é usada para jogar um jogo de dominó.
 * Observe que ele implementa o IDomInterface.
 */

public class InterfaceTexto {

    private Scanner input; // Usado para obter entrada do usuário.

    /**
     * Construtor padrão
     */
    public TextInterface(){
        this.input = new Scanner(System.in);
    }

    @Override
    public int packSize() {
        /*Qual pacote de dominó deve ser criado? 6 ou 9?*/
        System.out.println("Qual pacote você gostaria? \"6\" ou \"9\"?");
        return input.nextInt();
    }

    @Override
    public int numPlayers() {
        System.out.println("Quantos jogadores hoje?");
        return input.nextInt();
    }

    @Override
    public String playerName() {
        System.out.println("Digite o nome do jogador.");
        return input.next();
    }

    @Override
    public void handDealt(Player player) {
        System.out.printf("A mão de %s foi distribuída.\n", player.getName());
    }

}



