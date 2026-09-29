package VersionB;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Structure {

    private BlockingQueue<Integer> file;
    private int valeurs_traitee = 0;
    private int valeurs_pris = 0;

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

    public Integer prendre() {

        try {
			return this.file.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public void poser(int valeur) throws InterruptedException {

        this.file.put(valeur);
    }
}