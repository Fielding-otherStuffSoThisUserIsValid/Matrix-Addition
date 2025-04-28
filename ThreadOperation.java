/*
Fielding Parsons
add matrices
April 24 2025
Matrix addition
CSCI 2251 R01
*/


public class ThreadOperation extends Thread {
	private int[][] submatrixOfA;
	private int[][] submatrixOfB;
	Quadrant quadrant;
	
	public ThreadOperation(int[][] submatrixOfA, int[][] submatrixOfB, Quadrant quadrant) { //https://www.geeksforgeeks.org/enum-in-java/
		this.submatrixOfA = submatrixOfA;
		this.submatrixOfB = submatrixOfB;
		this.quadrant = quadrant;
	}
	
	@Override //not sure if i need this, double check
	public void run() {
		return;
	}
	
	public static int[] getQuadrantIndexes(int rows, int columns, Quadrant quadrant) {
		int rowStart;
		int rowEnd;
		int colStart;
		int colEnd;
		
		if (quadrant == Quadrant.UPPER_LEFT) {
			rowStart = 0;
			rowEnd = (int) Math.floor(rows/2);
		} else if (quadrant == Quadrant.UPPER_RIGHT) {
			rowStart = 0;
			
		}
		return null;
	}
}