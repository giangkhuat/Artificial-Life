
public class Cooperator extends Organism {
  // Constructor
  public Cooperator() {
    // call the subclass constructor
    super();
    this.energy = 0;
    this.coopProb = 1.0;
    this.type = "Cooperator";
  }
  
  // Procedure: reproduce
  // Parameter: none
  // Purpose: to make the organism reproduce
  // Produce: babyOrg, an Organism object
  // Pre-conditions: none
  // Post-conditions: a new Cooperator of superclass Organism is returned

  @Override
  public Organism reproduce() {
    Organism babyOrg = new Cooperator();
    return babyOrg;
  }

  // Procedure: getType()
  // Parameter: none
  // Purpose: to return the type of the Organism,
  // Produce: name, a string
  // Pre-conditions: none
  // Post-conditions: name, a string is returned

  public String getType() {
    String type = new String("Cooperator");
    return type;
  }

  // Procedure: getCooperationProbability()
  // Parameter: none
  // Purpose: to return the cooperation probability of Cooperator
  // Produce: Prob, a double
  // Pre-conditions: none
  // Post-conditions: Prob is always 1.0

  @Override
  public double getCooperationProbability() {
    return this.coopProb;
  }

  // Procedure: cooperates()
  // Parameter: none
  // Purpose: to return whether the Cooperator will cooperate
  // Produce: coop?, a boolean value
  // Pre-conditions: none
  // Post-conditions: coop? always return true

  @Override
  // Cooperator always cooperates
  public boolean cooperates() {
    return true;
  }
}
