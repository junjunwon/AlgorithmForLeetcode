class Solution {
    public int maximumPopulation(int[][] logs) {
        if (logs.length == 1) {
            return logs[0][0];
        }
        
        // 종료 연도를 기준으로 오름차순으로 정렬
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        int maxPopulation = 0;
        int maxPopulationYear = -1;
        int currentPopulation = 0;

        // 연도 범위를 순회하며 인구 카운트
        for (int i = 1950; i <= 2050; i++) {
            for (int j = 0; j < logs.length; j++) {
                if (logs[j][0] <= i && logs[j][1] > i) {
                    currentPopulation++;
                }
            }

            // 최대 인구 수와 해당 연도 업데이트
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxPopulationYear = i;
            }

            currentPopulation = 0;
        }

        return maxPopulationYear;
    }
    
    public int maximumPopulation2(int[][] logs) {
        if (logs.length == 1) {
            return logs[0][0];
        }
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        
        int cnt = 1;
        int resultCnt = cnt;
        int result = logs[0][0]; // 1993
        boolean temp = false;
        for (int i = 1; i < logs.length; i++) {
            cnt++;
            temp = false;
            if (logs[i-1][1] < logs[i][0]) {
                cnt--;
                temp = true;
            }
            if (resultCnt < cnt) {
                result = logs[i][0];
                resultCnt = cnt;
            }
            
            if (temp == true && logs[i-1][1] < logs[i][1]) {
                cnt--;
            }
        }
        
        return result;
    }
}