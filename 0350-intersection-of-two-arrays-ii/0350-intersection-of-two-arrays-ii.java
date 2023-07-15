class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int firstLength = nums1.length;
        int twoLength = nums2.length;
        
        if (firstLength > twoLength) {
            return solve(nums2, nums1);
        } else {
            return solve(nums1, nums2);
        }
    }
    public int[] solve(int[] smallArray, int[] largeArray) {
        List<Integer> temp = new ArrayList();
        for (int i = 0; i < smallArray.length; i++) {
            for (int j = 0; j < largeArray.length; j++) {
                if (smallArray[i] == largeArray[j]) {
                    temp.add(smallArray[i]);
                    largeArray[j] = -1;
                    break;
                }
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}