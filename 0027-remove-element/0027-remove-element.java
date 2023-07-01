class Solution {
    public int removeElement(int[] nums, int val) {
        /**
        array nums
        integer val
        return the number of elements in nums which are not equal to val
        change the array nums!
        
        index = 0
        if an element in nums != val 
            index++;
            nums[index] = nums[i];
         */
         int targetIndex = 0;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] != val) {
                 nums[targetIndex] = nums[i];
                 targetIndex++;
             }
         }

         return targetIndex;
    }
}