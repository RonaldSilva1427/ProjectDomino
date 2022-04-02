package br.edu.univas.vo;

import java.util.LinkedList;
import java.util.List;


public class Board {
    private List<Domino> dominos;  // O tabuleiro contém um conjunto de dominós
    private int topSide, botSide;  // O tabuleiro tem dois lados jogáveis

    /**
     * Cria um tabuleiro vazio.
     */
    public Board() {

        /* Faz uma lista vazia para guardar todos os dominós do tabuleiro */
        this.dominos = new LinkedList<Domino>();

    }

    /**
     * Obtém a lista de todos os dominós no tabuleiro.
     *
     * @return uma lista de todos os dominós no tabuleiro.
     */
    public List<Domino> getDominos() {
        return dominos;
    }

    /**
     * Retorna o número do lado jogável superior do tabuleiro.
     * <p>
     * Por exemplo, se a placa se parece com isso [6 | 6][5 | 4] o lado mais jogável
     * seria 6.
     * <p>
     * NB Um tabuleiro vazio retornará valores negativos para os lados superior e inferior.
     *
     * @return o número do lado superior.
     */
    public int getTopSide() {

        /* If the board isn't empty, return the value */
        if (!isEmpty()) {
            return topSide;
        } else {
            return -1;
        }
    }

    /**
     * Retorna o número do lado jogável do bot para o tabuleiro.
     * <p>
     * Por exemplo, se a placa se parece com isso [6 | 6][5 | 4] o lado jogável do bot
     * seria 4.
     * <p>
     * NB Um tabuleiro vazio retornará valores negativos para os lados superior e inferior.
     *
     * @return o número do lado do bot.
     */
    public int getBotSide() {

        /* If the board isn't empty, return the value */
        if (!isEmpty()) {
            return botSide;
        } else {
            return -1;
        }
    }

    /**
     * Determina se o tabuleiro está vazio ou não.
     *
     * @return true se o quadro estiver vazio.
     */
    public boolean isEmpty() {
        return this.dominos.isEmpty();

    }

    /**
     * Retorna o número de dominós atualmente no tabuleiro.
     *
     * @return o número de dominós atualmente no tabuleiro.
     */
    public int numDomBoard() {
        return dominos.size();
    }

    /**
     * Adicione um dominó ao topo do tabuleiro.
     * <p>
     * O usuário deste método deve especificar qual lado do dominó deve
     * ser conectado à placa.
     *
     * @param addDom o dominó a ser adicionado ao quadro.
     * @param side1  true se side1 do dominó adicionado for o lado
     *               que corresponde à placa.
     */
    public void addDominoTop(Domino addedDom, boolean side1) {

        /* Adiciona ao início da lista */
        dominos.add(0, addedDom);

        /* Se side1 for verdadeiro, isso significa que side1 é aquele que correspondeu,
         * portanto, lado2 se torna o próximo lado disponível no tabuleiro. */
        if (side1) {

            /* Tem que virar o dominó b/c você está adicionando side1 ao topo */
            addedDom.flipDom();
            topSide = addedDom.getSide2();
        } else {
            topSide = addedDom.getSide1();
        }

    }

    /**
     * Adicione um dominó ao bot do tabuleiro.
     * <p>
     * O usuário deste método deve especificar qual lado do dominó deve
     * ser conectado à placa.
     *
     * @param addDom o dominó a ser adicionado ao quadro.
     * @param side1  true se side1 do dominó adicionado for o lado
     *               que corresponde à placa.
     */
    public void addDominoBot(Domino addedDom, boolean side1) {

        /* Adiciona ao final da lista */
        dominos.add(addedDom);

        /* Se side1 for verdadeiro, isso significa que side1 é aquele que correspondeu,
         * portanto, lado2 se torna o próximo lado disponível no tabuleiro. */
        if (side1) {
            botSide = addedDom.getSide2();
        } else {

            /* Tem que virar o dominó b/c você está adicionando side2 ao bot */
            addedDom.flipDom();
            botSide = addedDom.getSide1();
        }

    }

    /**
     * Determina se um dominó específico está no tabuleiro.
     *
     * @param dom o dominó a ser verificado.
     * @return true se o dominó estiver no tabuleiro.
     */
    public boolean dominoOnBoard(Domino dom) {
        return dominos.contains(dom);
    }

    /**
     * Retorna o número de dominós no tabuleiro que correspondem a um tipo específico.
     * <p>
     * Por exemplo. Pode ser usado para determinar quantos '2's estão no tabuleiro.
     *
     * @param digite o número do dominó. Por exemplo. [5|4] é um dominó '4' ou um dominó '5'.
     * @return um inteiro que informa quantos dominós desse tipo estão no tabuleiro.
     */
    public int numOfType(int type) {

        /* Contador para acompanhar quantos dominós correspondem ao tipo */
        int numOfType = 0;

        /* Verifica todos os dominós do tabuleiro */
        for (Domino dom : dominos) {

            /* Se um dos lados do dominó no tabuleiro for igual
             * para o tipo e, em seguida, incremente o contador de tipos */
            if ((dom.getSide1() == type) || (dom.getSide2() == type)) {
                numOfType++;
            }

        }

        return numOfType;

    }

    /**
     * Imprime o quadro verticalmente em formato de texto.
     */
    public void printBoardVert() {

        /* Imprime todos os dominós no tabuleiro */
        for (Domino dom : dominos) {
            dom.printVertical();
        }

        System.out.println();
    }

    /**
     * Imprime o quadro horizontalmente em formato de texto.
     */
    public void printBoardHorz() {

        /* Imprime todos os dominós no tabuleiro */
        for (Domino dom : dominos) {
            dom.printHorizontal();
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "Num of dominos on the board " + numDomBoard() + "\nPlayable Top Side: " + topSide + "\nPlayable Bot Side: " + botSide;
    }


}


