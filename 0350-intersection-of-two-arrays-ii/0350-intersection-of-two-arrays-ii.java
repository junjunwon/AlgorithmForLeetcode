class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> temp = new ArrayList();
        
        for (int el : nums1) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                temp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
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