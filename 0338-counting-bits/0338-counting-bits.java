class Solution {
    public int[] countBits2(int n) {
        /**
        dynamic programming 
        TC : O(n)
         */
         int dp[] = new int[n+1];
         dp[0] = 0;
        int offset = 1;
         for (int i = 1; i <= n; i++) {
             if (offset * 2 == i) {
                 offset = i;
             }
             dp[i] = 1 + dp[i - offset];
         }
         return dp;
    }
    public int[] countBits(int n) {
        /**
        methods
            extract "1" in list consist of "0", "1" <- we don't need anymore if we only save "1" value, -> check the length of arrayList 
            convert decimal to binary
                don't need to add "0" value. just check it out

        1. for loop for n.length from 0; 
        2. for each "i", while loop 
            2-1. get  by extractMethods 
            2-2. arrayList.add(length of array)
         */
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = convertDecimalToBinary(i);
        }

        return ans;
    }   
    private int convertDecimalToBinary(int index) {
        List<Integer> array = new ArrayList<>();
        /*
        convert decimal to binary
                don't need to add "0" value. just check it out
        */
        int target = index;
        while (true) {
            int quotient = target / 2;
            int modulo = target - ((target / 2) * 2);
            target = quotient;
            if (quotient < 2) {
                if (modulo == 1) {
                    array.add(modulo);
                }
                if (quotient == 1) {
                    array.add(quotient);
                }
                break;
            }
            if (modulo == 1) {
                    array.add(modulo);
                }
        }
        return array.size();
    }
}