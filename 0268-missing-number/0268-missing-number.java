/**
numsSize = nums.length;
first : find numsSize; true? output
second : find missing number.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        if (nums[size-1] != size) {
            return size;
        }

/**
index : 0 1 2
value : 0 1 3
 */
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] > nums[i] + 1) {
                return nums[i+1] - 1;
            }
        }
        return 0;
    }
}