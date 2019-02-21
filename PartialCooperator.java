import java.util.Random;

public class PartialCooperator extends Organism {
	
	public PartialCooperator() {
		super();
		this.energy = 0;
		this.coopProb = 0.5;
	}

	@Override
	public Organism reproduce() {
		
		Organism babyOrg = new PartialCooperator();
		
		return babyOrg;
	}
	
	public String getType() {
		String type = new String("PartialCooperator");
		
		return type;
	}

	public double getCooperationProbability() {
		return this.coopProb;
	}
	
	@Override
	public boolean cooperates () {
		Random randNum = new Random();
		int x = randNum.nextInt(2);
		// if x = 0, it cooperates
		// else it does not
		return (x == 0);
	}
}
