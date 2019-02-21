
public class Cooperator extends Organism {

	public Cooperator() {
		// call the subclass constructor
		super();
		this.energy = 0;
		this.coopProb = 1.0;
		this.type = "Cooperator";
	}
	
	@Override
	public Organism reproduce() {
			
			Organism babyOrg = new Cooperator();
			
			return babyOrg;
	}
	
	public String getType() {
		String type = new String("Cooperator");
		
		return type;
	}
	
	@Override
	public double getCooperationProbability() {
		return this.coopProb;
	}
	
	@Override
	// Cooperator always cooperates
	public boolean cooperates() {
		return true;
	}
}
