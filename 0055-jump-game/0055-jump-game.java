/**
looping (for)
before jump 
    check 
    check index + jumpingIndex < n.length-1
jumping
    maximum index + jumpingIndex which is less than n.length -1
after jumping 
    check jumpedIndex == n.length-1
        return true
        otherwise return false

return false

[2,3,1,1,4]
0 -> 0 > 0 -> 0, 2 -> 2
1 -> 1 > 2 -> 2, 4 -> 4
2 -> 2 > 4 -> 4, 3 -> 4
3 -> 3 > 4 -> 4, 4 -> 4
4 -> 4 > 4 -> 4, 8 -> 8

[3,2,1,0,4]
0 -> 0 > 0 -> 0, 3 -> 3
1 -> 1 > 3 -> 3, 3 -> 3
2 -> 2 > 3 -> 3, 3 -> 3
3 -> 3 > 3 -> 3, 3 -> 3
4 -> 4 > 3 -> return false;

[3,2,2,0,4]
0 -> 0 > 0 -> 0, 3 -> 3
1 -> 1 > 3 -> 3, 3 -> 3
2 -> 2 > 3 -> 3, 4 -> 4
3 -> 3 > 4 -> 4, 3 -> 4
4 -> 4 > 4 -> 4, 8 -> 8
 */
class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }

    public boolean dfs(int index, int[] nums) {
        int ableJumpCnt = nums[index];
        int jumpIndex = index + ableJumpCnt;
        if (ableJumpCnt==0) {
            return false;
        }
        if (jumpIndex == nums.length -1 ) {
            return true;
        }
        while (ableJumpCnt > 0) {
            if (jumpIndex > nums.length -1) {
                return true;
            } else {
            if (dfs(jumpIndex, nums)) {
                    return true;
                }
            }
            
            ableJumpCnt--;
        }

        return false;
    }
    public boolean canJumpTrying(int[] nums) {
        for (int i = 0; i <nums.length; i++) {
            boolean result = dfs(i, nums);
            if (result == true) {
                return true;
            }
        }

        return false;


        // for (int i = 0; i <nums.length; i++) {
        //     int ableJumpCnt = nums[i];
        //     int jumpIndex = i + ableJumpCnt;
        //     if (jumpIndex >= nums.length - 1) {
        //         return true;
        //     }
        //     //condition : jumpIndex < nums.length - 1
        //     int j = i;
        //     while (ableJumpCnt > 0 && j < nums.length) {
        //         j = j + ableJumpCnt;
        //         ableJumpCnt--;
        //         j++;
                
        //     }
        //     i = 3 -> 4
        //     ableJumpCnt = 2 -> 1
        //     jumpIndex = 5
        //     last index 4
        //     length = 5
        //     jumpIndex - lastIndex = 1 
        //     [2, 1]
        //     0,  1 -->  size : 2
        //     0 + 2 -> 2 - 1 = 1
        //     if (jumpIndex == nums.lnegth-1) {
        //         return true;
        //     } else if (jumpIndex > nums.lenth) {
        //         jumpIndex--;
        //     }
        // }
    }
}