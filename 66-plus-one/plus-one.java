import java.math.BigInteger; 

class Solution {
    public int[] plusOne(int[] digits) {

        reverse(digits);
        BigInteger  multiplier = new BigInteger("1");
        BigInteger  result = new BigInteger("0");
        for (int i : digits) {
            result = result.add(multiplier.multiply(new BigInteger(String.valueOf(i))));
            multiplier = multiplier.multiply(new BigInteger("10"));
        }
        result = result.add(new BigInteger("1"));

        return result.toString()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move pointers toward the center
            start++;
            end--;
        }
    }
}