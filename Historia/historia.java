import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Chefe {
    String nome;
    String titulo;
    String subordinado;
    String descricao;
    String bioma;

    public Chefe(String nome, String titulo, String subordinado, String descricao, String bioma) {
        this.nome = nome;
        this.titulo = titulo;
        this.subordinado = subordinado;
        this.descricao = descricao;
        this.bioma = bioma;
    }
}

public class historia {

    static List<String> memorias = new ArrayList<>();
    static List<Chefe> chefesFixos = new ArrayList<>();

    public static void inicializarChefes() {
        chefesFixos.add(new Chefe(
                "Drácula",
                "O Vampiro Mestre",
                "Morcegos Gigantes e Guardas da Noite",
                "O senhor dos vampiros e mestre das trevas. Sua presença drena a vida e a esperança.",
                "Castelo da Noite Eterna"
        ));
        chefesFixos.add(new Chefe(
                "Vecna",
                "O Mestre da Mente",
                "Ilusões e Ghouls Psíquicos",
                "Um lich que governa através do medo e da magia mental. Ele fará você reviver sua traição.",
                "Cidadela dos Pesadelos"
        ));
        chefesFixos.add(new Chefe(
                "Hydra",
                "O Monstro dos Mares",
                "Serpentes Marinhas e Guardiões Venenosos",
                "Uma besta aquática de múltiplas cabeças que protege as profundezas. Seus venenos são lendários.",
                "Mares Maléficos de Lerna"
        ));
        chefesFixos.add(new Chefe(
                "Anúbis",
                "O Deus da Morte",
                "Mumias e Servos do Submundo",
                "O juiz da morte. Ele testará sua alma e seu valor. Sua força é a da eternidade.",
                "Templo das Areias Esquecidas"
        ));
        chefesFixos.add(new Chefe(
                "Onryo",
                "O Espírito Vingativo",
                "Fantasmas e Espectros do Ódio",
                "Uma alma torturada transformada em força destrutiva. Seu grito de vingança é ensurdecedor.",
                "Vale das Lamentações Silenciosas"
        ));
        chefesFixos.add(new Chefe(
                "Lúcifer",
                "O Rei Demônio (Chefe Final)",
                "Generais do Caos e Demônios Maiores",
                "O Portador da Luz Caído e a origem de todo o mal na masmorra. O confronto final.",
                "Trono de Obsidiana no Inferno"
        ));
    }

    public static void inicializarMemorias() {
        memorias.add(
                "Um fragmento mostrando você criança correndo por um campo ensolarado. Você vê uma figura segurando sua mão — mas o rosto está borrado. VOCÊ NASCEU PRA ACABAR COM TODA A COVARDIA DO MUNDO!"
        );
        memorias.add(
                "Você lutou com o Rei Demônio antes de estar aqui, mas você perdeu. Ele disse: “Você nunca foi capaz de proteger quem ama de verdade”."
        );
        memorias.add(
                "Você lembra que a mulher que você sempre amou selou sua alma com a própria vida dentro dessa masmorra, para salvar esse país sujo. ACABE COM O REI DEMÔNIO!"
        );
        memorias.add(
                "Uma mulher de voz suave te disse antes da batalha final: “Manoel… não esqueça quem você realmente é”. Ela era a mulher que você jurou proteger..."
        );
        memorias.add(
                "Você percebe o quanto confiou em quem o traiu. Seu melhor amigo vendeu sua alma e a de seus companheiros por riqueza. VINGUE TODOS E FAÇA-OS PAGAR!"
        );
        memorias.add(
                "Você está no castelo do Drácula, lutando, quando sente uma lâmina fria atravessando suas costas. Não foi o Drácula. Foi seu melhor amigo."
        );
        memorias.add(
                "O vazio em seu peito se fecha. A dor da traição se tornou a força que Lúcifer nunca previu. Você não é mais apenas Manoel, mas a Vingança manifesta."
        );
    }

    public static void revelarMemoria() {
        if (memorias.isEmpty()) {
            System.out.println("\n(Não há mais fragmentos de memória para recuperar...)");
            return;
        }

        String memoriaEscolhida = memorias.remove(0);

        System.out.println("\n>>> FRAGMENTO DE MEMÓRIA REVELADO <<<");
        System.out.println(memoriaEscolhida);
    }

