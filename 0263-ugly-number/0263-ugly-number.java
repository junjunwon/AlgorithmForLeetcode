class Solution {
    public boolean isUgly(int n) {
        /**
        input equal to 1 
            return true
        while loop 
            verify input n equal to 2,3,5 -> return true
            define isDivided = false;
            divide int n with 2,3,5 
                if it is divided -> isDivided = true

            isDivided = false
                return false;
         */

         if (n == 1) {
             return true;
         }
         if (n == 0) {
             return false;
         }
        int quotient = n;
         while(true) {
             if (quotient == 2 || quotient == 3 || quotient == 5) {
                 return true;
             }

             boolean isDivided = false;

             if (quotient % 2 == 0) {
                 quotient = quotient / 2;
                 isDivided = true;
             }
             else if (quotient % 3 == 0) {
                 quotient = quotient / 3;
                 isDivided = true;
             }
             else if (quotient % 5 == 0) {
                 quotient = quotient / 5;
                 isDivided = true;
             }

             if (isDivided == false) {
                 return false;
             }
         }
    }
}