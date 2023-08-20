/**
three pointers
initailaze
first -> idx 0
second -> idx 1
third -> idx 2

define closestSum; 
while loop
- escape condition : first index equal to n - 2
    cuz if firstIndex[n-2] -> which means there is nothing investigate more.
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length; i++) {
            int firstPointer = i + 1;
            int secondPointer = nums.length - 1;

            while (firstPointer < secondPointer) {
                int sum = nums[i] + nums[firstPointer] + nums[secondPointer];

                if (sum > target) {
                    secondPointer--;
                } else {
                    firstPointer++;
                }

                int numGap = Math.abs(sum - target);
                int resultGap = Math.abs(result - target);
                result = resultGap < numGap ? result : sum;
            }
        }

        return result;
    }
    
    public int threeSumClosestStupid(int[] nums, int target) {
        int firstP = 0;
        int secondP = 1;
        int thirdP = 2;

        int length = nums.length;
        int closestSum = 1001;

        while (firstP < length - 2) {
            int sum = nums[firstP] + nums[secondP] + nums[thirdP];

            int closestGap = Math.abs(closestSum - target);
            int numGap = Math.abs(sum - target);
            closestSum = closestGap < numGap ? closestSum : sum;

            if (thirdP < length) {
                thirdP++;
            }
            if (secondP < length - 1) {
                secondP++;
            }
            if(firstP < length -2) {
                firstP++;
            }
        }

        return closestSum;
    }
}