class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int keyIndex = (nums1.length + nums2.length) / 2;
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        int i = 0;
        int n = 0;
        int m = 0;
        double keyElement = Integer.MIN_VALUE;
        double subElement = Integer.MIN_VALUE;
        int nElement = Integer.MAX_VALUE;
        int mElement = Integer.MAX_VALUE;
        if (nums1.length > 0) {
            nElement = nums1[n];
        }
        if (nums2.length > 0) {
            mElement = nums2[m];
        }
        while (i <= keyIndex) {
            subElement = keyElement;
            if (nElement < mElement) {
                keyElement = nElement;
                if (n+1 >= nums1.length) nElement = Integer.MAX_VALUE;
                else nElement = nums1[++n];
            } else {
                keyElement = mElement;
                if (m+1 >= nums2.length) mElement = Integer.MAX_VALUE;
                else mElement = nums2[++m];
            }
            i++;
        }

        if (even) {
            return (keyElement + subElement) / 2;
        } else return keyElement;
    }
}