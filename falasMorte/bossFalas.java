public class bossFalas {

    // ======= Cores =======
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // ======= Animação =======
    public static void printSlow(String frase, String cor, int tempo){
        for(char c : frase.toCharArray()){
            System.out.print(cor + c + RESET);
            System.out.flush();
            try { Thread.sleep(tempo); }
            catch(InterruptedException e){}
        }
        System.out.println();
    }

    // ======= Nome do boss =======
    public static void mostrarBoss(String nome, String cor){
        System.out.println();
        System.out.println("================================");
        printSlow(">> " + nome + " - Últimos suspiros <<", cor, 50);
        System.out.println("================================\n");
    }

    // ======= DRÁCULÁ =======
    public static void falaMorteDracula(){
        mostrarBoss("DRÁCULA", RED);

        printSlow("Ah... então é assim que termina.", RED, 25);
        printSlow("…O castelo cai, o sangue esfria...", RED, 25);
        printSlow("e ainda assim, você treme mais do que eu.", RED, 25);

        printSlow("Vá, celebre sua vitória...", RED, 25);
        printSlow("Mas quando a noite tocar sua janela,", RED, 25);
        printSlow("lembre-se: minha sombra sempre viaja mais rápido que você.", RED, 25);
        printSlow("Adeus, pequeno mortal... Por enquanto", RED, 25);
    }

    // ======= VECNA =======
    public static void falaMorteVecna() {
        mostrarBoss("VECNA", PURPLE);

        printSlow("Você me derruba... mas não me cala.", PURPLE, 25);

        printSlow("Sou o pensamento que você tenta ignorar,", 
        PURPLE, 25);
        printSlow("o sussurro que escuta quando a luz apaga.", 
        PURPLE, 25);

        printSlow("Hoje você me matou...", PURPLE, 25);
        printSlow("mas amanhã?", PURPLE, 25);
        printSlow("Amanhã eu volto como seu medo favorito.", 
        PURPLE, 25);

        printSlow("Descanse enquanto pode... eu serei seu eco eterno.", 
        PURPLE, 40);
    }

    // ======= ONRYŌ =======
    public static void falaMorteOnryo() {
        mostrarBoss("ONRYO", WHITE);

        printSlow("Minha raiva se dissolve... como fumaça triste no vento.", 
        WHITE, 25);
        printSlow("Mas você...", WHITE, 25);
        printSlow("Você carregará minha lembrança.", WHITE, 25);
        printSlow("Cada passo no escuro será meu toque.", WHITE, 25);
        printSlow("A cada arrepio, meu lamento.", WHITE, 25);
        printSlow("Deixe-me ir... se puder.", WHITE, 25);
        printSlow("Pois eu... nunca deixarei você.", WHITE, 25);
        printSlow("Adeus... ou algo perto disso.", WHITE, 40);
    }

    // ======= LÚCIFER =======
    public static void falaMorteLucifer() {
        mostrarBoss("LÚCIFER", BLACK);

        printSlow("Ah... isso vai doer por uns milênios.", BLACK, 25);
                printSlow("Parabéns, campeão.", BLACK, 25);
                    printSlow("Você acaba de ganhar uma visita VIP no Inferno...", BLACK, 25);
        printSlow("e eu juro que não é tão ruim quanto dizem.", BLACK, 25);

        printSlow("Hah... tá, talvez seja.",  BLACK, 25);

        printSlow("Nos vemos no aquecimento... digo, no inferno.", BLACK, 40);
    }

    // ======= HYDRA =======
    public static void falaMorteHydra() {
        mostrarBoss("HYDRA", GREEN);

        printSlow("Uma cabeça a menos... duas reclamações a mais.", 
        GREEN, 25);
        printSlow("Sério... você não podia ter mirado mais torto?", 
        GREEN, 25);
        printSlow("Enfim... boa luta, mortal.", 
        GREEN, 25);
        printSlow("A gente se vê quando eu recarregar.", 
        GREEN, 25);

        printSlow("Até a próxima vida... ou próxima cabeça.", 
        GREEN, 40);
    }

    // ======= ANÚBIS =======
    public static void falaMorteAnubis() {
        mostrarBoss("ANÚBIS", YELLOW);

        printSlow("Interessante... a balança disse que seu coração pesa menos que o meu.", 
        YELLOW, 25);
        printSlow("Injusto? Talvez.", 
        YELLOW, 25);
        printSlow("Mas é inútil... ninguém escapa do meu julgamento para sempre.", 
        YELLOW, 25);

        printSlow("No máximo... você adiou sua vez.", 
        YELLOW, 25);

        printSlow("Caminhe com cuidado... meu julgamento sempre retorna.", 
        YELLOW, 40);
    }

    // ======= MAIN =======
    public static void main(String[] args) {

        falaMorteDracula();
        falaMorteVecna();
        falaMorteOnryo();
        falaMorteLucifer();
        falaMorteHydra();
        falaMorteAnubis();
        }   
}

