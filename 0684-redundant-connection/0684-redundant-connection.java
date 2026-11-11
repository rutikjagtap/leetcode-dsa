class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            boolean[] visited = new boolean[n + 1];
            if (dfs(u, v, adj, visited)) {
                return new int[]{u, v};
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    public boolean dfs(int curr, int target,List<List<Integer>> adj,boolean[] visited) {
        if (curr == target) {
            return true;
        }
        visited[curr] = true;
        for (int child : adj.get(curr)) {
            if (!visited[child]) {
                if (dfs(child, target, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
