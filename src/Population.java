import java.util.ArrayList;
import java.lang.Integer;
import java.util.Random;

public class Population {

	// Fields
	// r is the random number generated
	static Random r = new Random(1);
	int ticks;
	// number of Cooperators
	int numberCoop;
	// number of Defectors
	int numberDefect;
	// number of Partial Cooperators
	int numberPartcoop;
	// total number of Organisms
	protected int totalOrg;
	// popArray is the arraylist of all organisms
	protected ArrayList<Organism> popArray;

	// constructor
	public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
		// initialize each organism's count
		this.numberCoop = counts[0].right;
		this.numberDefect = counts[1].right;
		this.numberPartcoop = counts[2].right;
		// calculate total number of organisms in the population
		this.totalOrg = this.numberCoop + this.numberDefect + this.numberPartcoop;
		this.ticks = 0;
		this.popArray = new ArrayList<Organism>();

		// initialize the organisms in population
		for (int i = 0; i < totalOrg; i++) {
			// the first numberCoop organisms are Cooperators
			if (i < this.numberCoop) {
				popArray.add(new Cooperator());
			} // else they are defectors
			else if (i < (this.numberCoop + this.numberDefect)) {
				popArray.add(new Defector());
			} // else they are Partial Cooperators
			else {
				popArray.add(new PartialCooperator());
			}
		}
	}

	// method to shuffle an array of indices
	// procedure: randomizedArray
	// parameter: length, a nonnegative integer
	// purpose: to randomize an array of integers with length lengthNum
	// produce: numArray, an array of integer of length lengthNum
	// pre-conditions: lengthNum is nonnegative integer
	// post-conditions: numArray is nonempty
	// * numArray's length = lengthNum
	public static int[] randomizedArray(int lengthNum) {
		// using rgen as the random number
		Random rgen = r;
		// creates an array of indices
		int[] numArray = new int[lengthNum];
		// creating an array of integers with length lengthNum
		for (int i = 0; i < lengthNum; i++) {
			numArray[i] = i;
		}
		// randomizes the array of integers
		for (int i = 0; i < numArray.length; i++) {
			int randPos = rgen.nextInt(numArray.length);
			int temp = numArray[i];
			numArray[i] = numArray[randPos];
			numArray[randPos] = temp;
		}
		return numArray;
	}

	// procedure: randomizedArray
	// parameter: none
	// purpose: to update the organisms in the population
	// produce: void
	// pre-conditions: this.popArray is nonempty
	// post-conditions:
	// * all organisms are updated in each iteration
	// * if the organism's cooperation probability is 1
	//    * decrement its energy
	//    * increment energy of 8 other random organisms
	// * if the organism reproduces (its energy >=10)
	//    * produces a new offspring organism of same type
	//    * replace a organism with smallest energy in the population in that iteration
	// with the offspring
	public void update() {

		// loop through the whole population
		for (int i = 0; i < this.popArray.size(); i++) {
			// getting the organism at position i
			Organism tempOrg = this.popArray.get(i);
			// update by getting the organism at position i in the arrayList
			tempOrg.update();
			// get the energy of each organism
			// if it can cooperate
			if (tempOrg.getCooperationProbability() == 1.0) {
				// decrement energy
				tempOrg.decrementEnergy();
				// give away energy to 8 other organisms by a loop
				int[] randomIndices = randomizedArray(this.totalOrg);
				int counter = 0, j = 0;
				while (counter < 8) {
					// takes the first 8 indices of randomIndices array that is not equal to i
					// then increments the energies of the organisms at those indices.
					if (randomIndices[j] != i) {
						this.popArray.get(randomIndices[j]).incrementEnergy();
						j++;
					}
					counter++;
				}
			}
			// check if it reproduces
			if (tempOrg.energy >= 10) {
				// initialize an organism with smallest energy as the organism at the first position
				Organism smallestEnergyOrganism = this.popArray.get(0);
				// loop through the whole population to find the smallest energy Organism
				for (int k = 0; k < totalOrg; k++) {
					if (this.popArray.get(k).energy < smallestEnergyOrganism.energy) {
						smallestEnergyOrganism = this.popArray.get(k);
					}
				}
				// reduce energy of the organism that is going to reproduce
				tempOrg.energy = tempOrg.energy - 10;
				// call respective reproduce() method
				Organism babyOrg = tempOrg.reproduce();
				int Ind = this.popArray.indexOf(smallestEnergyOrganism);
				/*
				 * ORIGINAL: choose a random organism to replace
				 * //replace a random organism in the population with our baby Organism int
				 * randomIndex = randomizedArray(this.totalOrg)[0];
				 * this.popArray.set(randomIndex, babyOrg);
				 */
				// replace organism of smallest energy with babyOrg
				this.popArray.set(Ind, babyOrg);
			}

		}
	}

	// procedure: calculateCooperationMean()
	// parameter: none
	// purpose: to calculate the average of the cooperation probabilities of all the
	// organisms in the population.
	// produce: meanCoop, a double
	// pre-conditions: this.popArray is nonempty
	// post-conditions:
	// * 0 <= meanCoop <= 1.
	public double calculateCooperationMean() {
		/*
		 * Traverse through the array, get the coop probability of each organism by
		 * calling getCoopProbability() Divide this number by number of elements (saved
		 * as a field above)
		 */
		double meanCoop = 0.0;
		for (int i = 0; i < this.totalOrg; i++) {
			double Probability = this.popArray.get(i).getCooperationProbability();
			meanCoop = meanCoop + Probability;
		}
		meanCoop = meanCoop / totalOrg;
		return meanCoop;
	}

	// procedure: getPopulationCounts()
	// parameter: none
	// purpose: to return the counts of organisms of each type in the population.
	// produce: counts[], an array of pairs
	// pre-conditions: this.popArray is nonempty
	// post-conditions:
	// * if x is the number of cooperators, counts[0].right = x
	// * if y is the number of defectors, counts[1].right = y
	// * if z is the number of partialCooperators, counts[2].right = z
	public Pair<String, Integer>[] getPopulationCounts() {
		// initialize the count of each type Organism
		int coopCount = 0;
		int defecCount = 0;
		int partCoopCount = 0;
		// declare the array of pairs
		Pair<String, Integer>[] counts = (Pair<String, Integer>[]) new Pair[3];
		// loop through the whole population to get count of each type Organism
		for (int i = 0; i < this.popArray.size(); i++) {
			Organism tempOrg = this.popArray.get(i);
			if (tempOrg.getType().equals("Cooperator")) {
				coopCount++;
			} else if (tempOrg.getType().equals("Defector")) {
				defecCount++;
			} else if (tempOrg.getType().equals("PartialCooperator")) {
				partCoopCount++;
			}
		}
		counts[0] = new Pair<String, Integer>("Cooperator", coopCount);
		counts[1] = new Pair<String, Integer>("Defector", defecCount);
		counts[2] = new Pair<String, Integer>("PartialCooperator", partCoopCount);
		// return the array
		return counts;

	}

	// procedure: printArray
	// parameter: popArray, an array list of Organism
	// purpose: to print the array of Organisms
	// produce: void
	// pre-conditions: popArray is nonempty
	// post-conditions: none
	public void printArray(ArrayList<Organism> popArray) {
		int n = this.popArray.size();
		for (int i = 0; i < n; ++i)
			System.out.println("[" + i + " ] " + this.popArray.get(i).getType() + " " + this.popArray.get(i).energy);
	}
}


