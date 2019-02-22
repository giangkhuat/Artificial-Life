import java.util.ArrayList;
import java.util.Collections;

/*
 * Taken from https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort {
  // Fields
  public ArrayList<Organism> popArray;

  // Constructor
  public InsertionSort(ArrayList<Organism> popArray) {
    this.popArray = popArray;
  }

  /* Function to sort array using insertion sort */
  public void sort() {
    // n is the number of elements in the population array
    int n = this.popArray.size();
    for (int i = 1; i < n; ++i) {
      Organism tempOrg = this.popArray.get(i);
      int j = i - 1;

      /*
       * Move elements of arr[0..i-1], that are greater than key, to one position ahead of their
       * current position
       */
      while (j >= 0 && this.popArray.get(j).energy > tempOrg.energy) {
        // set the organism at position
        this.popArray.set(j + 1, this.popArray.get(j));
        j = j - 1;
      }
      this.popArray.set(j+1, tempOrg);
    }
  }

  /* A utility function to print array of size n */
  public void printArray(ArrayList<Organism> popArray) {
    int n = this.popArray.size();
    for (int i = 0; i < n; ++i)
      System.out.println("[" + i + " ] " + this.popArray.get(i).getType() + " " + this.popArray.get(i).energy);
  }

  // Driver method
  /*
   * public static void main(String args[]) { int arr[] = {12, 11, 13, 5, 6};
   * 
   * InsertionSort ob = new InsertionSort(); ob.sort(arr);
   * 
   * printArray(arr); }
   */
} /* This code is contributed by Rajat Mishra. */
