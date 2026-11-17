class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder nextRound = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                int end = Math.min(s.length(), i + k);
                for (int j = i; j < end; j++) {
                    // Converts char digit directly to int without Integer.parseInt
                    sum += s.charAt(j) - '0';
                }
                nextRound.append(sum);
            }
            s = nextRound.toString();
        }
        return s;
    }
}
