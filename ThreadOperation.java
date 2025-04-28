/*
Fielding Parsons
add matrices
April 24 2025
Matrix addition
CSCI 2251 R01
*/


public class ThreadOperation extends Thread {
	private int[][] matrixA;
	private int[][] matrixB;
	private int[][] matrixC;
	Quadrant quadrant;
	
	public ThreadOperation(int[][] matrixA, int[][] matrixB, int[][] MatrixC, Quadrant quadrant) { //https://www.geeksforgeeks.org/enum-in-java/
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
		this.quadrant = quadrant;
	}
	
	@Override //not sure if i need this, double check
	public void run() {
		int[] indexes = this.getQuadrantIndexes(this.matrixA.length, this.matrixA[0].length, this.quadrant);
		int rowStart = indexes[0];
		int rowEnd = indexes[1];
		int colStart = indexes[2];
		int colEnd = indexes[3];
		
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
	}
	
	public static int[] getQuadrantIndexes(int rows, int columns, Quadrant quadrant) {
		int rowStart = 0;
		int rowEnd = 0;
		int colStart = 0;
		int colEnd = 0;
		int[] indexes = new int[4];
		
		if (quadrant == Quadrant.UPPER_LEFT) {
			rowStart = 0;
			rowEnd = (int) Math.floor(rows/2 - 1);
			colStart = 0;
			colEnd = (int) Math.floor(columns/2 - 1);
		} else if (quadrant == Quadrant.UPPER_RIGHT) {
			rowStart = 0;
			rowEnd = (int) Math.floor(rows/2 - 1);
			colStart = (int) Math.ceil(columns/2 - 1);
			colEnd = columns - 1;
		} else if (quadrant == Quadrant.LOWER_LEFT) {
			rowStart = (int) Math.ceil(rows/2 - 1);
			rowEnd = rows - 1;
			colStart = 0;
			colEnd = (int) Math.floor(columns/2 - 1);
		} else if (quadrant == Quadrant.LOWER_RIGHT) {
			rowStart = (int) Math.ceil(rows/2 - 1);
			rowEnd = rows - 1;
			colStart = (int) Math.ceil(columns/2 - 1);
			colEnd = columns - 1;
		}
		
		indexes[0] = rowStart;
		indexes[1] = rowEnd;
		indexes[2] = colStart;
		indexes[3] = colEnd;
		
		return indexes;
	}
}