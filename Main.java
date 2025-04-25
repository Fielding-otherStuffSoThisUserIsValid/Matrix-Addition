/*
Fielding Parsons
add matrices
April 24 2025
Matrix addition
CSCI 2251 R01
*/
/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		System.out.println();
		
		int[][] matrix1 =  {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		int[][] matrix2 = {
			{9, 8, 7},
			{6, 5, 4},
			{3, 2, 1}
		};
		
		//if matrix names change when we're using the actual matrices, change the names here.
		ThreadOperation UpperLeftThreadOperation = new ThreadOperation(matrix1, matrix2, Quadrant.UPPER_LEFT);
		ThreadOperation UpperRightThreadOperation = new ThreadOperation(matrix1, matrix2, Quadrant.UPPER_RIGHT);
		ThreadOperation LowerLeftThreadOperation = new ThreadOperation(matrix1, matrix2, Quadrant.LOWER_LEFT);
		ThreadOperation LowerRightThreadOperation = new ThreadOperation(matrix1, matrix2, Quadrant.LOWER_RIGHT);
		
		UpperLeftThreadOperation.start();
		UpperRightThreadOperation.start();
		LowerLeftThreadOperation.start();
		LowerRightThreadOperation.start();
		
		try {
			UpperLeftThreadOperation.join();
			UpperRightThreadOperation.join();
			LowerLeftThreadOperation.join();
			LowerRightThreadOperation.join();
		} catch (InterruptedException e) {
			System.out.println("There was an InterruptedException: \n");
			e.printStackTrace();
		}
		
	}
	
	public static void print2dArray(int[][] matrix) {
		
	}
}