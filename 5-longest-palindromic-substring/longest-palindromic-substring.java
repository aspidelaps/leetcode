class Solution {
    public String longestPalindrome(String s) {
        Manacher mob = new Manacher(s);
        int n = s.length();

        // maximum length found so far
        int maxLen = 1;

        // starting index of longest palindrome
        int bestStart = 0;

        for (int i = 0; i < n; i++) {

            // check for odd-length palindrome centered at i
            int oddLen = mob.getLongest(i, 1);
            if (oddLen > maxLen) {
                maxLen = oddLen;
                bestStart = i - maxLen / 2;
            }

            // check for even-length palindrome centered
            // between i and i+1
            int evenLen = mob.getLongest(i, 0);
            if (evenLen > maxLen) {
                maxLen = evenLen;
                bestStart = i - maxLen / 2 + 1;
            }
        }

        // extract the longest palindromic substring
        return s.substring(bestStart, bestStart + maxLen);
    }
}

class Manacher {
    // p[i] = radius of longest palindrome centered at i
    // in transformed string
    int[] p;

    // transformed string with # and sentinels
    String ms;

    // preprocess the string and run the algorithm
    Manacher(String s) {
        // left sentinel
        ms = "@";
        for (char c : s.toCharArray()) {
            ms += "#" + c;
        }
        // right sentinel
        ms += "#$";

        // run Manacher’s algorithm
        runManacher();
    }

    void runManacher() {
        int n = ms.length();
        p = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n - 1; ++i) {
            // mirror of i around center (l + r)/2
            int mirror = l + r - i;

            // initialize p[i] based on its mirror
            // if within bounds
            if (i < r)
                p[i] = Math.min(r - i, p[mirror]);

            // expand palindrome centered at i
            while (ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i])) {
                ++p[i];
            }

            // update [l, r] if the palindrome expands
            // beyond current r
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
    }

    // returns length of longest palindrome centered
    // at 'cen' in original string
    // 'odd' = 1 → check for odd-length, 'odd' = 0 → even-length
    int getLongest(int cen, int odd) {
        // map original index to transformed string index
        int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
        return p[pos];
    }

    // checks if s[l..r] is a palindrome in O(1)
    boolean check(int l, int r) {
        int len = r - l + 1;
        int cen = (l + r) / 2;
        return len <= getLongest(cen, len % 2);
    }
}