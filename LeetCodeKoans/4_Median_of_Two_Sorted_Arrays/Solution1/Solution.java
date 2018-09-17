
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Solution 1
        // Merge first and then get median
        // Not the best

        int[] both = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, both, nums1.length, nums2.length);

        Arrays.sort(both);
        double result = 0.0;
        int length = nums1.length + nums2.length;

        if (length % 2 == 0) {
            result = (both[length / 2] + both[(length - 1) / 2]) / 2.0;
        } else {
            result = both[length / 2];
        }

        return result;
    }
}
