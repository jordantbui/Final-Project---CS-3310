import java.lang.*;
import java.util.Random;

public class LargestSum
{
	// Finds largest contiguous sum in an array
	static int largestCSum(int num[])
    {  
        int maxSoFar = num[0];
        int maxEndingHere = 0; 
  
        for (int i = 1; i < num.length; i++) 
        { 
            maxEndingHere = Math.max(maxEndingHere + num[i], num[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        } 
        return maxSoFar; 
    }
	
	// Test program
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		int test[] = {2, -8, 3, -2, 4, -10};
		System.out.println("Test Array");
		for (int i=0; i<test.length; i++)
        {
            System.out.print(test[i] + " ");
        }
        System.out.println();
		System.out.println("Max Contiguous Sum is " + largestCSum(test));
		
		int nums10[] = new int[10];
        System.out.println("Array Size 10");
        for (int i = 0; i < nums10.length; i++)
        {
        	nums10[i] = rand.nextInt(10);
        }
        for (int i=0; i<nums10.length; i++)
        {
            System.out.print(nums10[i] + " ");
        }
        System.out.println();
        System.out.println("Max Contiguous Sum is " + largestCSum(nums10));
	}

}
