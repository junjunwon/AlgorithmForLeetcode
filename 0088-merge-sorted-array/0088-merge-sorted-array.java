class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0) {
            return;
        }
        
        int j = 0;
        for (int i = nums1.length - 1; i >=0; i--) {
            if (nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
                if (j == n) {
                    Arrays.sort(nums1);
                    return;
                }
            }
        }
    }
}