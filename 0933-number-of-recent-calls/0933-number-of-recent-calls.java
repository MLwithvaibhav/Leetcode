class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        this.requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add new request timestamp
        requests.offer(t);

        // Remove older requests outside the 3000ms window
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the number of requests in the window
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */