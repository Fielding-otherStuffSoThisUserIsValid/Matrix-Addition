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

A1: Multi-threading can solve problems faster than just using one thread; multicore machines (running a program in parallel) can also solve problems faster, but I believe it is more resource-intenstive than multi-threading, and definitely so if we're not talking exclusivly about computational resoures (for example, it requires more money).
The less time the computer spends devoting resources to solving a problem, the sooner it can divert those resources to other things.
Going back to considering resources outside of computational, time is also a valuable resource, and multiple threads can get the job doen faster than a single thread most of the time.
*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		System.out.println();
		
		//File reading:
		Scanner fileIn = null;
		try {
			if (!args[0].endsWith(".txt")) {
				throw new IOException(); //https://www.geeksforgeeks.org/throw-throws-java/
			}
			File matrixFile = new File(args[0]);
			fileIn = new Scanner(matrixFile);
		} catch (IOException e) {
			System.out.println("There was an IOException, or the file was not a .txt file");
			e.printStackTrace();
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There was an ArrayIndexOutOfBoundsException:");
			e.printStackTrace();
			System.exit(2);
		}
		
		int numOfRows = fileIn.nextInt();
		int numOfCols = fileIn.nextInt();
		
		int[][] matrix1 = createMatrixFromFile(numOfRows, numOfCols, fileIn);
		int[][] matrix2 = createMatrixFromFile(numOfRows, numOfCols, fileIn);;
		int[][] matrix3 = new int[numOfRows][numOfCols];
		
		
		
		ThreadOperation UpperLeftThreadOperation = new ThreadOperation(matrix1, matrix2, matrix3, Quadrant.UPPER_LEFT);
		ThreadOperation UpperRightThreadOperation = new ThreadOperation(matrix1, matrix2, matrix3, Quadrant.UPPER_RIGHT);
		ThreadOperation LowerLeftThreadOperation = new ThreadOperation(matrix1, matrix2, matrix3, Quadrant.LOWER_LEFT);
		ThreadOperation LowerRightThreadOperation = new ThreadOperation(matrix1, matrix2, matrix3, Quadrant.LOWER_RIGHT);
		
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
		
		//TESTING CODE:
		/*print2dArray(matrix1);
		System.out.println();
		print2dArray(matrix2);
		System.out.println();
		System.out.println(numOfRows);
		System.out.println(numOfCols);
		//createMatrixFromFile(numOfRows, numOfCols, fileIn);
		System.out.println();
		//createMatrixFromFile(numOfRows, numOfCols, fileIn);*/
		System.out.println(matrix1.length+" = "+numOfRows);
		System.out.println(matrix1[0].length+" = "+numOfCols);
	}
	
	public static void print2dArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf(matrix[i][j]+" ");
			}
			System.out.printf("\n");
		}
	}
	
	public static int[][] createMatrixFromFile(int numOfRows, int numOfCols, Scanner fileIn) {
		int[][] matrix = new int[numOfRows][numOfCols];
		
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCols; j++) {
				matrix[i][j] = fileIn.nextInt();
			}
		}
		return matrix;
	}
}