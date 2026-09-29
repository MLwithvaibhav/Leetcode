class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Path length is m + n - 1. Must be even to form valid parentheses pairs.
        if ((m + n - 1) % 2 != 0) return false;

        // Starting must be '(' and ending must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        // Max possible balance cannot exceed (m + n) / 2
        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        // Update balance for current cell
        balance += (grid[r][c] == '(' ? 1 : -1);

        // Invalid if balance drops below 0
        if (balance < 0) return false;

        // Prune: cannot close all brackets even if all remaining cells are ')'
        int remainingSteps = (m - 1 - r) + (n - 1 - c);
        if (balance > remainingSteps) return false;

        // Reached destination
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return cached result if already visited
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, balance);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, balance);
        }

        return memo[r][c][balance] = found;
    }
}