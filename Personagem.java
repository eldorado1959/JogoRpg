

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void atacar(Personagem inimigo);

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void mostrarStatus() {
        System.out.println(nome + " - Vida: " + vida);
    }
}

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 100, 20);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(nome + " atacou " + inimigo.nome + " com um golpe pesado!");
        inimigo.receberDano(ataque);
    }
}

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 80, 15);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(nome + " disparou uma flecha em " + inimigo.nome + "!");
        inimigo.receberDano(ataque);
    }
}

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 60, 25);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(nome + " lançou uma bola de fogo em " + inimigo.nome + "!");
        inimigo.receberDano(ataque);
    }
}
