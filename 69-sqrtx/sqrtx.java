class Solution {

    public static int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        if (x <= 100) {
            if (x == 100) {
                return 10;
            }
            return calculateKvadrat(1, 99, x);
        }

        if (x <= 10000) {
            if (x == 10000) {
                return 100;
            }
            return calculateKvadrat(10, 9999, x);
        }

        long right = Integer.MAX_VALUE;
        long left = 101;
        long mid = 0;
        while ((right - left) > 1) {
            mid = (left + right) / 2L;
            long longMid = mid;
            long kvadrat = longMid * longMid;
            if (kvadrat == x) {
                return (int) mid;
            }
            if (kvadrat > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right*right > x) {
            return (int) left;
        } else return (int) right;
    }

    private static int calculateKvadrat(int start, int max, int x) {
        int result = 0;
        for (int i = start; i <= max; i++) {
            int kvadrat = i * i;
            if (kvadrat == x) {
                return i;
            }
            if (kvadrat > x) {
                return i - 1;
            }
            result = i;
        }
        return result;
    }
}