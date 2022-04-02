package br.edu.univas.vo;

import br.edu.univas.main.InterfaceDados;
import java.util.ArrayList;
import java.util.List;

//Aula usada para jogar dominó.

public class Game {

    private int numOfPlayers; // Número de jogadores
    private int packType; // Máximo de dominó no pacote. ou seja, 6 | 6 ou 9 | 9. etc.
    private InterfaceDados iFace; // A ‘interface’ do jogo.
    private List<Player> playerList; // Lista dos jogadores no jogo

    /**
     * Faz um jogo com 0 jogadores, e não
     * pacote prescrito.
     * <p>
     * O cliente deve fornecer ao jogo um objeto IDomInterface,
     * para que o jogo seja feito.
     *
     * @param iFace A interface do jogo. ou seja, Interface de Texto, GUI, etc.
     */
    public Game(InterfaceDados iFace) {
        this.numOfPlayers = 0;
        this.packType = 0;
        this.iFace = iFace;
        this.playerList = new ArrayList<Player>();
    }

    /**
     * O método "principal" que joga/executa o jogo.
     */
    public void play() {

        /*Qual pacote de dominó deve ser criado? 6 ou 9?*/
        packType = iFace.packSize();

        /*Solicita o número de jogadores*/
        numOfPlayers = iFace.numPlayers();

        /* Loop para obter o nome de cada jogador */
        for (int i = 1; i <= numOfPlayers; i++) {

            String name = iFace.playerName(); // Peça o nome do jogador.
            playerList.add(new Player(name)); // Adiciona o jogador à lista.

        }

        /* Faz um novo tabuleiro vazio */
        Board newBoard = new Board();

        /* Faz um novo pacote, baseado no tipo que o usuário selecionou */
        Pack newPack = new Pack(packType);

        /* Embaralha o pacote */
        newPack.shuffle();

        /* Distribuir os dominós para cada jogador do jogo */
        for (Player player : playerList) {
            newPack.dealHand(player, 7); // distribui 7 dominós na mão do jogador.
            iFace.handDealt(player); // diz ao jogador que sua mão foi distribuída.
        }

    }

}