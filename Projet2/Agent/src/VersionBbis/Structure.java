package VersionBbis;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Structure {

    private BlockingQueue<Integer> file;
    private int valeurs_traitee = 0;
    private int valeurs_pris = 0;
    
    private Integer MessageNull = null;

    public Structure(int size) {

        this.file = new ArrayBlockingQueue<>(size);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            this.file.add(random.nextInt(100));
        }
        System.out.println("Initialisation Structure initiale");
        this.print();
    }

    public void print() {

        System.out.println(this.file.toString());
    }

    public synchronized Integer prendre() {

        try {
        	this.valeurs_pris += 1;
        	if(this.valeurs_pris == this.valeurs_traitee) {
        		return MessageNull;
        	}else {
        		return this.file.take();
        	}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public synchronized void  poser(int valeur) {

    	this.valeurs_traitee += 1;
        try {
			this.file.put(valeur);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}