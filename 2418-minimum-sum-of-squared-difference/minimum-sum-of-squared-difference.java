
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long k = (long) k1 + k2;
        long sum = 0;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        if (k >= sum) {
            return 0;
        }
        int low = 0, high = maxDiff;
        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;
            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }
            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int level = low;
        long remaining = k;
        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                remaining -= diff[i] - level;
                diff[i] = level;
            }
        }
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level) {
                diff[i]--;
                remaining--;
            }
        }
        long answer = 0;
        for (int d : diff) {
            answer += (long) d * d;
        }
        return answer;
    }
}

