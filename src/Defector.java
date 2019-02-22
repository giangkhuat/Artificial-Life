
public class Defector extends Organism {

  // constructor
  public Defector() {
    super();
    this.energy = 0;
    this.coopProb = 0.0;
  }

  // Procedure: reproduce
  // Parameter: none
  // Purpose: to make the Defector reproduce
  // Produce: babyOrg, an Organism object
  // Pre-conditions: none
  // Post-conditions: a new Organism is returned

  @Override
  public Organism reproduce() {
    Defector babyOrg = new Defector();
    return babyOrg;
  }


  // Procedure: getType()
  // Parameter: none
  // Purpose: to return the type of the Organism,
  // Produce: name, a string
  // Pre-conditions: none
  // Post-conditions: name is returned as "Defector"

  @Override
  public String getType() {
    String type = new String("Defector");
    return type;
  }

  // Procedure: getCooperationProbability()
  // Parameter: none
  // Purpose: to return the cooperation probability of a Defector
  // Produce: Prob, a double
  // Pre-conditions: none
  // Post-conditions: Prob is always 0.0
  public double getCooperationProbability() {
    return this.coopProb;
  }

  // Procedure: cooperates()
  // Parameter: none
  // Purpose: to return whether the Defector will cooperate
  // Produce: coop?, a boolean value
  // Pre-conditions: none
  // Post-conditions: coop? always return FALSE
  
  @Override
  public boolean cooperates() {
    return false;
  }
  
}
