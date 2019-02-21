
public class Defector extends Organism {

	public Defector() {
		super();
		this.energy = 0;
		this.coopProb = 0.0;
	}
	
	@Override
	public Organism reproduce() {
		
		Defector babyOrg = new Defector();
		
		return babyOrg;
	}
	
	@Override
	public String getType() {
		String type = new String("Defector");
		
		return type;
	}
	
	public double getCooperationProbability() {
		return this.coopProb;
	}
	
	@Override
	public boolean cooperates() {
		return false;
	}
	
	//getType, reproduce, getCooperationProbability, and cooperates
}
