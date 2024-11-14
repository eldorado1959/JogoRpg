

import java.util.Scanner;

public class Evento {
    private String descricao;
    private String opcao1;
    private String opcao2;
    private int riscoOpcao1;
    private int riscoOpcao2;

    public Evento(String descricao, String opcao1, String opcao2, int riscoOpcao1, int riscoOpcao2) {
        this.descricao = descricao;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.riscoOpcao1 = riscoOpcao1;
        this.riscoOpcao2 = riscoOpcao2;
    }

    public void iniciar(Personagem jogador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(descricao);
        System.out.println("1. " + opcao1);
        System.out.println("2. " + opcao2);

        int escolha = scanner.nextInt();
        if (escolha == 1) {
            executarEscolha(jogador, riscoOpcao1);
        } else if (escolha == 2) {
            executarEscolha(jogador, riscoOpcao2);
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            iniciar(jogador);
        }
    }

    private void executarEscolha(Personagem jogador, int risco) {
        if (risco > 0) {
            System.out.println("Você encontrou um inimigo e entrou em combate!");
            Personagem inimigo = new Guerreiro("Inimigo");
            while (jogador.estaVivo() && inimigo.estaVivo()) {
                jogador.atacar(inimigo);
                if (inimigo.estaVivo()) {
                    inimigo.atacar(jogador);
                }
            }
            if (jogador.estaVivo()) {
                System.out.println("Você venceu o combate!");
            } else {
                System.out.println("Você foi derrotado.");
            }
        } else {
            System.out.println("Você não encontrou inimigos, mas perdeu " + (-risco) + " de vida por um perigo.");
            jogador.receberDano(-risco);
            jogador.mostrarStatus();
        }
    }
}
