import java.util.Random;

public class Launcher {

    final static int NB_AGENT = 6;
    
    public Launcher() {
    	int k = 1;
        for (int i = 1; i <= NB_AGENT; i++) {
            Agent ag = new Agent(i, 1+k);
            ag.start();
            
            k++;
        }
    }
   
    public static void main(String[] args) {
    	new Launcher();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void lancementAleatoire() {
    	Random random = new Random();

        for (int i = 1; i <= NB_AGENT; i++) {

            int valeur_aleatoire0_10 = random.nextInt(11);

            Agent ag = new Agent(i, valeur_aleatoire0_10);
            ag.start();
        }
    }
}