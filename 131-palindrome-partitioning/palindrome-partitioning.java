class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partial = new ArrayList<>();
        helper(s, 0, ans, partial);
        return ans;
    }

    public void helper(String s, int index,List<List<String>> ans,List<String> partial) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(partial));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (palindrome(s, index, i)) {
                partial.add(s.substring(index, i + 1));
                helper(s, i + 1, ans, partial);
                partial.remove(partial.size() - 1);
            }
        }
    }
    public boolean palindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}