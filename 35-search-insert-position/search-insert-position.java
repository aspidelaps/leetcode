class Solution {
    public static int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        if (target < nums[nums.length - 1]) {
            int rightI = nums.length - 1;
            int leftI = 0;


            while (rightI - leftI > 1) {
                int i = (rightI + leftI) / 2;
                if (target == nums[i]) {
                    return i;
                }
                if (target > nums[i]) {
                    leftI = i;
                } else {
                    rightI = i;
                }
            }

            if (target < nums[rightI]) {
                return rightI;
            } else {
                return leftI;
            }
        } else {
            if (target == nums[nums.length - 1]) {
                return nums.length - 1;
            }
            return nums.length;
        }
    }
}