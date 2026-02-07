class Solution {
    public int[] findErrorNums(int[] nums) {

        int twice = 0;
        int missing = 0;
        int total = (nums.length * (nums.length + 1)) / 2;
        
        Set<Integer> duplicate = new HashSet<Integer>();
        for (int i : nums) {
            if (duplicate.contains(i)) {
                twice = i;
                total = total - twice;
            }
            duplicate.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != twice) {
                total = total - nums[i];
            }
        }
        missing = total;
        return new int[] { twice, missing };
    }
}