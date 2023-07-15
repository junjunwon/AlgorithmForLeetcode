class Solution {
    /**
    4 5 9
    4 4 8 9 9
    **/
    public int[] intersect(int[] nums1, int[] nums2) {
        // (1 2 2 1), (2,2)

        // num1, num2 array

        // 1
        // hold the key, value into the map (key: then number,value; count) 
        // num1 map, num2 map
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            map1.put(target, map1.getOrDefault(target, 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int target = nums2[i];
            map2.put(target, map2.getOrDefault(target, 0) + 1);
        }

        // 2
        // 4 9 5
        // 9 4 9 8 4

        // map1: 4->1, 9->1, 5->1
        // map2: 4->2, 9->2, 8->1

        // finding duplicate keys between two maps -> candidate keys 
        List<Integer> keys = new ArrayList();
        for (int map1Key: map1.keySet()) {
            if (map2.containsKey(map1Key)) {
                keys.add(map1Key);
            }
        }

        // compare num1[key] num2[key] append Min value to result

        // 3
        // append keys (which counts the value) to result list
        // List<Integer> resultKey = new ArrayList();

        List<Integer> result = new ArrayList();
        
        for (int i = 0; i < keys.size(); i++) {
            int target = keys.get(i);
            int t1 = map1.get(target);
            int t2 = map2.get(target);

            int targetValue = Math.min(t1, t2);

            for (int j = 0; j < targetValue; j++) {
                result.add(target);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] intersect0(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> temp = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                // nums1[i] == nums2[j]
                temp.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[temp.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = temp.get(k);
        }
        return result;
    }
    
    
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> temp = new ArrayList();
        
        for (int el : nums1) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                temp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int firstLength = nums1.length;
        int twoLength = nums2.length;
        
        if (firstLength > twoLength) {
            return solve(nums2, nums1);
        } else {
            return solve(nums1, nums2);
        }
    }
    public int[] solve(int[] smallArray, int[] largeArray) {
        List<Integer> temp = new ArrayList();
        for (int i = 0; i < smallArray.length; i++) {
            for (int j = 0; j < largeArray.length; j++) {
                if (smallArray[i] == largeArray[j]) {
                    temp.add(smallArray[i]);
                    largeArray[j] = -1;
                    break;
                }
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}