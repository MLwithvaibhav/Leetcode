import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Base cases
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        // dp[r][c] stores number of valid paths from empty cell (r, c) to (m - 1, n - 1)
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, m, n, grid, dp);
    }

    private int dfs(int r, int c, int m, int n, int[][] grid, int[][] dp) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        long totalPaths = 0;

        // Choice 1: Move Right (dir = 0)
        int[] nextR = step(r, c + 1, 0, m, n, grid);
        if (nextR != null) {
            totalPaths = (totalPaths + dfs(nextR[0], nextR[1], m, n, grid, dp)) % MOD;
        }

        // Choice 2: Move Down (dir = 1)
        int[] nextD = step(r + 1, c, 1, m, n, grid);
        if (nextD != null) {
            totalPaths = (totalPaths + dfs(nextD[0], nextD[1], m, n, grid, dp)) % MOD;
        }

        return dp[r][c] = (int) totalPaths;
    }

    // Follows reflections until an empty cell (0) is reached or goes out of bounds
    // dir: 0 = moving Right, 1 = moving Down
    private int[] step(int r, int c, int dir, int m, int n, int[][] grid) {
        while (r < m && c < n) {
            if (grid[r][c] == 0) {
                return new int[]{r, c}; // Safely landed on an empty cell
            }
            // Cell is a mirror (1): reflect before entering
            if (dir == 0) {
                // Trying to enter moving Right -> turn Down
                r = r + 1;
                dir = 1;
            } else {
                // Trying to enter moving Down -> turn Right
                c = c + 1;
                dir = 0;
            }
        }
        return null; // Out of bounds
    }
}