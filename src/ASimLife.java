import java.io.PrintWriter;
import java.util.ArrayList;

// Driver class to test our program
public class ASimLife {

  public static void main(String[] args) {
    // create an array of pairs, each pair is an organism and Integer
    @SuppressWarnings({"unchecked"})
    Pair<String, Integer>[] counts = (Pair<String, Integer>[]) new Pair[3];

    // Put information into the array
    counts[0] = new Pair<String, Integer>("Cooperator", Integer.valueOf(args[1]));
    counts[1] = new Pair<String, Integer>("Defector", Integer.valueOf(args[2]));
    counts[2] = new Pair<String, Integer>("PartialCooperator", Integer.valueOf(args[3]));

    // create the population object
    Population pop = new Population(counts);
    // update the whole population ticks number of times
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
      pop.update();
    }
    // creating an array of pairs that return the number of each organism
    Pair<String, Integer>[] results = pop.getPopulationCounts();

    PrintWriter pen = new PrintWriter(System.out, true);
    // printing out the result
    pen.println("After " + args[0] + " iterations:");
    pen.println(results[0].left + " : " + results[0].right);
    pen.println(results[1].left + " : " + results[1].right);
    pen.println(results[2].left + " : " + results[2].right);
    
    pen.println("Mean Cooperation Probability: " + pop.calculateCooperationMean());
  }

}
