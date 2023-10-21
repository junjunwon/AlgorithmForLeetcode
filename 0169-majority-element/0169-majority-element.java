class Solution {
    public int majorityElement(int[] nums) {
        //to be majority -> more thatn n/2
        Map<Integer, Integer> map = new HashMap();

        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        int resultKey = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            System.out.println(frequency);
            if (frequency > max) {
                max = frequency;
                resultKey = entry.getKey();
            }
        }
    
        return resultKey;
        
    }
}