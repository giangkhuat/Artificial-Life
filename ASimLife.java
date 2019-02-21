import java.io.PrintWriter;

public class ASimLife{

	public static void main (String[] args) {
		
		@SuppressWarnings({"unchecked"})
	    Pair<String, Integer>[] counts = (Pair<String, Integer>[]) new Pair[3];
		
		
		counts[0] = new Pair<String, Integer> ("Cooperator", Integer.valueOf(args[1]));
		counts[1] = new Pair<String, Integer> ("Defector", Integer.valueOf(args[2]));
		counts[2] = new Pair<String, Integer> ("PartialCooperator", Integer.valueOf(args[3]));
		
		
		/*
		 * Pair<String, Integer> p1 = new Pair<String, Integer> ("Cooperator",
		 * Integer.valueOf(args[1])); Pair<String, Integer> p2 = new Pair<String,
		 * Integer> ("Defector", Integer.valueOf(args[2])); Pair<String, Integer> p3 =
		 * new Pair<String, Integer> ("PartialCooperator", Integer.valueOf(args[3]));
		 */
		
		//Pair<String, Integer>[] counts = (Pair<String, Integer>[]) new Pair<>[](p1, p2, p3);
		/*
		 * String str = "Cooperator"; counts[0].left = str; counts[0].right =
		 * Integer.parseInt(args[1]);
		 * 
		 * String str2 = "Defector"; counts[1].left = str2; counts[1].right =
		 * Integer.parseInt(args[2]);
		 * 
		 * String str3 = "PartialCooperator"; counts[2].left = str3; counts[2].right =
		 * Integer.parseInt(args[3]);
		 */
		
		Population pop = new Population(counts);
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			pop.update();
		}
		
		Pair<String, Integer>[] results = pop.getPopulationCounts();
		
		PrintWriter pen = new PrintWriter(System.out, true);
		
		pen.println("After " + args[0] + " iterations:");
		pen.println(results[0].left + " : " + results[0].right);
		pen.println(results[1].left + " : " + results[1].right);
		pen.println(results[2].left + " : " + results[2].right);
		
	}
	
}
