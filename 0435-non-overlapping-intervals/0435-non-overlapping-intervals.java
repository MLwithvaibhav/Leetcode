class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int previous_interval = 0;

        for (int i = 1; i < intervals.length; i++) {

            // Current interval starts after
            // or exactly when the previous one ends
            if (intervals[i][0] >= intervals[previous_interval][1]) {
                previous_interval = i;
                count++;
            }
        }

        // Total intervals - intervals we can keep
        return intervals.length - count;
    }
}