    public static boolean simularCombate(String nomeInimigo, Scanner leitor, boolean isBoss) {
        Random rand = new Random();
        int hpJogador = 20;
        int hpInimigo = isBoss && nomeInimigo.contains("Lúcifer") ? 20 : (isBoss ? 15 : 10);
        String tituloInimigo = isBoss ? "CHEFE" : "INIMIGO";

        System.out.println("\n------------------------------------");
        System.out.println("      INÍCIO DA LUTA: " + nomeInimigo.toUpperCase());
        System.out.println("------------------------------------");
        System.out.println("Sua vida: " + hpJogador + " HP | " + tituloInimigo + " vida: " + hpInimigo + " HP");

        while (hpJogador > 0 && hpInimigo > 0) {
            System.out.println("\nEscolha sua ação:");
            System.out.println("1. Atacar (Dano: 3-5)");
            System.out.println("2. Defender (Reduz o dano recebido em 50%)");

            int acao = 0;
            try {
                acao = leitor.nextInt();
                leitor.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ação inválida. Atacando por padrão.");
                acao = 1;
                leitor.nextLine();
            }

            boolean defendendo = (acao == 2);
            if (acao == 1) {
                int danoCausado = rand.nextInt(3) + 3;
                hpInimigo -= danoCausado;
                System.out.println("Você ATACA! " + nomeInimigo + " recebe " + danoCausado + " de dano.");
            } else if (acao == 2) {
                System.out.println("Você DEFENDE, preparando-se para o golpe.");
            }

            if (hpInimigo <= 0) break;

            int danoInimigo = rand.nextInt(2) + 1;
            if (defendendo) {
                danoInimigo /= 2;
                System.out.println(nomeInimigo + " ataca, mas sua defesa REDUZ o dano. Você recebe " + danoInimigo + " de dano.");
            } else {
                System.out.println(nomeInimigo + " ataca com força! Você recebe " + danoInimigo + " de dano.");
            }
            hpJogador -= danoInimigo;

            if (hpJogador <= 0) {
                hpJogador = 5;
            }

            System.out.println("Sua vida: " + hpJogador + " HP | " + tituloInimigo + " vida: " + hpInimigo + " HP");
        }

        System.out.println("\n------------------------------------");
        System.out.println("      VITÓRIA! " + nomeInimigo.toUpperCase() + " FOI DERROTADO!");
        System.out.println("------------------------------------");
        return true;
    }

    public static void simularLutaChefe(Chefe chefe, Scanner leitor, boolean revelarMemoria) {
        System.out.println("\nÀ sua frente, o temível " + chefe.nome + ", " + chefe.titulo + "!");
        System.out.println(chefe.descricao);

        System.out.println("\nVocê deve primeiro enfrentar seus capangas: " + chefe.subordinado + "!");
        simularCombate(chefe.subordinado, leitor, false);

        System.out.println("\nVocê supera os " + chefe.subordinado + " com suas habilidades renovadas.");
        if (revelarMemoria) {
            System.out.println("A energia da batalha abre um portal em sua mente.");
            revelarMemoria();
        }

        System.out.println("\nO " + chefe.nome + " está furioso com a derrota de seus subordinados. HORA DO CONFRONTO!");
        simularCombate(chefe.nome, leitor, true);

        System.out.println("\nApós uma árdua batalha, você derrota " + chefe.nome + "!");
        System.out.println("Você sente o poder dele ser absorvido por você. Você está mais perto de seu objetivo.");
    }

    public static void transicaoBioma(String nomeBioma, Scanner leitor) {
        System.out.println("\nVocê se encontra diante de uma mudança abrupta no ambiente.");
        System.out.println("O portal à sua frente revela o domínio de um novo inimigo.");
        System.out.println("1. Entrar no domínio (" + nomeBioma + ")");

        int escolha;
        try {
            escolha = leitor.nextInt();
            leitor.nextLine();
        } catch (java.util.InputMismatchException e) {
            leitor.nextLine();
            System.out.println("\nEscolha inválida, mas seu instinto o força a avançar.");
            escolha = 1;
        }

        if (escolha == 1) {
            System.out.println("\n====================================================");
            System.out.println("      >>> ENTRANDO NO DOMÍNIO: " + nomeBioma.toUpperCase() + " <<<");
            System.out.println("====================================================\n");
        } else {
            System.out.println("\nVocê hesita, mas a única saída é adiante. Você avança à força.");
        }
    }


    public static boolean eventoProgressoAleatorio(Scanner leitor) {
        Random random = new Random();
        int evento = random.nextInt(3);

        switch (evento) {
            case 0:
                System.out.println("\nEnquanto você tenta se concentrar, um barulho de armadura ecoa. Um grupo de Esqueletos Patrulheiros surge.");
                simularCombate("Esqueletos Patrulheiros", leitor, false);
                System.out.println("Você consegue escapar e segue em frente.");
                return true;
            case 1:
                System.out.println("\nVocê percebe que está perdendo tempo. O instinto manda avançar.");
                return true;
            case 2:
                System.out.println("\nVocê encontra um pequeno altar abandonado. Um objeto brilha: Você recupera 5 Pontos de Vida (HP).");
                return false;
            default:
                return false;
        }
    }


