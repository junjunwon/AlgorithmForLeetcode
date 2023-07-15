class Solution {
    /**
    3
    9
    27
    81
    
    27 -> 27/3 = 9 , 0
    9  -> 9/3 = 3, 0
    3 -> true
    
    28 -> 28 % 3 = 1
    **/
    public boolean isPowerOfThree(int n) {
        if (n == 0 || n == -1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int k = n;
        while (true) {
            if (k == 3) {
                return true;
            }
            if (k % 3 != 0) {
                return false;
            }
            k = k / 3;
        }
    }
}