//** 08:17~09:07 */
/**
subset of nums
2 XOR 5 -> 2 ^ 5 

nums = [1,3] -> 4 
- The empty subset has an XOR total of 0.
- 0 -> 0
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 -> 6
1 XOR 3 -> 2 ( 1 ^ 3 = 2) 
Sysstem.out.print(1^3) -> 2
+ 
-
2 power of 6 -> 64

0 0 
1 0
0 1
1 1
 */
class Solution {
    public int subsetXORSum(int[] nums) {
        // 5 1 6
               //                               0
        // (nothing, 5)index 1.          0          5
        // (nothing, 1)index 2.       0    1      5    51
        // (nothing, 6)index 3.    0   6 1  16   5 56 51  516
         //-> 0   6 1  16   5 56 51  516
//        subset, nums, index(depth)
        return dfs(0, nums, 0);
    }

    public int dfs(int sum, int[] nums, int index) {
        if (index > nums.length -1) { // 0, 1, 2 -> 3-1 =2
            return sum;
        }
        
        return dfs(sum, nums, index+1) + dfs(sum^nums[index], nums, index+1);
    }
}