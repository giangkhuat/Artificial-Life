import java.util.ArrayList;
import java.util.Collections;

/*
 * Taken from https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort 
{ 
  //Fields
  public ArrayList<Organism> popArray;
    // Constructor
  public InsertionSort(ArrayList<Organism> popArray) {
    this.popArray = popArray;
  }
    /*Function to sort array using insertion sort*/
   public void sort(this.popArray) 
    { 
     // n is the number of elements in the population array
        int n = this.popArray.size(); 
        for (int i=1; i<n; ++i) 
        { 
            int key = this.popArray.get(i); 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && this.popArray.get(j) > tempOrg) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
  
    /* A utility function to print array of size n*/
   public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    {         
        int arr[] = {12, 11, 13, 5, 6}; 
  
        InsertionSort ob = new InsertionSort();         
        ob.sort(arr); 
          
        printArray(arr); 
    } 
} /* This code is contributed by Rajat Mishra. */
