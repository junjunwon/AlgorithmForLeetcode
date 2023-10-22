class Solution {

    private static Map<Integer, Integer> map = new HashMap();
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> rMap = new HashMap();
        for (int num : nums) {
            rMap.put(num, rMap.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> lMap = new HashMap();
        int m = nums.size();
        int ans = -1;

        for (int i = 0; i < m; i++) {
            int num = nums.get(i); //value
            if (rMap.get(num) == 1) {
                continue;
            }
            lMap.put(num, lMap.getOrDefault(num, 0) + 1);
            rMap.put(num, rMap.get(num) - 1);

            int left = lMap.get(num);
            int right = rMap.get(num);

            if ((left * 2 > (i+1)) && (right * 2 > (m-i-1))) {
                ans = i;
                break;
            }
        }

        return ans;

    }

//not working yet
    public int minimumIndexMyOwn(List<Integer> nums) {
        /**
        subArray는 1부터 시작한다.
        index 0
        once the value have dorminant, split. and save the split point.
        - save dorminant value.
        check the dorminant value 
        - save second dorminat value. 
        
        compare two
        - if it is not correct. do loop for same thing
        - if index of value == nums.size() - 1 -> return -1

        m = length
        x = element
        
        method
        - checkThisValueIsDorminant
        - compareMethod.
        */
        // int seperatePoint = 0;
        Map<Integer, Integer> map0 = new HashMap();
        for (int num : nums) {
            map0.put(num, map0.getOrDefault(num, 0) + 1);
        }
        if (map0.get(nums.get(0)) == nums.size() && nums.size() > 1) {
            return 0;
        }

        List<Integer> subList = new ArrayList();
        int splitPoint = 0;
        int one = 0;

        int index = 0;
        while (true) {
            if (index == nums.size() - 1) {
                break;
            }
            map.put(nums.get(index), map.getOrDefault(nums.get(index), 0) + 1);
            //once the value have dorminant, split. and save the split point.
            if (index > 0) {
                if (checkTheValueIsDorminant(index + 1, nums.get(index))) {
                    // save dorminant value.
                    one = nums.get(index);
                    // seperatePoint = index;
                    map = new HashMap();
                    subList = nums.subList(index + 1, nums.size());
                    splitPoint = index;
                    break;
                }
            } else {

            }

            index++;
        }

        int[] subNums = subList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int two = majorityElement(subNums);

        if (one == two) {
            return splitPoint;
        }

        return -1;
    }

    public int majorityElement(int[] nums) {
        //to be majority -> more thatn n/2
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        int resultKey = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > max) {
                max = frequency;
                resultKey = entry.getKey();
            }
        }
    
        return resultKey;
        
    }

    public boolean checkTheValueIsDorminant(int size, int value) {
        //freq(x) * 2 > length
        int occurrences = map.get(value) * 2;
        System.out.println("value : " + value);
        System.out.println("occurrences : " + occurrences + " and size : " + size);
        if (occurrences > size) {
            return true;
        }
        return false;
    }
}