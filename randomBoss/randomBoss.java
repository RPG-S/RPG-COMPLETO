import java.io.Serializable;
import java.util.Random;

public class randomBoss implements Serializable {
        
    // ======== Cores ========
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    // ======== Animação ========
    public static void printSlow(String frase, String cor, int tempo){
        for(char c:frase.toCharArray()){
            System.out.print(cor + c + RESET);
            System.out.flush();
            try{Thread.sleep(tempo);}catch(InterruptedException e){}
        }
        System.out.println();
    }

        // CLASSE PRINCIPAL
        static abstract class Boss implements Serializable{
        String nome;
        int vida, ataque;

        public abstract String frase();

        Boss(
        String nome,
        int vida,
        int ataque)
            {  
             this.nome=nome;
            this.vida=vida;
            this.ataque=ataque;
            }

        boolean estaVivo() {
            return vida>0;
        }

        void receberDano(int dano){vida-=dano;if(vida<0)vida=0; printSlow(nome+" recebeu "+dano+" de dano. Vida atual: "+vida, RED,25);}
        int atacar(){return ataque;}
    }

    public static class Dracula extends Boss {
        public Dracula() {
            super("Dracula", 200, 25);
        }

        @Override
        public String frase() {
            String[] frasesDracula = 
                {
               "Eu sinto o cheiro da sua culpa… pesada, podre.",
                "Você caminha como quem carrega os pecados que tentou esconder.",
                "Se busca redenção, por que seus olhos ainda sangram vergonha?",
                "Seus passos ecoam o nome daquela que você abandonou.",
                "Nem suas preces acreditam em você… por que eu acreditaria?",
                "A escuridão te conhece melhor do que você mesmo, humano.",
                "Ah… esse olhar. Tão frágil, tão quebrado. Delicioso.",
                "Venha. Mostre-me se consegue enfrentar aquilo que você teme ser."
                };
            
            Random rand = new Random();
            int choice = rand.nextInt(frasesDracula.length);
            
            return frasesDracula[choice];

        }


    }

    public static class Vecna extends Boss {
        public Vecna() {
            super("Vecna", 200, 25); 
        }

            @Override
            public String frase() {
                String[] frasesVecna = 
                {
                "A solidão… ela sussurra mais alto que qualquer grito. Você também a ouve, não ouve?",
                "Quando a última luz se apaga, é o vazio quem vem fazer companhia. Eu aprendi a aceitá-lo.",
                "Você teme a minha presença, mas eu temo apenas uma coisa: o silêncio que resta quando todos se vão.",
                "Não é a morte que assusta… é continuar vivo quando não há mais ninguém para lembrar seu nome.",
                "Cada mente que toco é uma fuga breve da eternidade solitária que me espera.",
                "Eu observo vocês se agarrando uns aos outros… como invejo essa fraqueza que vocês chamam de laço.",
                "No fim, todos caem. E quando caem… caem sozinhos. Foi assim que eu nasci, assim que eu existo.",
                "Venha. Junte-se a mim. Não porque eu preciso de você… mas porque estou cansado de caminhar sozinho na escuridão."
                };

                Random rand = new Random();
                int choice = rand.nextInt(frasesVecna.length);
                return frasesVecna[choice];
            
        }
    }

        public static class Hydra extends Boss {
        public Hydra() {
            super("Hydra", 200, 25); 
        }
        
            @Override
            public String frase() {
                String[] frasesHydra = 
                {
                 "Seu arrependimento fede a amor estragado… e eu odeio cada gota desse sentimento inútil.",
                "Você ainda ama quem te quebrou? Patético. O amor só existe para esmagar quem o carrega.",
                "Cada cabeça minha sabe: o amor é uma mentira que vocês humanos contam para justificar a dor.",
                "Você chora pela perda? Eu rio. Nada é tão desprezível quanto alguém que ama aquilo que o destruiu.",
                "Seu coração tenta se agarrar ao passado… mas eu devorarei qualquer resquício desse amor covarde.",
                "O amor te trouxe aqui — fraco, arrependido, partido. O ódio é a única verdade que resta.",
                "Você busca redenção no mesmo sentimento que te apunhalou. Eu rasgarei isso de você.",
                "Amor… arrependimento… tudo a mesma podridão. Deixe-me arrancar isso do seu peito de uma vez."
                };

                Random rand = new Random();
                int choice = rand.nextInt(frasesHydra.length);
                return frasesHydra[choice];
            
        }
    }

    

        public static class Anubis extends Boss {
        public Anubis() {
            super("Anubis", 200, 25); 
        }
        
