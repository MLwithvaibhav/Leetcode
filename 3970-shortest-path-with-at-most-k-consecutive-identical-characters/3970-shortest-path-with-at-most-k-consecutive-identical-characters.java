import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> List of {v, weight}
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        // dist[u][cnt]: minimum weight to reach node u with run-length 'cnt'
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // PriorityQueue stores: {distance, node, consecutive_count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Base state: at node 0, run length is 1, distance is 0
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int cnt = curr[2];

            // Reached destination with smallest distance
            if (u == n - 1) {
                return d;
            }

            // Stale state
            if (d > dist[u][cnt]) {
                continue;
            }

            char uLabel = labels.charAt(u);

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                char vLabel = labels.charAt(v);

                // Determine next consecutive count
                int nextCnt = (vLabel == uLabel) ? cnt + 1 : 1;

                if (nextCnt <= k) {
                    int nextDist = d + w;
                    if (nextDist < dist[v][nextCnt]) {
                        dist[v][nextCnt] = nextDist;
                        pq.offer(new int[]{nextDist, v, nextCnt});
                    }
                }
            }
        }

        return -1;
    }
}