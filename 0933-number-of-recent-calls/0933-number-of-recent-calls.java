class RecentCounter {
    ArrayList<Integer> list;
    int startIdx;
    public RecentCounter() {
        list = new ArrayList<>();
        startIdx = 0;
        
    }
    
    public int ping(int t) {
        list.add(t);
        while (list.get(startIdx) < t - 3000) {
            startIdx++;
        }
        return list.size() - startIdx;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */