class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            for (int l = i + 1; l < nums.length; l++) {
                if (k + nums[l] == target) {
                    return new int[]{i, l};
                }
            }
        }
        return null;
    }
}