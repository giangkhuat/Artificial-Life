
import java.lang.String;

public class Organism {

  // Fields
  protected int energy;
  protected double coopProb;
  protected String type;

  // Constructor
  public Organism() {
    this.energy = 0;
  }

  // Methods

  // Procedure: update
  // Parameter: none
  // Purpose: to update the organism
  // Produce: none
  // Pre-conditions: none
  // Post-conditions: this.energy is incremented
  public void update() {
    this.incrementEnergy();
  }

  // Procedure: getEnergy
  // Parameter: none
  // Purpose: to return the energy
  // Produce: none
  // Pre-conditions: none
  // Post-conditions: this.energy is incremented
  public int getEnergy() {
    return this.energy;
  }


  // Procedure: incrementEnergy
  // Parameter: none
  // Purpose: to increment the energy
  // Produce: none
  // Pre-conditions: none
  // Post-conditions: this.energy is incremented
  public void incrementEnergy() {
    this.energy++;
  }

  // Procedure: decrementEnergy
  // Parameter: none
  // Purpose: to decrement the energy
  // Produce: none
  // Pre-conditions: none
  // Post-conditions: this.energy is decremented
  public void decrementEnergy() {
    this.energy--;
  }

  // Procedure: getType
  // Parameter: none
  // Purpose: to get the type of organism
  // Produce: name, a string
  // Pre-conditions: none
  // Post-conditions: type is returned as a string
  public String getType() {
    return this.type;
  }

  // Procedure: reproduce
  // Parameter: none
  // Purpose: to make organism reproduce
  // Produce: org, a new Organism
  // Pre-conditions: none
  // Post-conditions: a new Organism is returned
  public Organism reproduce() {
    return new Organism();
  }

  // Procedure: getCooperationProbability()
  // Parameter: none
  // Purpose: to return the cooperation probability of a Defector
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
  // Pre-conditions: none
  public boolean cooperates() {
    return true;
  }

}
