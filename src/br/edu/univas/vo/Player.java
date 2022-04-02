package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe é usada para representar um jogador de dominó.
 *
 */


public class Player {

    /* Campos */
    private static int numOfPlayers = 0;  // contém o número total de jogadores jogando o jogo de dominó
    private String name; // nome do jogador
    private int id; // o número de identificação do jogador. ou seja, Jogador 1, Jogador 2, etc.
    List<Domino> hand;// O jogador tem uma mão de dominós.

    /**
     * Cria um novo jogador com um determinado nome.
     * <p>
     * O jogador receberá o próximo número de identificação disponível.
     * @param name o nome do jogador.
     */
    public Player(String name) {

        /* Aumenta o número de jogadores em um */
        numOfPlayers++;

        /* Inicializa os campos */
        this.name = name;
        this.id = numOfPlayers;

        /* O jogador começa com a mão vazia */
        this.hand = new ArrayList<Domino>();

    }

    /**
     * Obtém o número de jogadores atuais no jogo.
     * @return o número atual de jogadores no jogo.
     */
    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    /**
     * Retorna o nome do jogador.
     * @return o nome do jogador.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o ID do jogador.
     * @return o ID do jogador.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a lista de dominós na mão do jogador.
     * @return os dominós na mão deste jogador.
     */
    public List<Domino> getHand() {
        return this.hand;
    }

    /* ----- Os Métodos da Mão -*/

    /**
     * Obtém o número de dominós na mão de um jogador.
     * @return o número de dominós na mão do jogador
     */
    public int numOfDomInHand() {
        return hand.size();
    }

    /**
     * Determina se a mão de um jogador está vazia.
     * @return true se o jogador não tiver mais dominós na mão.
     */
    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    /**
     * Adiciona um dominó à mão do jogador.
     * @param domino o dominó a ser adicionado à mão do jogador.
     */
    public void addDomino(Domino domino) {
        this.hand.add(domino);
    }

    /**
     * Remove um dominó da mão do jogador. Ele retorna o dominó removido.
     * @param indexa a posição do índice do dominó na mão a ser retornada.
     * @return o dominó que é removido da mão.
     */
    public Domino removeDom(int index) {

        /* Pega o dominó a ser devolvido */
        Domino domino = hand.get(index);

        /* Retira da mão */
        hand.remove(index);

        /* Retorna o dominó */
        return domino;

    }

    /**
     * Determina se um jogador tem um dominó específico em sua mão.
     * @param domino o dominó a ser verificado.
     * @return true se o jogador tiver aquele dominó específico.
     */
    public boolean hasDominoInHand(Domino domino) {
        return hand.contains(domino);
    }

    /**
     * Determine se o jogador tem um dominó na mão que
     * pode ser jogado no tabuleiro.
     * @param o lado do dominó no tabuleiro a ser verificado.
     * @return true se o jogador tiver um dominó jogável.
     */
    public boolean hasPlay(int side) {

        for (Domino domInHand : hand) {

            /* o lado do dominó do tabuleiro (int) é igual ao lado do dominó da mão 1 ou lado 2 */
            if ((side == domInHand.getSide1()) || (side == domInHand.getSide2())) {
                return true;
            }

        }

       /* Checou a mão inteira, não havia correspondências */
        return false;

    }

    /**
     * Retorna o valor total de todos os dominós na mão do jogador.
     * @return o valor total de todos os dominós na mão do jogador.
     */
    public int valueOfHand() {

        int total = 0;

        /* Soma o valor de cada dominó na mão */
        for (Domino domino : hand) {
            total = total + domino.getTotalValue();
        }

        return total;

    }

    @Override
    public String toString() {
        return "Player #: " + getId() + "\n" +
                "Player name: " + getName() + "\n" +
                "Num of dominos in hand: " + numOfDomInHand();
    }


}

}
