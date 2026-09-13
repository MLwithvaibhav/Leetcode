import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        // Jahan jahan 1 hai, unke (row, col) list me daal lo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) list1.add(new int[]{i, j});
                if (img2[i][j] == 1) list2.add(new int[]{i, j});
            }
        }

        // Map banake har shift ka count store karo
        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;

        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                // Kitna row aur kitna col khiskana pada
                int rShift = p1[0] - p2[0];
                int cShift = p1[1] - p2[1];
                
                String key = rShift + "#" + cShift;
                map.put(key, map.getOrDefault(key, 0) + 1);
                maxOverlap = Math.max(maxOverlap, map.get(key));
            }
        }

        return maxOverlap;
    }
}