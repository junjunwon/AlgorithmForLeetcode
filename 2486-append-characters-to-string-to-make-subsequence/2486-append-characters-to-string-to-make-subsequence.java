class Solution {
    public int appendCharacters(String s, String t) {
        /**
        split s, t into arrays
        for loop
        two pointers -> for s and t
        if s == t -> t++;
        after the for loop
            t.size() - indexOf(tPosition)
        */
        String[] sArray = s.split("");
        String[] tArray = t.split("");
        int sPointer = 0;
        int tPointer = 0;
        
        for (int i = 0; i < sArray.length; i++) {
            if (tArray.length <= tPointer) {
                break;
            }
            if (sArray[i].equals(tArray[tPointer])) {
                tPointer++;
            }
        }
        return tArray.length - tPointer;
    }
}