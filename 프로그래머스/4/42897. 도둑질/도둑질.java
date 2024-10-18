class Solution {
    
    public int[][] value;
    
    public int solution(int[] money) {
        int answer = 0;
        int[] value1 = new int[money.length];
        int[] value2 = new int[money.length];
        
        // value1은 훔칠 경우, value2는 훔치지 않을 경우
        // 1. 첫 집에서 훔칠 경우
        value1[2] = money[0] + money[2];
        value2[2] = money[0];
        for(int i = 3; i < money.length - 1; i++){
            value1[i] = money[i] + value2[i - 1];
            value2[i] = Math.max(value1[i - 1], value2[i - 1]);
        }
        answer = Math.max(value1[money.length - 2], value2[money.length - 2]);
        // 2. 첫 집에서 훔치지 않을 경우
        value1[1] = money[1];
        value2[1] = 0;
        for(int i = 2; i < money.length; i++){
            value1[i] = money[i] + value2[i - 1];
            value2[i] = Math.max(value1[i - 1], value2[i - 1]);
        }
        answer = Math.max(answer, Math.max(value1[money.length - 1], value2[money.length - 1]));
        return answer;
    }
}