import java.util.ArrayList;
import java.util.Random;

public class Population {
	// tick field
	// number of each organism 
	// field for array of the population 
	
	// Fields
	static Random r = new Random();
	int ticks;
	int numberCoop;
	int numberDefect;
	int numberPartcoop;
	protected int totalOrg;
	protected ArrayList<Organism> popArray;

	public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
		 
		/*
		 * Store all the organisms in an array of pairs
		 * array's length is the total number of organisms
		 * the first element of eac pair is the strinng
		 * second element is the object
		 * 
		 */
		this.numberCoop = counts[0].right;
		this.numberDefect = counts[1].right;
		this.numberPartcoop = counts[2].right;
		this.totalOrg = this.numberCoop + this.numberDefect + this.numberPartcoop;
		this.ticks = 0;
		
		this.popArray = new ArrayList<Organism>();
		
		//create an arrayList of pairs
		//List<Pair<String, Organism>> popArray = new ArrayList<>();
		//Pair<String, Organism> dummies = new Pair<>("Cooperator", new Cooperator());
		//popArray.add(dummies);
		
		//System.out.println(popArray.get(0).left);
		/*for (int i = 0; i < numbercoop; i++) {
			
			Pop[i] = Pair("cooperator", new Cooperator());
		}*/
		
		// for loop to initialize the organisms in population
		for (int i = 0; i < totalOrg ; i++) {
			// the first numberCoop organisms are Cooperators
			if (i < this.numberCoop) {
				popArray.add(new Cooperator());
			} // else they are defectors
			else if (i < (this.numberCoop+ this.numberDefect)) {
				popArray.add(new Defector());
			}
			else {
				popArray.add(new PartialCooperator());
			}
		}
		
		
	}
	// method to shuffle an array of indices
	public static int[] RandomizedArray(int length) {
		Random rgen = new Random();
		
		//creates an array of indices 
		int[] array = new int[length];
		
		for (int i = 0; i < length ; i++) {
			array[i] = i;
		}
		
		//randomizes the array of indices
		for (int i = 0 ; i < array.length ; i++) {
			int randPos = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randPos];
			array[randPos] = temp;
		}
		return array;
	}
	public void update() {
		// loop through the whole population (so the array of three pairs)
		// check  to see if each organism will cooprate as describe
		// check if they reproduce
		
		for (int i = 0; i < this.popArray.size() ; i++) {
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
				int[] randomIndices = RandomizedArray(this.totalOrg);
				int counter = 0, j  = 0;
				while (counter < 8) {
					//takes 8 'random' indices, then increments the energies of the organisms at those indices.
					if (randomIndices[j] != i)
					{
					this.popArray.get(randomIndices[j]).incrementEnergy();
					j++;
					}
					counter++;
				}
			}
			
			if (tempOrg.energy >= 10) {
				//reduce energy
				tempOrg.energy = tempOrg.energy - 10;
				//call respective reproduce() method
				Organism babyOrg = tempOrg.reproduce();
				
				//replace a random organism in the population with our baby Organism
				int randomIndex = RandomizedArray(this.totalOrg)[0];
				this.popArray.set(randomIndex, babyOrg); 
				
			}
			
			// check to see if they reproduce
			/*
			if (tempOrg.energy >= 10) {
				//reduce energy because organism is tired after reproducing
				tempOrg.energy = tempOrg.energy - 10;
				Organism babyOrg = new Organism();
				//create new organism, depending on type of parent organism
				if (tempOrg.getType() == "Cooperator") {
					babyOrg = new Cooperator();
				}
				else if (tempOrg.getType() == "Defector") {
					babyOrg = new Defector();
				}
				else if (tempOrg.getType() == "PartialCooperator") {
					babyOrg = new PartialCooperator();
				}
				
				//replace a random organism in the population with our baby Organism
				int randomIndex = RandomizedArray(this.totalOrg)[0];
				this.popArray.set(randomIndex, babyOrg); 
			}
			*/
		}
	}
	
	public double calculateCooperationMean() {
		/*
		 * Traverse through the array, get the coop probability of each organism by 
		 * calling getCoopProbability()
		 * Divide this number by number of elements (saved as a field above)
		 */
		double meanCoop = 0.0;
		for (int i = 0; i < this.totalOrg; i++) {
			double Probability = this.popArray.get(i).getCooperationProbability();
			meanCoop = meanCoop + Probability;
		}
		meanCoop = meanCoop / totalOrg;
		return meanCoop;	
	}
	
	public Pair<String, Integer>[] getPopulationCounts() {
		// return the array of pairs [Organism, count]
		/*
		 * Coop : 10
		 * Defector: 15
		 */
		int coopCount = 0;
		int defecCount = 0;
		int partCoopCount = 0;
		
		
		Pair<String, Integer>[] counts = (Pair<String, Integer>[]) new Pair[3];
		// why it does not work when we use == to compare two strings
		for (int i = 0; i < this.popArray.size() ; i++) {
			
			Organism tempOrg = this.popArray.get(i);
			
			if (tempOrg.getType().equals("Cooperator")) {
				coopCount++;
			}
			else if (tempOrg.getType().equals("Defector")) {
				defecCount++;
			}
			else if (tempOrg.getType().equals("PartialCooperator")) {
				partCoopCount++;
			}
		}
		
		counts[0] = new Pair<String, Integer> ("Cooperator", coopCount);
		counts[1] = new Pair<String, Integer> ("Defector", defecCount);
		counts[2] = new Pair<String, Integer> ("PartialCooperator", partCoopCount);
		
		
		// why does this give nullpointer exception error
		/*
		counts[0].left = "Cooperator";
		counts[0].right = coopCount;
		
		counts[0].left = "Defector";
		counts[0].right = defecCount;
		
		counts[0].left = "PartialCooperator";
		counts[0].right = partCoopCount;
		*/
		
		return counts;
	
	}

}
