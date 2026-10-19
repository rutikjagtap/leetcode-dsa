class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if(i< n){
                if(st.isEmpty()){
                    arr[i] = -1;
                }
                else{
                    arr[i] = st.peek();
                }
            }
            st.push(nums[i % n]);
        }
        return arr;
    }
}