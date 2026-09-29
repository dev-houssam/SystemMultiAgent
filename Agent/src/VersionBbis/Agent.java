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
	private boolean is_agent_active = true;
	
	final private int NB_STATE = 4;
	private int current_state = 1;
	private int next_state = current_state + 1;
	
	public Agent(int id, Structure structure) {
		this.id  = id;
		this.structure = structure;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted() && this.is_agent_active) {
			runState();
		}
		//System.out.println(this.id + " have Finished");
	}
	
	private void action_prendre() {
		Object MessageValeur = this.structure.prendre();
		
		if(MessageValeur != null) 
		{
			this.value = (Integer) MessageValeur;
		}
		else 
		{
			this.is_agent_active = false;
		}
		
	}
	
	private void action_traitement() {
		this.value = this.value * 2;
		
		if(this.value >= 100) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void action_deposer() {
		this.structure.poser(value);
		
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {}
	}
	
	private void runState() {
		this.next_state = (this.current_state + 1) % this.NB_STATE;
		switch(this.current_state) {
			case 1:
				this.action_prendre();
				this.current_state = this.next_state;
				break;
			case 2:
				this.action_traitement();
				this.current_state = this.next_state;
				break;
			case 3:
				this.action_deposer();
				this.current_state = this.next_state;
				break;
		}
	}
	
}
