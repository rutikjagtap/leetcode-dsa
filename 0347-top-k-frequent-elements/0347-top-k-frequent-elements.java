class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            set.add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) -map.get(a));
        for(int s: set){
            pq.offer(s);
        }
        int arr[] = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = pq.poll();
        }
        return arr;
    }
}