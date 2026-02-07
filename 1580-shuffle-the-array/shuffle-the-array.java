class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int j = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                result[i] = nums[j];
                j++;
            } else {
                result[i] = nums[n+j-1];
            }
            
        }
        return result;
    }
}