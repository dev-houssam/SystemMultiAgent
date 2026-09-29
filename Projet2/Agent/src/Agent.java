
public class Agent extends Thread {

	private int value;
	private  int id=0;
	private boolean state_affiche = true;
	private boolean state_multiply = false;
	private boolean state_attente = false;
	
	public Agent(int id, int value) {
		this.id  = id;
		this.value = value;
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			if(this.state_affiche) {
				System.out.println("Agent_id:" + this.id + " value:" + this.value);
				this.state_affiche = false;
				this.state_attente = true;
				
			}else if(this.state_multiply) {
				this.value *= 2;
				this.state_multiply = true;
				if(this.value >= 100) {
					Thread.currentThread().interrupt();
				}
				this.state_affiche = true;
			}else if(this.state_attente) {
				
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {}
				
				this.state_attente = false;
				this.state_multiply = true;
			}
		}
		//System.out.println(this.id + " have Finished");
	}
}
