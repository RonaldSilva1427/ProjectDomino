package br.edu.univas.vo;

/**
 * Esta classe serve como estrutura de teste para as classes
 * que são desenvolvidos neste projeto.
 * <p>
 * Cada método é responsável por realizar testes em uma classe específica desenvolvida.
 *
 */

public class Tester {

    public static void main(String[] args) {

    }

    /**
     * Este método é usado para testar a Classe Domino.
     * @ver Dominó
     */
    @SuppressWarnings("unused")
    private static void DominoClass() {

        System.out.println("-- Testing the Domino Class --");
        System.out.println();


        /* Faz os dominós para teste */
        Domino dom1 = new Domino(5, 5); // 5 | 5
        Domino dom2 = new Domino(6, 4); // 6 | 4
        Domino dom3 = new Domino(); // double blank
        Domino dom4 = new Domino(5, 5); // 5 | 5

        /* Imprime os dominós */
        System.out.println("This domino is " + dom1);
        System.out.println("This domino is " + dom2);
        System.out.println("This domino is " + dom3);

        /* Testa o método printVertical() */
        dom1.printVertical();
        dom2.printVertical();
        dom3.printVertical();

        /* Obtém os valores totais */
        System.out.println();
        System.out.println("The total value for " + dom1 + " is " + dom1.getTotalValue());
        System.out.println("The total value for " + dom2 + " is " + dom2.getTotalValue());
        System.out.println("The total value for " + dom3 + " is " + dom3.getTotalValue());

        /* Testa o método isDouble() */
        System.out.println();
        System.out.println(dom1 + " is a double domino " + dom1.isDouble());
        System.out.println(dom2 + " is a double domino " + dom2.isDouble());
        System.out.println(dom3 + " is a double domino " + dom3.isDouble());

        /* Testa o método isSameValue() */
        System.out.println();
        System.out.println(dom1 + " and " + dom2 + " have the same total value " + dom1.isSameValue(dom2)); // true
        System.out.println(dom1 + " and " + dom3 + " have the same total value " + dom1.isSameValue(dom3)); // false

        /* Testa o método equals() */
        System.out.println();
        System.out.println("Are " + dom1 + " and " + dom1 + " are the same? " + dom1.equals(dom1)); // true
        System.out.println("Are " + dom1 + " and " + dom2 + " are the same? " + dom1.equals(dom2)); // false
        System.out.println("Are " + dom1 + " and " + dom4 + " are the same? " + dom1.equals(dom4)); // true

    }

