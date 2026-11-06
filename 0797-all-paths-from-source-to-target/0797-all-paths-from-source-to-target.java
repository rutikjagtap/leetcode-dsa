class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> twod = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0,graph.length -1,graph,twod,result);
        return twod;
    }
    public void dfs(int node,int target,int[][] graph,List<List<Integer>> twod, ArrayList<Integer> result){
        result.add(node);
        if(node == target){
            twod.add(new ArrayList<>(result));
        }
        else{
            for(int child : graph[node]){
                dfs(child,target,graph,twod,result);
            }
        }
        result.remove(result.size()-1);
    }
}