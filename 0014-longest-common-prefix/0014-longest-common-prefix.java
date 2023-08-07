class Solution {
    public String longestCommonPrefix(String[] strs) {
        /**
        strs.length == 1 -> return strs[0];
        int[] result = {d o g};

        iterate from index 1 to the last index of the array.
        define for loop -> compare from zero to the index (not matched with result[index]) - 1
        index 1 -> d != r -> if index == 0 -> break;
        Math.min(previousFoundIndex, currentFoundIndex);

        flower -> index = 5
        flight -> index = 1 (fl == fl)
        flow -> index = 3
         */
        
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        String[] result = strs[0].split("");  //flower
        int minimumIndex = 200;
        for (int i = 1; i < strs.length; i++) {
            String[] eachArray = strs[i].split("");  //flow -> flight
            int j = 0;
            int foundIndex = 0;
            while (j < result.length && j < eachArray.length) {
                if (!result[j].equals(eachArray[j])) {
                    break;
                }
                foundIndex = j + 1; 
                j++; 
            }
            minimumIndex = Math.min(foundIndex, minimumIndex); 
            //there is no common prefix
            if (minimumIndex == 0) {
                return "";
            } 
        }

        for (int i = 0; i < minimumIndex; i++){ 
            sb.append(result[i]);
        }

        return sb.toString();
    }
}