    /**
     * Este método é usado para testar a Classe do Jogador.
     * @ver Jogador
     */
    @SuppressWarnings("unused")
    private static void PlayerClass() {
        System.out.println("-- Testing the Player Class --");
        System.out.println();

        /* Faz os jogadores para teste */
        Player richie = new Player("Richie");
        Player dwayne = new Player("Dwayne");

        /* Deve ser 2 jogadores agora */
        System.out.println("There are " + Player.getNumOfPlayers() + " players");

        System.out.println();
        /* Imprime informações dos jogadores */
        System.out.println(richie + "\n");
        System.out.println(dwayne);

        /* As mãos devem estar vazias */
        System.out.println();
        System.out.println("Is " + richie.getName() + " hand empty? " + richie.isHandEmpty()); // should be false;

        /* Faz os dominós para teste */
        Domino dom1 = new Domino(5, 5); // 5 | 5
        Domino dom2 = new Domino(6, 4); // 6 | 4
        Domino dom3 = new Domino(); // double blank
        Domino dom4 = new Domino(1, 0); // 1 | 0

        /* Pronto */
        System.out.println("Adding dominos to the players hand...");

        /* Adiciona dominó à mão do Richie */
        richie.addDomino(dom1);
        richie.addDomino(dom2);

        /* Adiciona dominó à mão de Dwayne */
        dwayne.addDomino(dom1);
        dwayne.addDomino(dom3);
        dwayne.addDomino(dom4);

        /* Imprime as mãos */
        System.out.println();
        System.out.println(richie.getName() + "'s hand:\n");
        for (Domino dom : richie.getHand()) {
            System.out.println(dom);
        }

        System.out.println();
        System.out.println(dwayne.getName() + "'s hand:\n");
        for (Domino dom : dwayne.getHand()) {
            System.out.println(dom);
        }

        /* Dwayne deveria ter 3 dominós na mão */
        System.out.println();
        System.out.println("Is " + dwayne.getName() + " hand empty? " + dwayne.isHandEmpty()); // should be false;

        /* O número de dominós em cada mão */
        System.out.println();
        System.out.println(richie.getName() + " has " + richie.numOfDomInHand() + " in their hand."); // should be 2
        System.out.println(dwayne.getName() + " has " + dwayne.numOfDomInHand() + " in their hand."); // should be 3

        /* Testa o método hasPlay() */
        System.out.println();
        System.out.println(richie.getName() + " can play a matching domino with a side of " + dom1.getSide1() + "? " + richie.hasPlay(dom1.getSide1())); // should be true
        System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom2.getSide1() + "? " + dwayne.hasPlay(dom2.getSide1())); // should be false
        System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom3.getSide1() + "? " + dwayne.hasPlay(dom3.getSide1())); // should be true

        /* Verifica o método hasDomino() */
        System.out.println();
        System.out.println(dwayne.getName() + " has " + dom3 + " in his hand? " + dwayne.hasDominoInHand(dom3)); // should be true
        System.out.println(richie.getName() + " has " + dom3 + " in his hand? " + richie.hasDominoInHand(dom3)); // should be false

        /* O valor das mãos */
        System.out.println();
        System.out.println(richie.getName() + " counts " + richie.valueOfHand()); // should be 20
        System.out.println(dwayne.getName() + " counts " + dwayne.valueOfHand()); // should be 11

        /* Remove o double blank da mão de Dwayne */
        System.out.println("\nRemoving " + dom3 + " from " + dwayne.getName() + " hand.");
        dwayne.removeDom(1);

        /* Reimprimir a mão atualizada de Dwayne */
        System.out.println();
        System.out.println(dwayne.getName() + "'s hand:\n");
        for (Domino dom : dwayne.getHand()) {
            System.out.println(dom);
        }

    }

    /**
     * Testador para a classe Pack
     * @ver Pacote
     */
    @SuppressWarnings("unused")
    private static void PackClass() {

        System.out.println("--- Testing the domino pack class ---");

        /* Cria um novo pacote de teste com 28 dominós */
        System.out.println("\nMaking a pack with 28 dominos.");
        Pack testPack = new Pack();
        System.out.println(testPack);

        System.out.println("\nPrinting the pack.");

        /* Faz um iterador para os dominós do pacote */
        Iterator<Domino> domIter = testPack.getDominos().iterator();

        /* Pega o próximo dominó, que é o 1º dominó, do pacote */
        Domino nextDom = domIter.next();

        /* Qual é o número do lado atual do dominó? */
        int currentSide = nextDom.getSide1();

        /* Imprime o 1º dominó */
        System.out.print(nextDom + "\t");

        /* Enquanto o pacote ainda tem dominós nele */
        while (domIter.hasNext()) {

            /* O próximo dominó do pacote */
            nextDom = domIter.next();
            int nextDomSide = nextDom.getSide1();

            /* Se o lado do dominó seguinte for diferente do lado atual
             * imprime uma nova linha */
            if (nextDomSide != currentSide) {
                System.out.println();

                /* Torna o lado atual (a ser verificado)
                 * o mesmo que o lado do dominó ao lado */
                currentSide = nextDomSide;

            }

            /* Imprime o dominó */
            System.out.print(nextDom + "\t");

        }

        /* Embaralhando o pacote */
        System.out.println("\n\nShuffling...");
        testPack.shuffle();

        /* Usado para registrar quantos dominós foram impressos na linha */
        int printCount = 0;

        /* Imprime o novo pacote embaralhado */
        for (Domino dom : testPack.getDominos()) {

            /* Imprime o dominó */
            System.out.print(dom + "\t");
            printCount++;

            /* Faz uma nova linha após 7 dominós serem impressos */
            if (printCount > 6) {
                System.out.println();
                printCount = 0;
            }

        }

        /* Faz um pacote com 9 | 9 */
        Pack testPack2 = new Pack(9);

        System.out.println("\nPrinting the 9 | 9 pack.");

        /* Faz um iterador para os dominós do pacote */
        domIter = testPack2.getDominos().iterator();

        /* Pega o próximo dominó, que é o 1º dominó, do pacote */
        nextDom = domIter.next();

        /* Qual é o número do lado atual do dominó? */
        currentSide = nextDom.getSide1();

        /* Imprime o 1º dominó */
        System.out.print(nextDom + "\t");

        /* Enquanto o pacote ainda tem dominós nele */
        while (domIter.hasNext()) {

            /* O próximo dominó do pacote */
            nextDom = domIter.next();
            int nextDomSide = nextDom.getSide1();

            /* Se o lado do dominó seguinte for diferente do lado atual
             * imprime uma nova linha */
            if (nextDomSide != currentSide) {
                System.out.println();

                /* Torna o lado atual (a ser verificado)
                 * o mesmo que o lado do dominó ao lado */
                currentSide = nextDomSide;

            }

            /* Imprime o dominó */
            System.out.print(nextDom + "\t");

        }

        /* -- Testando o método dealHand() -- */

        /* Cria um jogador */
        Player richie = new Player("Richie");
        Player dwayne = new Player("Dwayne");

        /* Imprime o pacote atual antes de distribuir */
        System.out.println("\n\nReprinting the 6 | 6 pack.");

        /* Usado para registrar quantos dominós foram impressos na linha */
        printCount = 0;

        /* Imprime o pacote embaralhado */
        for (Domino dom : testPack.getDominos()) {

            /* Imprime o dominó */
            System.out.print(dom + "\t");
            printCount++;

            /* Faz uma nova linha após 7 dominós serem impressos */
            if (printCount > 6) {
                System.out.println();
                printCount = 0;
            }

        }

        /* Imprime a mão de Richie */
        System.out.println("\nDealing from the pack into " + richie.getName() + "'s hand.");
        testPack.dealHand(richie, 7);

        System.out.println("\nDealt...");
        for (Domino dom : richie.getHand()) {
            System.out.print(dom + "\t");
        }

        /* Imprime a mão de Dwayne */
        System.out.println("\n\nDealing from the pack into " + dwayne.getName() + "'s hand.");
        testPack.dealHand(dwayne, 5);

        System.out.println("\nDealt...");
        for (Domino dom : dwayne.getHand()) {
            System.out.print(dom + "\t");
        }

        /* Imprimir Pacote Modificado */
        System.out.println("\n\nReprinting the modified pack.");

        /* Usado para registrar quantos dominós foram impressos na linha */
        printCount = 0;

        /* Imprime o novo pacote embaralhado */
        for (Domino dom : testPack.getDominos()) {

            /* Imprime o dominó */
            System.out.print(dom + "\t");
            printCount++;

            /* Faz uma nova linha após 7 dominós serem impressos */
            if (printCount > 6) {
                System.out.println();
                printCount = 0;
            }

        }

        System.out.println("\n\n" + testPack);

    }

    /**
     * Testador para a classe Board
     */
    @SuppressWarnings("unused")
    private static void BoardClass() {

        System.out.println("-- Testing the Board Class --\n");

        /* Cria um objeto de tabuleiro */
        Board testBoard = new Board();

        System.out.println("Is the board empty? " + testBoard.isEmpty());

        /* Faz dominó para adicionar ao tabuleiro */
        Domino dom1 = new Domino(5, 5); // 5 | 5
        Domino dom2 = new Domino(6, 4); // 6 | 4
        Domino dom3 = new Domino(6, 5); // 6 | 5
        Domino dom4 = new Domino(6, 6); // duplo 6
        Domino dom5 = new Domino(); // em branco duplo

        /* Adiciona os dominós ao tabuleiro */
        System.out.println("\nAdding dominos to the board...");
        testBoard.addDominoTop(dom4, true); // [6 | 6]
        testBoard.addDominoTop(dom2, true); // [4 | 6][6 | 6]
        testBoard.addDominoBot(dom3, true); // [4 | 6][6 | 6][6 | 5]
        testBoard.addDominoBot(dom1, true); // [4 | 6][6 | 6][6 | 5][5 | 5]

        /* Imprime informações sobre a placa */
        System.out.println("\n" + testBoard);

        System.out.println("\nPrinting the board...");
        /* Imprime o quadro */
        System.out.println();
        testBoard.printBoardHorz();
        System.out.println();
        testBoard.printBoardVert();

        /* Verifica os lados disponíveis do tabuleiro */
        System.out.println("The playable top side is " + testBoard.getTopSide()); // Should be 6
        System.out.println("The playable bot side is " + testBoard.getBotSide()); // Should be 5

        /* Teste domOnBoardMethod() está na placa */
        System.out.println();
        System.out.println(dom4 + " is on the board? " + testBoard.dominoOnBoard(dom4)); // should be true
        System.out.println(dom5 + " is on the board? " + testBoard.dominoOnBoard(dom5)); // should be true

        /* Testa o método numOfType() */
        System.out.println();
        System.out.println("Number of 6s on the board: " + testBoard.numOfType(6));
        System.out.println("Number of 5s on the board: " + testBoard.numOfType(5));
        System.out.println("Number of 0s on the board: " + testBoard.numOfType(0));
    }

}

}
