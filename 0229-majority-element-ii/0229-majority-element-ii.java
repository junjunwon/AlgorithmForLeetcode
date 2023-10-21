class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /**
        n/3
        nums.size < 3 -> return all values of list;
        nums.size >= 3 -> 
        put all in map 
        if (mod + 1 <= value) {
            list.add(value);
        }
         */
        // if (nums.length < 3) {
        //      return Arrays.stream(nums).boxed().collect(Collectors.toList());
        //  }
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> map = new HashMap();

        int mod = nums.length / 3;

        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);     
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mod) {
                list.add(entry.getKey());
            }
        }

        return list;
    }
}