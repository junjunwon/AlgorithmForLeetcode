import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> results = new ArrayList();
        
        Arrays.sort(arr);
        int miniGap = 99999;
        
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = Math.abs(arr[i] - arr[i+1]);
            if (gap < miniGap) {
                miniGap = gap;
            }
        }
//          Stupid way 
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i+1; j < arr.length; j++) {
//                 int gap = Math.abs(arr[i] - arr[j]);
//                 if (gap < miniGap) {
//                     miniGap = gap;
//                 }
//             }
//         }
        
        
        
        for (int i = 0; i < arr.length - 1; i++) {
            List<Integer> result = new ArrayList();
            int gap = Math.abs(arr[i] - arr[i+1]);
            if (gap == miniGap) {
                result.add(arr[i]);
                result.add(arr[i+1]);
                results.add(result);
            }
        }
        
        return results;
    }
}