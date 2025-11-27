import java.util.*;

public class Main {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) { System.out.println("Erro ao limpar tela"); }
    }

    public static void printSlow(String frase, String cor, int tempo) {
        for (char c : frase.toCharArray()) {
            System.out.print(cor + c + RESET);
            System.out.flush();
            try { Thread.sleep(tempo); } catch (InterruptedException e) {}
        }
        System.out.println();
    }

    public static String barraHP(int atual, int max) {
        int total = 20;
        int cheio = (int) ((double) atual / max * total);
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < total; i++)
            barra.append(i < cheio ? "█" : "-");
        barra.append("] ").append(atual).append("/").append(max);
        return barra.toString();
    }

    static class Player {
        String classe;
        int vida;
        int vidaMax;
        int potions;
        String[] ataques;

        public Player(String classe) {
            this.classe = classe;
            switch (classe) {
                case "Guerreiro" -> {
                    vida = 130;
                    vidaMax = 130;
                    ataques = new String[] {"Corte Brutal", "Investida Selvagem", "Esmagamento de Escudo"};
                }
                case "Mago" -> {
                    vida = 105;
                    vidaMax = 105;
                    ataques = new String[] {"Raio Arcano", "Explosão de Gelo", "Chama Etérea"};
                }
                case "Arqueiro" -> {
                    vida = 115;
                    vidaMax = 115;
                    ataques = new String[] {"Flecha Precisa", "Tiro Triplo", "Disparo Fantasma"};
                }
                default -> {
                    vida = 100;
                    vidaMax = 100;
                    ataques = new String[] {"Ataque Básico"};
                }
            }
            this.potions = 2;
        }

        int atacar() {
            return switch (classe) {
                case "Guerreiro" -> 20 + (new Random().nextInt(8) - 3);
                case "Mago" -> 17 + (new Random().nextInt(8) - 4);
                case "Arqueiro" -> 15 + (new Random().nextInt(7) - 2);
                default -> 10;
            };
        }

        public String listarAtaques() {
            StringBuilder sb = new StringBuilder("Escolha um ataque:\n");
            for (int i = 0; i < ataques.length; i++)
                sb.append("[").append(i + 1).append("] ").append(ataques[i]).append("\n");
            return sb.toString();
        }

        public String getAtaqueNome(int escolha) {
            if (escolha < 1 || escolha > ataques.length) return "Ataque desconhecido";
            return ataques[escolha - 1];
        }

        public boolean usarPocao() {
            if (potions > 0) {
                int cura = 32;
                vida += cura;
                if (vida > vidaMax) vida = vidaMax;
                potions--;
                printSlow("Você usa uma poção e restaura " + cura + " HP! Restam " + potions + " poções.", GREEN, 15);
                return true;
            } else {
                printSlow("Você não possui mais poções!", RED, 15);
                return false;
            }
        }
    }

    static abstract class Boss {
        String nome;
        int vida, ataque, vidaMax;

        public Boss(String nome, int vida, int ataque) {
            this.nome = nome; this.vida = vida; this.vidaMax = vida; this.ataque = ataque;
        }
        abstract String frase();
        abstract String ataqueNomeado();
        boolean estaVivo() { return vida > 0; }
        void receberDano(int dano) {
            vida -= dano; if (vida < 0) vida = 0;
            printSlow(nome + " recebeu " + dano + " de dano!", RED, 20);
        }
        int atacar() { return ataque; }
    }

    public static class Dracula extends Boss {
        public Dracula() { super("Drácula", 170, 20); }
        public String frase() {
            String[] frases = {
                    "Eu sinto o cheiro da sua culpa… pesada, podre.",
                    "Você caminha como quem carrega os pecados que tentou esconder.",
                    "Se busca redenção, por que seus olhos ainda sangram vergonha?",
                    "Seus passos ecoam o nome daquela que você abandonou.",
                    "Nem suas preces acreditam em você… por que eu acreditaria?",
                    "A escuridão te conhece melhor do que você mesmo, humano.",
                    "Ah… esse olhar. Tão frágil, tão quebrado. Delicioso.",
                    "Venha. Mostre-me se consegue enfrentar aquilo que você teme ser."
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Drácula usa Mordida Vampírica!",
                    "Drácula invoca Névoa Sangrenta!",
                    "Drácula libera Asas das Sombras!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static class Vecna extends Boss {
        public Vecna() { super("Vecna", 175, 22); }
        public String frase() {
            String[] frases = {
                    "A solidão… ela sussurra mais alto que qualquer grito. Você também a ouve, não ouve?",
                    "Quando a última luz se apaga, é o vazio quem vem fazer companhia. Eu aprendi a aceitá-lo.",
                    "Você teme a minha presença, mas eu temo apenas uma coisa: o silêncio que resta quando todos se vão.",
                    "Não é a morte que assusta… é continuar vivo quando não há mais ninguém para lembrar seu nome.",
                    "Cada mente que toco é uma fuga breve da eternidade solitária que me espera.",
                    "Eu observo vocês se agarrando uns aos outros… como invejo essa fraqueza que vocês chamam de laço.",
                    "No fim, todos caem. E quando caem… caem sozinhos. Foi assim que eu nasci, assim que eu existo.",
                    "Venha. Junte-se a mim. Não porque eu preciso de você… mas porque estou cansado de caminhar sozinho na escuridão."
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Vecna usa Feitiço das Caveiras!",
                    "Vecna lança Correntes do Abismo!",
                    "Vecna conjura Olho Profano!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static class Hydra extends Boss {
        public Hydra() { super("Hydra", 180, 21); }
        public String frase() {
            String[] frases = {
                    "Seu arrependimento fede a amor estragado… e eu odeio cada gota desse sentimento inútil.",
                    "Você ainda ama quem te quebrou? Patético. O amor só existe para esmagar quem o carrega.",
                    "Cada cabeça minha sabe: o amor é uma mentira que vocês humanos contam para justificar a dor.",
                    "Você chora pela perda? Eu rio. Nada é tão desprezível quanto alguém que ama aquilo que o destruiu.",
                    "Seu coração tenta se agarrar ao passado… mas eu devorarei qualquer resquício desse amor covarde.",
                    "O amor te trouxe aqui — fraco, arrependido, partido. O ódio é a única verdade que resta.",
                    "Você busca redenção no mesmo sentimento que te apunhalou. Eu rasgarei isso de você.",
                    "Amor… arrependimento… tudo a mesma podridão. Deixe-me arrancar isso do seu peito de uma vez."
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Hydra usa Jato de Ácido!",
                    "Hydra ataca com Mordida Tripla!",
                    "Hydra libera Grito das Mil Cabeças!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static class Anubis extends Boss {
        public Anubis() { super("Anúbis", 180, 21); }
        public String frase() {
            String[] frases = {
                    "Eu vejo cada sombra que você tentou esconder… todas caminham atrás de você, esperando o julgamento que teme encarar.",
                    "Sua alma treme, não por mim, mas pelo que construiu com suas próprias escolhas… nada pesa mais que a verdade.",
                    "Você fala em redenção, mas seu coração conhece o preço do que fez — e sabe que não poderá pagá-lo em vida.",
                    "Há pecados que o tempo tenta apagar… mas o além os guarda como cicatrizes eternas.",
                    "Não é a morte que o assusta, é o espelho que ela carrega… onde sua culpa surge sem máscara.",
                    "Os deuses não punem com fogo, mas com memória… e a sua já está queimando sozinha.",
                    "Você teme meu veredito, mas a realidade é simples: foi sua própria alma quem lhe condenou primeiro.",
                    "No fim, não sou eu quem julga… apenas abro a porta. É você quem caminha até o peso que sempre evitou."
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Anúbis usa Julgamento das Areias!",
                    "Anúbis invoca Lâminas do Deserto!",
                    "Anúbis desperta o Olho Dourado!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static class Onryo extends Boss {
        public Onryo() { super("Onryo", 180, 22); }
        public String frase() {
            String[] frases = {
                    "Eu achei que você tinha mudado… mas você sempre volta ao mesmo ponto, não é?",
                    "Por que você treme? É só a repetição do que você mesmo criou.",
                    "Eu sou o reflexo de todas as promessas que você quebrou… uma por uma.",
                    "Você me escuta porque sabe que, no fundo, ainda tem medo de amar igual da última vez.",
                    "Toda vez que você tenta esquecer, eu volto — porque você ainda é o mesmo.",
                    "Eu sussurro exatamente como ela… porque você nunca deixou minha voz morrer.",
                    "Seus passos repetem o passado, e seu coração repete a dor. Sempre o mesmo ciclo.",
                    "Eu sou o erro que você jurou não cometer de novo… mas você já está repetindo."
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Onryo usa Lamento Amaldiçoado!",
                    "Onryo aparece atrás de você com Passo Sombrio!",
                    "Onryo libera Toque Contaminado!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static class Lucifer extends Boss {
        public Lucifer() { super("Lúcifer", 200, 26); }
        public String frase() {
            String[] frases = {
                    "“Vamos acabar com a farsa… você nunca a amou. Você só gostava do reflexo bonito que ela fazia de você.”",
                    "“Sabe o que dói? Nem eu, o próprio Lúcifer, seria capaz de usar alguém como você fez com ela.”",
                    "“Você chamava aquilo de amor, mas no fundo só queria alguém para apanhar os pedaços da sua alma quebrada.”",
                    "“Admita… quando ela começou a ver quem você realmente era, você desejou que ela simplesmente sumisse.”",
                    "“Não tenta negar. Em noites silenciosas, você queria que ela morresse só para se livrar do peso da culpa.”",
                    "“O mais irônico? Ela acreditou em tudo que você fingiu sentir. Você manipulou até o último suspiro de esperança dela.”",
                    "“Você não perdeu um amor. Você perdeu um espelho que ainda te fazia acreditar que havia algo de bom em você.”",
                    "“E agora chora arrependimento? Não seja ridículo. O único monstro naquela história… sempre foi você.”"
            };
            return frases[new Random().nextInt(frases.length)];
        }
        public String ataqueNomeado() {
            String[] ataques = {
                    "Lúcifer lança Chama Profana!",
                    "Lúcifer invoca as Asas Ardentes!",
                    "Lúcifer usa Golpe do Orgulho!"
            };
            return ataques[new Random().nextInt(ataques.length)];
        }
    }

    public static Player escolherClasse(Scanner sc) {
        clearScreen();
        System.out.println("""
            Escolha sua classe:

            [1] Guerreiro – Forte e resistente
            [2] Mago – Ataques místicos
            [3] Arqueiro – Rápido e preciso
        """);
        int op;
        do {
            System.out.print("> ");
            while(!sc.hasNextInt()) { sc.next(); System.out.print("> "); }
            op = sc.nextInt();
        } while (op < 1 || op > 3);

        return switch (op) {
            case 1 -> new Player("Guerreiro");
            case 2 -> new Player("Mago");
            case 3 -> new Player("Arqueiro");
            default -> new Player("Guerreiro");
        };
    }

    public static boolean Fight(Player p, Boss boss, Scanner sc) {
        p.vidaMax = p.vidaMax > 0 ? p.vidaMax : p.vida;
        while (p.vida > 0 && boss.estaVivo()) {
            clearScreen();
            System.out.println("\n+---------------- BATALHA ----------------+");
            System.out.println("Você (" + p.classe + ")");
            System.out.println("HP: " + barraHP(p.vida, p.vidaMax) + " | Poções: " + p.potions);
            System.out.println();
            System.out.println(boss.nome);
            System.out.println("HP: " + barraHP(boss.vida, boss.vidaMax));
            System.out.println("------------------------------------------");
            System.out.println("""
[1] Atacar
[2] Defender
[3] Fugir
[4] Usar Poção
""");
            System.out.print("> ");
            int acao = 0;
            while (acao < 1 || acao > 4) {
                while (!sc.hasNextInt()) { sc.next(); System.out.print("> "); }
                acao = sc.nextInt();
                if (acao < 1 || acao > 4) System.out.print("> ");
            }

            // ----- TURNO DO JOGADOR -----
            if (acao == 1) {
                System.out.print(p.listarAtaques());
                System.out.print("> ");
                int escolha = 1;
                while (true) {
                    while (!sc.hasNextInt()) { sc.next(); System.out.print("> "); }
                    escolha = sc.nextInt();
                    if (escolha >= 1 && escolha <= p.ataques.length) break;
                    System.out.print("> ");
                }
                String nomeDoAtaque = p.getAtaqueNome(escolha);
                printSlow("Você usa: " + nomeDoAtaque + "!", BLUE, 15);
                int dano = p.atacar();
                boss.receberDano(dano);
                pause(1200);

                Random randola=new Random();
                int crt =randola.nextInt(3);
                if ( crt ==2) {
                    int Dano= p.atacar() *2;
                    printSlow("Acerto Critico!", GREEN, 15);
                    boss.receberDano(dano);
                    pause(1500);
                }

                else{
                    int Dano=p.atacar();
                    boss.receberDano(dano);
                    pause(1500);
                }


            } else if (acao == 2) {
                printSlow("Você se defende e reduz o dano!", BLUE, 15);
                pause(1200);
            } else if (acao == 3) {
                printSlow("Você não pode fugir dos seus pecados!", RED, 15);
                pause(1000);
                continue;
            } else if (acao == 4) {
                if (!p.usarPocao()) {
                    pause(1100);
                }
                continue;
            }


            if (!boss.estaVivo()) break;

            // ------- TURNO DO CHEFE --------
            printSlow("TURNO DE " + boss.nome + "!", RED, 15);
            printSlow(boss.frase(), BLUE, 40);
            printSlow(boss.ataqueNomeado(), GREEN, 15);

            int danoBoss = boss.atacar() + (new Random().nextInt(4)-2);
            if (acao == 2) danoBoss = (danoBoss+1)/2;

            p.vida -= danoBoss;
            if (p.vida < 0) p.vida = 0;

            printSlow("Você recebeu " + danoBoss + " de dano!", RED, 15);
            pause(1000);


            if (new Random().nextDouble() < 0.11 && p.potions < 4) {
                p.potions++;
                printSlow("Você encontra uma poção caída após o turno! (+1 Poção)", GREEN, 15);
                pause(900);
            }
        }
        clearScreen();
        if (p.vida <= 0) {
            System.out.println(RED + "Você morreu!" + RESET);
            return false;
        } else {
            System.out.println(GREEN + "Você derrotou " + boss.nome + "!" + RESET);
            return true;
        }
    }

    public static void pause(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    static ArrayList<String> memorias = new ArrayList<>();
    static void inicializarMemorias() {
        memorias.clear();
        memorias.add("Um fragmento mostrando você criança correndo por um campo ensolarado. Você vê uma figura segurando sua mão — mas o rosto está borrado. VOCÊ NASCEU PRA ACABAR COM TODA A COVARDIA DO MUNDO!");
        memorias.add("Você lutou com o Rei Demônio antes de estar aqui, mas você perdeu. Ele disse: “Você nunca foi capaz de proteger quem ama de verdade”.");
        memorias.add("Você lembra que a mulher que você sempre amou selou sua alma com a própria vida dentro dessa masmorra, para salvar esse país sujo. ACABE COM O REI DEMÔNIO!");
        memorias.add("Uma mulher de voz suave te disse antes da batalha final: “Manoel… não esqueça quem você realmente é”. Ela era a mulher que você jurou proteger...");
        memorias.add("Você percebe o quanto confiou em quem o traiu. Seu melhor amigo vendeu sua alma e a de seus companheiros por riqueza. VINGUE TODOS E FAÇA-OS PAGAR!");
        memorias.add("Você está no castelo do Drácula, lutando, quando sente uma lâmina fria atravessando suas costas. Não foi o Drácula. Foi seu melhor amigo.");
        memorias.add("O vazio em seu peito se fecha. A dor da traição se tornou a força que Lúcifer nunca previu. Você não é mais apenas Manoel, mas a Vingança manifesta.");
    }
    static void revelarMemoria() {
        if (memorias.isEmpty()) {
            System.out.println("\n(Não há mais fragmentos de memória para recuperar...)");
            return;
        }
        String mem = memorias.remove(0);
        System.out.println(BLUE + "\n>>> FRAGMENTO DE MEMÓRIA REVELADO <<<\n" + RESET + mem);
        pause(7000);
    }

    public static void iniciarCampanha(Scanner sc, Player player) {
        inicializarMemorias();
        Boss[] chefes = new Boss[]{
                new Dracula(), new Vecna(), new Hydra(), new Anubis(), new Onryo(), new Lucifer()
        };
        System.out.println("As criaturas desse mundo sempre viveram isoladas dos seres humanos, até que um dia nasceu o Rei Demônio.");
        System.out.println("Com seu poder e liderança, uniu todos os monstros do mundo. Uma grande guerra começou.");
        System.out.println("\nPressione Enter para começar a história...");
        sc.nextLine();
        clearScreen();
        System.out.println("------------------------------------");
        System.out.println("       CAPÍTULO 1 — O DESPERTAR");
        System.out.println("------------------------------------\n");
        printSlow("Você desperta na masmorra. Seu nome é Manoel. Lembre-se do que lhe foi tirado.", BLUE, 25);
        pause(1500);

        for (int i = 0; i < chefes.length; i++) {
            clearScreen();
            System.out.println("\n>>> CAPÍTULO " + (i + 2) + " <<<\n");
            Boss boss = chefes[i];
            printSlow("Bioma: " + switch(i) {
                case 0 -> "Castelo da Noite Eterna";
                case 1 -> "Cidadela dos Pesadelos";
                case 2 -> "Mares Maléficos de Lerna";
                case 3 -> "Templo das Areias Esquecidas";
                case 4 -> "Vale das Lamentações Silenciosas";
                case 5 -> "Trono de Obsidiana no Inferno";
                default -> "???";
            }, GREEN, 20);
            printSlow("Um inimigo emerge... " + boss.nome + "!", BLUE, 15);
            printSlow(boss.frase(), BLUE, 45);
            if (i == 0 || i == 1 || i == 4 || i == 5)
                revelarMemoria();
            boolean vivo = Fight(player, boss, sc);
            if (!vivo) {
                System.out.println(RED + "O mal triunfou! O fragmento de memória desaparece..." + RESET);
                break;
            } else {
                printSlow("Após derrotar " + boss.nome + ", seu poder aumenta!", GREEN, 20);
                player.vida += 13 + i * 2;
                player.vidaMax += 9 + i;
                if (player.vida > player.vidaMax) player.vida = player.vidaMax;
            }
        }
        if (player.vida > 0) {
            System.out.println(GREEN + "\n--- Você venceu o Rei Demônio! ---\n" + RESET);
            printSlow("Verdadeiro final: Você não é só Manoel, mas a Vingança manifesta. O ciclo se fecha!", GREEN, 30);
            System.out.println("\nO vazio em seu peito se fecha. Você se torna lenda na masmorra.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("===== RPG - O Caminho da Vingança =====\n");
        Player player = escolherClasse(sc);
        clearScreen();
        printSlow("Sua jornada começa agora, " + player.classe + "!", GREEN, 25);
        iniciarCampanha(sc, player);
        System.out.println("\nFIM DA JORNADA.");
        sc.close();
    }
}
