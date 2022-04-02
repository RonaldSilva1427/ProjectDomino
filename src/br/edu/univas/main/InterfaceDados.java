package br.edu.univas.main;

/**
 * Interface para o dominó usado para obter dados/mostrar dados para o usuário.
 * <p>
 * Qualquer interface para o jogo de dominó deve implementar essa interface.
 */

public class InterfaceDados {

    /**
     * Usado para obter o tamanho do pacote do usuário. ou seja, duplo 6 ou duplo 9.
     * @return o máximo de dominó no pacote.
     */
    public  int  packSize ();

    /**
     * Usado para obter o número de jogadores para o jogo.
     * @return o número de jogadores no jogo.
     */
    public  int  numPlayers ();

    /**
     * Usado para obter o nome do jogador.
     * @return a representação String do nome do jogador.
     */
    public  String  playerName ();

    /**
     * Diz aos jogadores que sua mão foi distribuída.
     */
    public  void  handDealt ( Jogador  jogador );
}