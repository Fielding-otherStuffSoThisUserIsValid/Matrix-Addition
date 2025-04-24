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
	private enum Quadrant {UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT};
	
	public ThreadOperation(int[][] submatrixOfA, int[][] submatrixOfB, Quadrant) { // for some reason wont let me put enum in here, but doesn't recognize quadrant; research needed
		
	}
	@Override //not sure if i need this, double check
	public void run() {
		return;
	}
}