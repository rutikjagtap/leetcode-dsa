class Solution {
    class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int first() {
            return map.firstKey();
        }

        int last() {
            return map.lastKey();
        }
    }
    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        MultiSet low = new MultiSet();
        MultiSet high = new MultiSet();

        long[] cost = new long[n - x + 1];

        // Step 1: Sliding Window + Median

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            if (low.size == 0 || val <= low.last()) {
                low.add(val);
            } else {
                high.add(val);
            }

            // Remove outgoing element
            if (i >= x) {
                int removeVal = nums[i - x];

                if (low.map.containsKey(removeVal)) {
                    low.remove(removeVal);
                } else {
                    high.remove(removeVal);
                }
            }

            // Balance both halves
            while (low.size > high.size + 1) {
                int move = low.last();
                low.remove(move);
                high.add(move);
            }

            while (low.size < high.size) {
                int move = high.first();
                high.remove(move);
                low.add(move);
            }

            // Calculate window cost
            if (i >= x - 1) {

                long median = low.last();

                long leftCost =
                    median * low.size - low.sum;

                long rightCost =
                    high.sum - median * high.size;

                cost[i - x + 1] =
                    leftCost + rightCost;
            }
        }

        // Step 2: Dynamic Programming

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {

            dp[j][n] = INF;

            for (int i = n - 1; i >= 0; i--) {

                // Option 1: Skip current index
                long skip = dp[j][i + 1];

                // Option 2: Select window
                long take = INF;

                if (i + x <= n) {
                    take = cost[i] + dp[j - 1][i + x];
                }

                dp[j][i] = Math.min(skip, take);
            }
        }
        return dp[k][0];
    }
}