    public static void main(String[] args) {
        inicializarChefes();
        inicializarMemorias();

        Chefe dracula = chefesFixos.get(0);
        Chefe vecna = chefesFixos.get(1);
        Chefe hydra = chefesFixos.get(2);
        Chefe anubis = chefesFixos.get(3);
        Chefe onryo = chefesFixos.get(4);
        Chefe lucifer = chefesFixos.get(5);

        Scanner leitor = new Scanner(System.in);

        System.out.println("As criaturas desse mundo sempre viveram isoladas dos seres humanos, até que um dia nasceu o Rei Demônio.");
        System.out.println("Com seu poder e liderança, uniu todos os monstros do mundo. Uma grande guerra começou.");
        System.out.println("\nPressione Enter para começar a história...");
        leitor.nextLine();

        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 1 — O DESPERTAR");
        System.out.println("------------------------------------\n");

        boolean estaMovendo = false;
        while (!estaMovendo) {
            System.out.println("... Manoel... Manoel... acorde ... Você está em uma masmorra escura. O que faz?");
            System.out.println("1. Explorar o local (Caminho Fixo - CAMPANHA COMPLETA)");
            System.out.println("2. Ficar parado (Caminho Aleatório com Progresso)");

            int escolha1;
            try {
                escolha1 = leitor.nextInt();
                leitor.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nEntrada inválida. Digite 1 ou 2.");
                leitor.nextLine();
                continue;
            }

            if (escolha1 == 1) {
                System.out.println("\nVocê anda pelo corredor e encontra dois goblins...");
                simularCombate("Dois Goblins", leitor, false);
                estaMovendo = true;
            } else if (escolha1 == 2) {
                estaMovendo = eventoProgressoAleatorio(leitor);
                if (!estaMovendo) {
                    System.out.println("\nO que você faz agora?");
                }
            } else {
                System.out.println("Opção inválida. Escolha 1 ou 2.");
            }
        }

        // --- CAPÍTULO 2: DRÁCULA ---  registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 2 — O VAMPIRO MESTRE");
        System.out.println("------------------------------------\n");
        simularLutaChefe(dracula, leitor, true);

        // --- CAPÍTULO 3: DESCANSO E TRANSIÇÃO VECNA --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 3 — O PESO DA PERDA");
        System.out.println("------------------------------------\n");
        System.out.println("Você encontra um local seguro para descansar. A quietude da masmorra permite que outro pedaço de sua alma se manifeste.");
        revelarMemoria();

        transicaoBioma(vecna.bioma, leitor);

        // --- CAPÍTULO 4: VECNA E HIDRA --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 4 — MENTE E MARES");
        System.out.println("------------------------------------\n");

        simularLutaChefe(vecna, leitor, true);

        System.out.println("\nVocê derrota o Mestre da Mente, mas o caminho para a próxima câmara está bloqueado.");
        transicaoBioma(hydra.bioma, leitor);

        // --- CAPÍTULO 5: HIDRA E ANÚBIS --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 5 — JULGAMENTO E FORÇA");
        System.out.println("------------------------------------\n");

        simularLutaChefe(hydra, leitor, true);

        System.out.println("\nApós a batalha aquática, você sente a presença fria e pesada do Guardião da Morte.");
        transicaoBioma(anubis.bioma, leitor);

        simularLutaChefe(anubis, leitor, false);

        // --- CAPÍTULO 6: ONRYO E TRAIDOR --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 6 — A VINGANÇA E A TRAIÇÃO");
        System.out.println("------------------------------------\n");

        transicaoBioma(onryo.bioma, leitor);

        simularLutaChefe(onryo, leitor, false);

        System.out.println("\nEnquanto você avança, um Cavaleiro Corrompido, seu antigo 'companheiro', aparece!");
        simularCombate("Cavaleiro Corrompido (O Traidor)", leitor, false);

        System.out.println("Você o derrota. A verdade se revela.");
        revelarMemoria();

        // --- CAPÍTULO 7: PRÓXIMO DO FIM E MEMÓRIA FINAL --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO 7 — O PREÇO DO SACRIFÍCIO");
        System.out.println("------------------------------------\n");

        System.out.println("Você atravessa os portões finais, mais forte. A imagem do passado se torna cristalina, mostrando o momento de sua queda.");
        revelarMemoria();

        transicaoBioma(lucifer.bioma, leitor);

        // --- CAPÍTULO FINAL: LÚCIFER --- registro de capitulo!!!
        System.out.println("\n------------------------------------");
        System.out.println("      CAPÍTULO FINAL — A VINGANÇA CONTRA " + lucifer.nome.toUpperCase());
        System.out.println("------------------------------------\n");

        System.out.println("Com a verdade revelada e sua força restaurada, você cavalga até o castelo de " + lucifer.nome + ".");

        System.out.println("\nÀ sua frente, o temível " + lucifer.nome + ", " + lucifer.titulo + "!");
        System.out.println(lucifer.descricao);
        System.out.println("\nVocê deve primeiro enfrentar seus capangas: " + lucifer.subordinado + "!");
        simularCombate(lucifer.subordinado, leitor, false);

        System.out.println("\nVocê supera os subordinados. HORA DO CONFRONTO FINAL!");
        simularCombate(lucifer.nome, leitor, true);

        System.out.println("Dessa vez, você o derrota! A última e mais poderosa memória se desbloqueia.");
        revelarMemoria();

        // PÓS BATALHA
        System.out.println("\n------------------------------------");
        System.out.println("              PÓS-BATALHA");
        System.out.println("------------------------------------\n");

        System.out.println("Após derrotar a ameaça final, seu nome ecoou por todo o reino.");
        System.out.println("Você foi celebrado como o maior herói que o país já viu. O FIM da guerra.");
        System.out.println("\nFIM");

        leitor.close();
    }
}
