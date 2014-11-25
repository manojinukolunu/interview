package cracking.the.coding.interview.chapter9;

public class Prob92 {
	public static int solution(int x, int y) {
		int[][] grid = new int[x + 1][y + 1];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grid[i][j] = 1; // The mininum number of ways to get to
								// gird[x][y]
			}
		}
		return numPaths(x, y, grid);
	}
	private static int numPaths(int x, int y, int[][] grid) {
		if ((x == 0) || (y == 0)) {
			return 1;
		}
		if (grid[x][y] > 0) {
			return grid[x][y];
		} else {
			grid[x][y] = numPaths(x - 1, y, grid) + numPaths(x, y - 1, grid);
			return grid[x][y];
		}

	}

	public static void main(String args[]) {
		System.out.println(solution(3, 3));
	}
}
