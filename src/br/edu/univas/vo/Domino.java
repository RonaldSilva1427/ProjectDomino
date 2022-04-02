package br.edu.univas.vo;

//Uma classe usada para representar um único dominó.

public class Domino implements Comparable<Domino> {

    /* Campos usados ​​para representar os lados de um dominó.
     * Um dominó tem dois lados associados a ele. */
    private int side1, side2;
    private boolean flipped;

    /**
     * Construtor que faz um novo dominó "duplo em branco".
     * Ou seja, um dominó cujos dois lados são 0.
     */
    public Domino() {
        this.side1 = 0;
        this.side2 = 0;
        this.flipped = false;
    }

    /**
     * @param side1 o inteiro usado representa o 1º lado do dominó.
     * @param side2 o inteiro usado representa o 2º lado do dominó.
     */
    public Domino(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.flipped = false;
    }

    /* Getters para o Domino */

    /**
     * Get é o número associado ao 1º lado do dominó.
     *
     * @return o valor numérico do 1º lado do dominó.
     */
    public int getSide1() {
        return side1;
    }

    /**
     * Get é o número associado ao 2º lado do dominó.
     *
     * @return o valor numérico do 2º lado do dominó.
     */
    public int getSide2() {
        return side2;
    }

    /**
     * Determina se o dominó está/foi virado.
     *
     * @return true se o dominó for invertido.
     */
    public boolean isFlip() {
        return flipped;
    }

    /**
     * Inverte o estado do dominó.
     */
    public void flipDom() {

        /* Muda o estado de inversão do dominó */
        flipped = !flipped;
    }

    /**
     * Obtém o valor total do dominó.
     * <p>
     * O valor total de um dominó é a soma de ambos os lados.
     *
     * @return O valor total do dominó.
     */
    public int getTotalValue() {
        return side1 + side2;
    }

    /**
     * Determina se dois dominós têm o mesmo valor total.
     *
     * @param compDomino o dominó com o qual você deseja comparar.
     * @return true se os dois dominós tiverem o mesmo valor total.
     */
    public boolean isSameValue(Domino compDomino) {

        return this.getTotalValue() == compDomino.getTotalValue();

    }

    /**
     * Determina se o dominó é um dominó duplo.
     * <p>
     * Um dominó duplo é um dominó cujos dois lados têm o mesmo valor. Exemplo: 6 | 6.
     *
     * @return true se o dominó for um dominó duplo.
     */
    public boolean isDouble() {
        return side1 == side2;
    }

    /**
     * Imprime uma representação de texto vertical do dominó.
     *
     * @param true, se o dominó deve ser impresso invertido.
     */
    public void printVertical() {

        /* If not flipped */
        if (!flipped) {
            System.out.println("---");
            System.out.println(" " + side1);
            System.out.println(" -");
            System.out.println(" " + side2);
            System.out.println("---");
        }
        /* Print in the opposite way */
        else {
            System.out.println("---");
            System.out.println(" " + side2);
            System.out.println(" -");
            System.out.println(" " + side1);
            System.out.println("---");
        }


    }

    /**
     * Imprime uma representação de texto horizontal do dominó.
     *
     * @param true, se o dominó deve ser impresso invertido.
     */
    public void printHorizontal() {

        if (!flipped) {
            System.out.print("[" + side1 + " | " + side2 + "]");
        } else {
            System.out.print("[" + side2 + " | " + side1 + "]");
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Domino other = (Domino) obj;
        if (side1 != other.side1) return false;
        if (side2 != other.side2) return false;
        return true;
    }


    @Override
    public int compareTo(Domino compDom) {
        return this.getTotalValue() - compDom.getTotalValue();
    }

    @Override
    public String toString() {
        return "[" + side1 + " | " + side2 + "]";
    }


}
