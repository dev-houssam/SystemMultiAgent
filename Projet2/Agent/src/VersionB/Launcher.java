package VersionB;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Launcher {

    final static int NB_AGENT = 1;
    final static int NB_VALUE = 100;
    
    public Launcher() {
    	
    	Structure struct = new Structure(NB_VALUE);
    	
        for (int i = 1; i <= NB_AGENT; i++) {
            Agent ag = new Agent(i, struct);
            ag.start();

        }
    }
   
    public static void main(String[] args) {
    	new Launcher();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void lancementAleatoire() {
    	Random random = new Random();

        for (int i = 1; i <= NB_AGENT; i++) {

            int valeur_aleatoire0_10 = random.nextInt(11);

            Agent ag = new Agent(i, null);
            ag.start();
        }
    }
}