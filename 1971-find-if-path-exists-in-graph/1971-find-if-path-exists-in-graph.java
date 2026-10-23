class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> twod = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            twod.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u =edges[i][0];
            int v =edges[i][1];
            twod.get(u).add(v);
            twod.get(v).add(u);
        }
        return dfs(source,destination,twod,visited);
    }
    public boolean dfs(int source,int destination, List<List<Integer>> twod,boolean[] visited){
        if(source == destination){
            return true;
        }
        visited[source] = true;
        for(int child : twod.get(source)){
            if(!visited[child]){
                if(dfs(child,destination,twod,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}