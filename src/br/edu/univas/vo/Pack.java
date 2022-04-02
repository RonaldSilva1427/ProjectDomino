package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Uma classe usada para representar um pacote de dominós

public class Pack {


    /* Lista usada para guardar todos os dominós do pacote */
    private List<Domino> pack;
    private int originalSize; // o tamanho original do pacote.

    /**
     * Construtor padrão que cria um pacote com 28 dominós.
     * <p>
     * Observe que um pacote padrão começa com 0 | 0, e vai para 6 | 6.
     */
    public Pack() {

        /* Cria uma lista vazia para o pacote de dominó */
        pack = new ArrayList<Domino>();

        /* Loop 2-D que cria os 28 dominós */
        for (int i = 0; i <= 6; i++) {

            for (int k = i; k <= 6; k++) {
                Domino newDom = new Domino(i, k);
                pack.add(newDom);

            }

        }

        originalSize = pack.size();

    }


     //Cria um pacote com um número especificado de dominós.
     //Observe que um pacote padrão começa com 0 | 0, e vai para 6 | 6.
     //@param highCard um número inteiro que representa a carta mais alta do baralho.
     //Ou seja, um 9 significaria que o pacote começa em 0 | 0 e termina em 9 | 9.

    public Pack(int highestCard) {

        /* Cria uma lista vazia para o pacote de dominó */
        pack = new ArrayList<Domino>();

        /* Loop 2-D que cria os 28 dominós */
        for (int i = 0; i <= highestCard; i++) {
            for (int k = i; k <= highestCard; k++) {
                Domino newDom = new Domino(i, k);
                pack.add(newDom);

            }
        }

    }

    /**
     * Usado para obter todos os dominós que estão atualmente no pacote.
     *
     * @return a uma lista que contém todos os dominós que estão no pacote.
     */
    public List<Domino> getDominos() {
        return pack;
    }

    /**
     * Usado para embaralhar o pacote de dominós.
     */
    public void shuffle() {
        Collections.shuffle(pack);
    }

    /**
     * Retorna o número de dominós que estão atualmente no pacote.
     *
     * @return o tamanho atual do número de dominós no pacote.
     */
    public int packSize() {
        return pack.size();
    }

    /**
     * Retorna o número de dominós que estavam no pacote.
     *
     * @return o tamanho original do pacote de dominó.
     */
    public int orgPackSize() {
        return originalSize;
    }


    /**
     * Remove um determinado número de dominós do pacote e coloca-o
     * na mão de um jogador específico.
     *
     * @param player   o jogador para quem os dominós devem ser distribuídos.
     * @param numDealt o número de dominós a serem distribuídos.
     */
    public void dealHand(Player player, int numDealt) {

        for (int i = 0; i < numDealt; i++) {

            /* Pegue o primeiro dominó do pacote,
             * e coloque-o na mão do jogador indicado.*/
            player.addDomino(pack.remove(0));

        }

    }

    @Override
    public String toString() {
        return "Original Size: " + orgPackSize() + "\nCurrent Size: " + packSize();
    }


}

