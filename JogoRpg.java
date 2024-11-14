

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o personagem (1: Guerreiro, 2: Arqueiro, 3: Mago): ");
        int escolha = scanner.nextInt();
        Personagem jogador = null;

        switch (escolha) {
            case 1:
                jogador = new Guerreiro("Guerreiro");
                break;
            case 2:
                jogador = new Arqueiro("Arqueiro");
                break;
            case 3:
                jogador = new Mago("Mago");
                break;
            default:
                System.out.println("Escolha inválida. Selecionando Guerreiro por padrão.");
                jogador = new Guerreiro("Guerreiro");
                break;
        }

        // Criação dos eventos
        Evento evento1 = new Evento(
            "Você chega a uma encruzilhada. Para a esquerda, um caminho escuro na floresta. Para a direita, uma trilha iluminada.",
            "Seguir pela floresta escura",
            "Seguir pela trilha iluminada",
            15, // risco: combate se escolher floresta
            -10 // risco: perde vida se escolher trilha
        );

        Evento evento2 = new Evento(
            "Você encontra uma caverna misteriosa. Deseja explorá-la?",
            "Entrar na caverna",
            "Seguir o caminho",
            20,  // risco: combate se entrar
            -5   // risco: perde um pouco de vida se ignorar
        );

        // Sequência de eventos
        System.out.println("Bem-vindo à aventura!");
        evento1.iniciar(jogador);
        if (jogador.estaVivo()) {
            evento2.iniciar(jogador);
        }

        if (jogador.estaVivo()) {
            System.out.println("Parabéns, você sobreviveu à aventura!");
        } else {
            System.out.println("Infelizmente, sua jornada termina aqui.");
        }

        scanner.close();
    }
}
