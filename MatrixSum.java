import java.util.*;
public class MatrixSum
{
	
    private static int maxSumRectangle(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int tempSum[][] = new int[m + 1][n];
 
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                tempSum[i + 1][j] = tempSum[i][j] + matrix[i][j];
            }
        }
 
        int maxSum = -1;
        int minSum = Integer.MIN_VALUE;
        int negRow = 0;
        int negCol = 0;
        int rStart = 0;
        int rEnd = 0;
        int cStart = 0;
        int cEnd = 0;
        for (int rowStart = 0; 
             rowStart < m; 
             rowStart++) 
        {
            for (int row = rowStart; row < m; row++) 
            {
                int sum = 0;
                int curColStart = 0;
                for (int col = 0; col < n; col++) 
                {
                    sum += tempSum[row + 1][col] - tempSum[rowStart][col];
                    if (sum < 0) {
                        if (minSum < sum) {
                            minSum = sum;
                            negRow = row;
                            negCol = col;
                        }
                        sum = 0;
                        curColStart = col + 1;
                    }
                    else if (maxSum < sum) 
                    {
                        maxSum = sum;
                        rStart = rowStart;
                        rEnd = row;
                        cStart = curColStart;
                        cEnd = col;
                    }
                }
            }
        }
 
        // prints the indexes of the sub matrix with highest sum
        if (maxSum == -1) {
            System.out.println("Row " + negRow + " to Row " + negRow);
            System.out.println("Column " + negCol + " to Column " + negCol);
        }
        else {
            System.out.println("Row " + rStart + " to Row " + rEnd);
            System.out.println("Column " + cStart + " to Column " + cEnd);
        }
        return maxSum == -1 ? minSum : maxSum;
    }
    
    // test program
	public static void main(String[] args)
	{
		int arr[][] = new int[][] { {   2,  4, -3, -6, -17 },
            						{  11, -6,  3,  1,   2 },
            						{   3,  8, 14, -4,   1 },
            						{  -7, -4,  1,  2,   8 } };

        // Function call
        System.out.println("Max Sum: " + maxSumRectangle(arr));
        System.out.println("Matrix: ");
        System.out.println(Arrays.deepToString(arr));
	}

}
