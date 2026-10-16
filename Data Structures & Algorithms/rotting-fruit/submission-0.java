public class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0, time = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) fresh++;
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (fresh > 0) {
            boolean flag = false;
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (grid[r][c] == 2) {
                        for (int[] d : directions) {
                            int row = r + d[0], col = c + d[1];
                            if (row >= 0 && col >= 0 &&
                                row < ROWS && col < COLS &&
                                grid[row][col] == 1) {
                                grid[row][col] = 3;
                                fresh--;
                                flag = true;
                            }
                        }
                    }
                }
            }

            if (!flag) return -1;

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (grid[r][c] == 3) grid[r][c] = 2;
                }
            }

            time++;
        }

        return time;
    }
}