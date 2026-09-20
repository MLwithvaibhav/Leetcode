class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Interval i: [start1, end1]
                int start1 = intervals[i][0];
                int end1 = intervals[i][1];

                // Interval j: [start2, end2]
                int start2 = intervals[j][0];
                int end2 = intervals[j][1];

                // Check intersection
                if (Math.max(start1, start2) <= Math.min(end1, end2)) {
                    count++;
                }
            }
        }

        return count;
    }
}