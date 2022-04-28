package br.edu.univas.vo;

public class View {

    public void Start() {

        System.out.println("___________________________________________________");
        System.out.println("Dominó");
        System.out.println("___________________________________________________");

    }

    public void Playing() {

        System.out.println("\nSua vez **********************\n");
        System.out.println("Sua mão:");
        System.out.println("Digite o numéro da peça que deseja jogar ou 15 para passar a vez ou 20 para comprar uma Peça ");
        System.out.println("");
    }

    public void msgErro() {

        System.out.println("Numero de Peça inválida, digite um numero válido");

    }

    public void msgVezDoComputador() {
        System.out.println("Vez do Computador\n");
    }

    public void msgPecasJogadas() {
        System.out.println("Peças na mesa:\n ");

    }
    public void msgGanhou() {

        System.out.println("Você venceu!!!");
    }
    public void msgPerdeu() {
        System.out.println("Você perdeu");

    }

    public void msgComputadorPassouAVez() {

        System.out.println("Computador passou a vez *******************");

    }
    public void msgComputadorComprouPeca() {

        System.out.println("Computador comprou uma peça **********************\n");
    }

}
