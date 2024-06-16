class Solution {
    public long solution(int price, int money, int count) {
        
        long sum = price;
        for(int i = 2; i <= count; i++){
            sum += price * i;
        }
        
        long answer = 0;
        if(sum > money){
            answer = sum - money;
        }
        return answer;
    }
}