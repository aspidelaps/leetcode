class Solution {
    public long maxAlternatingSum(int[] nums) {
        long result = 0;
        if (nums.length == 1) {
            return nums[0] * nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length/2; i++) {
            int number = nums[i];
            result -= number;
        }
        for (int i = nums.length/2; i < nums.length; i++) {
            int number = nums[i];
            result += number;
        }
        return result;
    }
}