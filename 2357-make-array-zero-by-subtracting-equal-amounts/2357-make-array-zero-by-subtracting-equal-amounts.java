import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == 0 || list.contains(num)) {
                continue;
            }
            list .add(num);
        }

        return list.size();
    }
}