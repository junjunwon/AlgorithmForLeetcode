
class Solution {
    /**
    defines newNums 
    defines maps -> check contain
    for nums 
        if no contain in maps 
            newNums.add
            k++;
     */
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}