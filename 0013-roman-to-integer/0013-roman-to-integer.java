import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap();
    Map<String, Integer> combinedMap = new HashMap();
    
    public void initializeMap () {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        combinedMap.put("IV", 4);
        combinedMap.put("IX", 9);
        combinedMap.put("XL", 40);
        combinedMap.put("XC", 90);
        combinedMap.put("CD", 400);
        combinedMap.put("CM", 900);
        
    }
    public int romanToInt(String s) {
        initializeMap();
        
        String[] sArr = s.split("");
        int result = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (i == sArr.length -1) {
                result += map.get(sArr[i]);
                continue;
            }
            if ("I".equals(sArr[i])) {
                //check next is V or X
                if ("V".equals(sArr[i+1]) || "X".equals(sArr[i+1])) {
                    String combined = sArr[i].concat(sArr[i+1]);
                    result += combinedMap.get(combined);
                    i++;
                    continue;
                }
            }
            if ("X".equals(sArr[i])) {
                //check next is L or C
                if ("L".equals(sArr[i+1]) || "C".equals(sArr[i+1])) {
                    String combined = sArr[i].concat(sArr[i+1]);
                    result += combinedMap.get(combined);
                    i++;
                    continue;
                }
            }
            if ("C".equals(sArr[i])) {
                //check next is D or M
                if ("D".equals(sArr[i+1]) || "M".equals(sArr[i+1])) {
                    String combined = sArr[i].concat(sArr[i+1]);
                    result += combinedMap.get(combined);
                    i++;
                    continue;
                }      
            }
            result += map.get(sArr[i]);
        }   
        return result;
    }
    
}