            @Override
            public String frase() {
                String[] frasesAnubis = 
                {
                 "Eu vejo cada sombra que você tentou esconder… todas caminham atrás de você, esperando o julgamento que teme encarar.",
                "Sua alma treme, não por mim, mas pelo que construiu com suas próprias escolhas… nada pesa mais que a verdade.",
                "Você fala em redenção, mas seu coração conhece o preço do que fez — e sabe que não poderá pagá-lo em vida.",
                "Há pecados que o tempo tenta apagar… mas o além os guarda como cicatrizes eternas.",
                "Não é a morte que o assusta, é o espelho que ela carrega… onde sua culpa surge sem máscara.",
                "Os deuses não punem com fogo, mas com memória… e a sua já está queimando sozinha.",
                "Você teme meu veredito, mas a realidade é simples: foi sua própria alma quem lhe condenou primeiro.",
                "No fim, não sou eu quem julga… apenas abro a porta. É você quem caminha até o peso que sempre evitou."
                };
                Random rand = new Random();
                int choice = rand.nextInt(frasesAnubis.length);
                return frasesAnubis[choice];
            
        }
    }

    
        public static class Lucifer extends Boss {
        public Lucifer() {
            super("Lucifer", 200, 25); 
        }
        
            @Override
            public String frase() {
                String[] frasesLucifer = 
                {
                "“Vamos acabar com a farsa… você nunca a amou. Você só gostava do reflexo bonito que ela fazia de você.”",
                "“Sabe o que dói? Nem eu, o próprio Lúcifer, seria capaz de usar alguém como você fez com ela.”",
                "“Você chamava aquilo de amor, mas no fundo só queria alguém para apanhar os pedaços da sua alma quebrada.”",
                "“Admita… quando ela começou a ver quem você realmente era, você desejou que ela simplesmente sumisse.”",
                "“Não tenta negar. Em noites silenciosas, você queria que ela morresse só para se livrar do peso da culpa.”",
                "“O mais irônico? Ela acreditou em tudo que você fingiu sentir. Você manipulou até o último suspiro de esperança dela.”",
                "“Você não perdeu um amor. Você perdeu um espelho que ainda te fazia acreditar que havia algo de bom em você.”",
                "“E agora chora arrependimento? Não seja ridículo. O único monstro naquela história… sempre foi você.”"
                };
                Random rand = new Random();
                int choice = rand.nextInt(frasesLucifer.length);

                return frasesLucifer[choice];
            
        }
    }

            public static class Onryo extends Boss {
                public Onryo() {
                super("Onryo", 200, 25); 
        }
        
            @Override
            public String frase() {
                String[] frasesOnryo = 
                {
                 "Eu achei que você tinha mudado… mas você sempre volta ao mesmo ponto, não é?",
                "Por que você treme? É só a repetição do que você mesmo criou.",
                "Eu sou o reflexo de todas as promessas que você quebrou… uma por uma.",
                "Você me escuta porque sabe que, no fundo, ainda tem medo de amar igual da última vez.",
                "Toda vez que você tenta esquecer, eu volto — porque você ainda é o mesmo.",
                "Eu sussurro exatamente como ela… porque você nunca deixou minha voz morrer.",
                "Seus passos repetem o passado, e seu coração repete a dor. Sempre o mesmo ciclo.",
                "Eu sou o erro que você jurou não cometer de novo… mas você já está repetindo."
                };
                
                Random rand = new Random();
                int choice = rand.nextInt(frasesOnryo.length);
                
                return frasesOnryo[choice];
            
        }
    }



    public static void main(String[] args) {

        // BOSSES
        // Dracula dracula = new Dracula();
        // Vecna vecna = new Vecna();
        // Anubis anubis = new Anubis();
        // Lucifer lucifer = new Lucifer();
        // Hydra hydra = new Hydra();
        // Onryo onryo = new Onryo();   

        // VAI RODAR UMA FRASE ALEATORIA DA LISTA 
        // printSlow(dracula.frase(), RED, 10);
        // printSlow(vecna.frase(), GREEN, 10);
        // printSlow(anubis.frase(), YELLOW, 10);
        // printSlow(lucifer.frase(), PURPLE, 10);
        // printSlow(hydra.frase(), BLUE, 10);
        // printSlow(onryo.frase(), CYAN, 10);


        // ALEATORIZADOR
        Boss[] bosses = {
            new Dracula(),
            new Vecna(),
            new Hydra(),
            new Anubis(),
            new Lucifer(),
            new Onryo()
        };

        Random random = new Random();

        int choice1 = random.nextInt(bosses.length);
        int choice2;

        do {
            choice2 = random.nextInt(bosses.length);

        } while (choice2 == choice1);


        System.out.printf("%s: %s\n", bosses[choice1].nome, bosses[choice1].frase());
        System.out.printf("%s: %s", bosses[choice2].nome, bosses[choice2].frase());
    }

}