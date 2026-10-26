class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Jodi positive integer hoy ebong age visit na hoye thake
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long sum = dfs(grid, visited, i, j, m, n);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited, int r, int c, int m, int n) {
        // Boundary ebong condition check
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        long currentSum = grid[r][c];

        // 4-directional traversal (up, down, left, right)
        currentSum += dfs(grid, visited, r + 1, c, m, n);
        currentSum += dfs(grid, visited, r - 1, c, m, n);
        currentSum += dfs(grid, visited, r, c + 1, m, n);
        currentSum += dfs(grid, visited, r, c - 1, m, n);

        return currentSum;
    }
}