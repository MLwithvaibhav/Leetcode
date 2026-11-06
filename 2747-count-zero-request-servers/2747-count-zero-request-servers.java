import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;
        int[][] orderedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            orderedQueries[i][0] = queries[i];
            orderedQueries[i][1] = i;
        }
        Arrays.sort(orderedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[m];
        int[] requestCounts = new int[n + 1];
        int activeServers = 0;
        int left = 0, right = 0;

        for (int[] query : orderedQueries) {
            int endTime = query[0];
            int startTime = endTime - x;

            while (right < logs.length && logs[right][1] <= endTime) {
                int server = logs[right][0];
                if (requestCounts[server]++ == 0) activeServers++;
                right++;
            }

            while (left < right && logs[left][1] < startTime) {
                int server = logs[left][0];
                if (--requestCounts[server] == 0) activeServers--;
                left++;
            }

            answer[query[1]] = n - activeServers;
        }

        return answer;
    }
}