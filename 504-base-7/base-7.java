class Solution {

    public static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num <= 6) {
            if (num == 0) {
                return "0";
            }
            if (num < 0) {
                num = - num;
                negative = true;
            } else {
                return String.valueOf(num);
            }
        }

        int div = num / 7;
        int mod = num % 7;
        sb.append(mod);

        recursiveConvertToBase7(div, sb);
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    private static void recursiveConvertToBase7(int num, StringBuilder sb) {
        if (num != 0) {
            int div = num / 7;
            int mod = num % 7;
            sb.append(mod);
            recursiveConvertToBase7(div, sb);
        }
    }
}