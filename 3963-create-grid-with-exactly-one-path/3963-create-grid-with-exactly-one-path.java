class Solution {
    public String[] createGrid(int m, int n) {
        // Final answer store karne ke liye array banaya size m ka
        String[] grid = new String[m];
        
        // Loop 1: Row 0 se lekar second-last row (m - 2) tak
        for (int i = 0; i < m - 1; i++) {
            StringBuilder sb = new StringBuilder();
            
            // First cell hamesha path ka hissa hoga
            sb.append('.');
            
            // Baaki saari columns ko block kar do '#' se
            for (int j = 1; j < n; j++) {
                sb.append('#');
            }
            
            grid[i] = sb.toString();
        }
        
        // Loop 2: Aakhri row (m - 1) banate hain
        // Yahan se seedha right jana hai, toh saare cells '.' honge
        StringBuilder lastRow = new StringBuilder();
        for (int j = 0; j < n; j++) {
            lastRow.append('.');
        }
        grid[m - 1] = lastRow.toString();
        
        // Final grid return kar do
        return grid;
    }
}