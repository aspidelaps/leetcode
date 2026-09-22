class Solution {
    public static int lengthOfLastWord(String s) {
        int result = 0;
        String reversed = new StringBuilder(s).reverse().toString();
        for (char c : reversed.toCharArray()) {
            if (result == 0) {
                if (c != ' ') {
                    result++;
                }
            } else {
                if (c == ' ') {
                    break;
                }
                result++;
            }
        }
        return result;
    }
}