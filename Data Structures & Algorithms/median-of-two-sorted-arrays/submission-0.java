class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int total = n1 + n2;
        int len = total / 2;

        int p1 = 0, p2 = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i <= len; i++) {

            prev = curr;

            if (p1 < n1 && p2 < n2) {

                if (nums1[p1] < nums2[p2]) {
                    curr = nums1[p1++];
                } else {
                    curr = nums2[p2++];
                }

            } 
            else if (p1 < n1) {
                curr = nums1[p1++];
            } 
            else {
                curr = nums2[p2++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        }

        return curr;
    }
}