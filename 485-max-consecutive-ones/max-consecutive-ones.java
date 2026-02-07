class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                count++;
                if (i == length - 1) {
                    if (count > result) {
                        result = count;
                    }
                }
            } else {
                if (count > result) {
                    result = count;
                }
                count = 0;
            }
        }
        return result;
    }
}