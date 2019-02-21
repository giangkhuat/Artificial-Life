
public class Organism {
	
	//Fields
	
	protected int energy;
	protected double coopProb;
	protected String type;
	//Constructor
	public Organism() {
		this.energy = 0;
	}
	
	//Methods
	public void update() {
		this.incrementEnergy();
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void incrementEnergy() {
		this.energy++;
	}
	
	public void decrementEnergy() {
		this.energy--;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Organism reproduce() {
		return new Organism();
	}
	
	public double getCooperationProbability() {
		return this.coopProb;
	}
	
	public boolean cooperates() {
		return true;
	}
	
	// a compare method to sort ?
	
	
	
}
