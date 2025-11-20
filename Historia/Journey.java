import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Journey {

    static List<String> memorias = new ArrayList<>();

    // Função para pegar um fragmento aleatório sem repetir
    public static void revelarMemoria() {
        Random random = new Random();

        memorias.add(
                " Um fragmento mostrando você criança correndo por um campo ensolarado.,\n" +
                        "Você vê uma figura segurando sua mão — mas o rosto está borrado.,\n" +
                        "Um dia chuvoso em que você jurou nunca abandonar quem ama.,\n" +
                        "Você treinando com uma lâmina antiga, com alguém observando ao longe.,\n" +
                        "A imagem de uma porta dourada que você nunca conseguiu abrir." +
                        "VOCÊ NASCEU PRA ACABAR COM TODA A COVARDIA DO MUNDO!"
        );

        memorias.add(
                "Você lutou com o rei demônio antes de estar aqui, mas você perdeu.\n" +
                        "O Rei Demônio disse algo antes de você perder a consciência:\n" +
                        "“Você nunca foi capaz de proteger quem ama de verdade”."
        );

        memorias.add(
                "Você lembra que a mulher que você sempre amou selou sua alma com a própria vida dentro dessa masmorra,\n" +
                        "antes de morrer para salvar esse país sujo do Rei Demônio.\n" +
                        "Dessa vez você não pode fracassar — ela deu sua vida por isso. ACABE COM O REI DEMÔNIO!"
        );

        memorias.add(
                "Uma mulher de voz suave te disse antes da batalha final:\n" +
                        "“Manoel… não esqueça quem você realmente é”.\n" +
                        "Ela era a mulher que você sempre amou e jurou proteger..."
        );

        memorias.add(
                "Você era apenas um aventureiro no começo, mas ao longo da jornada conheceu pessoas importantes.\n" +
                        "Pessoas que você amava, respeitava… pessoas em quem confiava.\n" +
                        "Ou pelo menos era isso que você acreditava."
        );

        memorias.add(
                "Você está no castelo do Drácula, lutando contra ele, quando sente uma lâmina fria atravessando suas costas.\n" +
                        "Mas não foi ele. Foi uma das pessoas que você mais confiou.\n" +
                        "Seu melhor amigo vendeu sua alma — e a de seus companheiros — por riqueza.\n" +
                        "Mas agora você tem uma segunda chance. VINGUE TODOS E FAÇA-OS PAGAR!"
        );

        if (memorias.isEmpty()) {
            System.out.println("\n(Não há mais fragmentos de memória para recuperar...)");
            return;
        }

        int index = random.nextInt(memorias.size());
        String memoriaEscolhida = memorias.get(index);

        System.out.println("\n>>> FRAGMENTO DE MEMÓRIA REVELADO <<<");
        System.out.println(memoriaEscolhida);

        memorias.remove(index);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("As criaturas desse mundo sempre viveram isoladas dos seres humanos,");
        System.out.println("até que um dia uma criatura superior nasceu: o Rei Demônio.");
        System.out.println("Com seu poder e liderança, uniu todos os monstros do mundo.");
        System.out.println("Alguns buscaram paz. Outros, destruição.");
        System.out.println("E assim, uma grande guerra começou entre humanos e monstros.");
        System.out.println("\nPressione Enter para começar a história...");
        scanner.nextLine();

        System.out.println("\n------------------------------------");
        System.out.println("        CAPÍTULO 1 — O DESPERTAR");
        System.out.println("------------------------------------\n");

        // LOOP DE ESCOLHA INICIAL
        while (true) {

            System.out.println("... Manoel... Manoel... acorde ...");
            System.out.println("Você está em uma masmorra escura. O que faz?");
            System.out.println("1. Explorar o local");
            System.out.println("2. Ficar parado");

            int escolha1 = scanner.nextInt();
            scanner.nextLine();

            if (escolha1 == 1) {

                System.out.println("\nVocê anda pelo corredor e encontra dois goblins...");
                System.out.println("1. Atacar");
                System.out.println("2. Conversar");

                int escolha2 = scanner.nextInt();
                scanner.nextLine();

                if (escolha2 == 1) {
                    System.out.println("\nVocê derrota os goblins!");
                } else {
                    System.out.println("\nUm lobo espectral aparece e mata os goblins.");
                    System.out.println("Você foge para o próximo corredor.");
                }
                break;

            } else if (escolha1 == 2) {

                System.out.println("\nVocê fica parado tentando lembrar algo...");
                System.out.println("Nada vem à mente.");
                System.out.println("Mas então...");
                System.out.println("Você escuta uma voz doce, suave, apaixonante te chamando no final da masmorra...");
                System.out.println("\nIsso te deixa inquieto. Você sente que precisa continuar.");
                System.out.println("Pressione ENTER para tentar novamente.");
                scanner.nextLine();
            }
        }

        // BOSS 1
        System.out.println("\n------------------------------------");
        System.out.println("         CAPÍTULO 2 — BOSS");
        System.out.println("------------------------------------\n");

        revelarMemoria();

        // BOSS 2
        System.out.println("\n------------------------------------");
        System.out.println("         CAPÍTULO 3 — BOSS");
        System.out.println("------------------------------------\n");

        revelarMemoria();

        // BOSS 3
        System.out.println("\n------------------------------------");
        System.out.println("         CAPÍTULO 4 — BOSS");
        System.out.println("------------------------------------\n");

        revelarMemoria();

        // BOSS 4
        System.out.println("\n------------------------------------");
        System.out.println("         CAPÍTULO 5 — BOSS");
        System.out.println("------------------------------------\n");

        revelarMemoria();

        // BOSS 5
        System.out.println("\n------------------------------------");
        System.out.println("         CAPÍTULO 6 — BOSS");
        System.out.println("------------------------------------\n");

        revelarMemoria();

        // FINAL RUMO AO REI DEMÔNIO
        System.out.println("\n------------------------------------");
        System.out.println("              CAPÍTULO FINAL");
        System.out.println("------------------------------------\n");

        System.out.println("Você pega seu cavalo e vai atrás do Rei Demônio em seu castelo.");
        System.out.println("Dessa vez, você o derrota. Você se sente mais forte do que nunca.");

        // PÓS BATALHA
        System.out.println("\n------------------------------------");
        System.out.println("               PÓS-BATALHA");
        System.out.println("------------------------------------\n");

        System.out.println("Após derrotar a ameaça final, seu nome ecoou por todo o reino.");
        System.out.println("Você foi celebrado como o maior herói que o país já viu.");
        System.out.println("Recebeu títulos, honrarias e uma vida tranquila muito antes da velhice.");
        System.out.println("Aposentado cedo, viveu em paz, amado pelo povo.");
        System.out.println("E quando finalmente partiu deste mundo, seu nome ficou marcado para sempre na história...");
        System.out.println("\nFIM");

        scanner.close();
    }
}
