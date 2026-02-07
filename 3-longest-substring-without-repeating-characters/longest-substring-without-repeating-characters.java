class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int i = 0;
        int result = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }
}