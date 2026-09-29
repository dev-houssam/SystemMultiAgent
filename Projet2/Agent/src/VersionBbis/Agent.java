package VersionBbis;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Agent extends Thread {
	private  int id=0;
	private  int value=0;
	private boolean state_take = true;
	private boolean state_process = false;
	private boolean state_put = false;
	private Structure structure = null;
	private boolean active = false;
	
	public Agent(int id, Structure structure) {
		this.id  = id;
		this.structure = structure;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			
			value = this.structure.prendre();
			
			runState();
		}
		//System.out.println(this.id + " have Finished");
	}
	
	private void runState() {
		if(this.state_take) {
			Object MessageValeur = this.structure.prendre();
			if(MessageValeur != null) {
				this.state_process = true;
			}else {
				active = false;
			}
			
		}else if(this.state_process) {
			
			
			
			this.value *= 2;
			this.state_process = false;
			if(this.value >= 100) {
				Thread.currentThread().interrupt();
			}
			
			this.state_take = true;
		}else if(this.state_put) {
			
			try {
				this.structure.poser(value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {}
			
			this.state_put = false;
			this.state_process = true;
		}
	}
}
