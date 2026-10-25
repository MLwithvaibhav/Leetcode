class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Step 1: Boundary se connected saare land (0s) ko eliminate (flood-fill) karo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Agar cell boundary pe hai aur land (0) hai
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 0) {
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        // Step 2: Inner grid me bache hue closed islands count karo
        int closedIslandsCount = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    closedIslandsCount++;
                    dfs(grid, i, j, m, n); // pura island visit mark (1) kar do
                }
            }
        }
        
        return closedIslandsCount;
    }
    
    private void dfs(int[][] grid, int r, int c, int m, int n) {
        // Out of bounds check ya fir already water (1)
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
            return;
        }
        
        // Visited mark karne ke liye 0 ko 1 bana do (in-place modification)
        grid[r][c] = 1;
        
        // 4-directional moves (up, down, left, right)
        dfs(grid, r + 1, c, m, n);
        dfs(grid, r - 1, c, m, n);
        dfs(grid, r, c + 1, m, n);
        dfs(grid, r, c - 1, m, n);
    }
}