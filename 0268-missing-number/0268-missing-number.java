/**
numsSize = nums.length;
first : find numsSize; true? output
second : find missing number.
3 
+= 0 - 3 = -3 
+= 1 - 0 = 1
+= 2 - 1 = 1


2 0 1
3
+= 0


 */
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int lookedFor = nums[i]^i; // 3, 0
            if (lookedFor != 0) {
                return i;
            }
        }
        return nums.length;
    }
    public int missingNumber2(int[] nums) {
        int totalSum = 0;
        int missingSum = 0;

        for (int i = 0; i <= nums.length; i++) {
            totalSum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            missingSum += nums[i];
        }

        return totalSum - missingSum;
    }

    public int missingNumberStupid(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        if (nums[size-1] != size) {
            return size;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] > nums[i] + 1) {
                return nums[i+1] - 1;
            }
        }
        return 0;
    }
}