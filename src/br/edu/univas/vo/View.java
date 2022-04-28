package br.edu.univas.vo;
public class View {

    public void Start() {

        System.out.println("___________________________________________________");
        System.out.println("                    Domino                         ");
        System.out.println("___________________________________________________");

    }

    public void Playing() {

        System.out.println("\n********** Sua vez **********\n");
        System.out.println("               Sua mao:                   ");
        System.out.println("Digite o numero da pecas que deseja jogar!");
        System.out.println ("15 para passar a vez!");
        System.out.println ("20 para comprar uma peca!");
        System.out.println("");
    }

    public void msgErro() {

        System.out.println("Numero de Peca invalida, digite um numero valido");

    }

    public void msgVezDoComputador() {
        System.out.println("Vez do Computador\n");
    }

    public void msgPecasJogadas() {
        System.out.println("Pecas na mesa:\n ");

    }
    public void msgGanhou() {

        System.out.println("********** Voce venceu!!! **********");
    }
    public void msgPerdeu() {
        System.out.println("********** Voce perdeu **********");

    }

    public void msgComputadorPassouAVez() {

        System.out.println("********** Computador passou a vez! **********");

    }
    public void msgComputadorComprouPeca() {

        System.out.println("********** Computador comprou uma peca! **********");
    }

}
