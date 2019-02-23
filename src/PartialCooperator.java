import java.util.Random;

public class PartialCooperator extends Organism {

	// constructor
	public PartialCooperator() {
		super();
		this.energy = 0;
		this.coopProb = 0.5;
	}

	// Procedure: reproduce
	// Parameter: none
	// Purpose: to make PartialCooperator reproduce
	// Produce: org, a new Organism
	// Pre-conditions: none
	// Post-conditions: a new Organism is returned
	@Override
	public Organism reproduce() {
		Organism babyOrg = new PartialCooperator();
		return babyOrg;
	}

	// Procedure: getType
	// Parameter: none
	// Purpose: to get the type of organism
	// Produce: name, a string
	// Pre-conditions: none
	// Post-conditions: name is returned as "PartialCooperator"
	public String getType() {
		String type = new String("PartialCooperator");
		return type;
	}

	// Procedure: getCooperationProbability()
	// Parameter: none
	// Purpose: to return the cooperation probability of a Paritial Cooperator
	// Produce: Prob, a double
	// Pre-conditions: none
	// Post-conditions: Prob is a nonnegative number from 0 to 1
	public double getCooperationProbability() {
		return this.coopProb;
	}

	// Procedure: cooperates()
	// Parameter: none
	// Purpose: to return whether the organism will cooperate
	// Produce: coop?, a boolean value
	// Pre-conditions: Random is imported
	// Post Condition, coop? is either true or false
	@Override
	public boolean cooperates() {
		Random randNum = new Random();
		int x = randNum.nextInt(2);
		return (x == 0);
	}
}
