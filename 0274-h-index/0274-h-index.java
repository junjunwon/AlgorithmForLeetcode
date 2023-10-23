class Solution {
    public int hIndex(int[] citations) {
        //어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
        //6 5 3 1 0
        //1 2 3 4 5
        //h -index는 
        //주어진 저자/저널이 각각 최소 h 회 인용된 최소 h 개의 논문을 출판 한 h 의 최대값으로 정의됩니다 . 
        //출판할때마다 인용된 횟수가 출판된 횟수보다 작아지는 순간에 -1번째 value of index가 h-index가 될 듯.

        int result = 0;
        Arrays.sort(citations);
        int[] results = reverseOrder(citations);

        //6 5 3 1 0
        //1 2 3 4 5
        //0 1 2 3 4

        //3 1 1
        //1 2 3
        //0 1 2

        //4 4 0 0
        //1 2 3 4
        for (int i = 0; i < results.length; i++) {
            if (results[i] == i+1) {
                result = i+1;
                break;
            }
            else if (results[i] < i+1) { //1 < 4 : i = 2
                result = i;
                // if (i == 0) {
                //     result = results[0];
                // } else {
                //     result = results[i];
                // }
                break;
            } 
            else if (i == results.length -1) {
                result = results.length;
            }
        }

        return result;
    }

    public int[] reverseOrder(int[] citations) {
        int[] result = new int[citations.length];
        for (int i = 0; i < citations.length; i++) {
            result[citations.length -i -1] = citations[i];
            result[i] = citations[citations.length -i -1];;
        }

        return result;
    }
}