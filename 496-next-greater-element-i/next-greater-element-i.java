class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            int element = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (element == nums2[j]) {
                    int k = j;
                    while (k < nums2.length) {
                        if (nums2[k] > element) {
                            ans[i] = nums2[k];
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}