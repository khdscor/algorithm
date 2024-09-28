import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Value[] values = new Value[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            values[i] = new Value(String.valueOf(numbers[i]));
        }
        Arrays.sort(values);
        
        for(int i = 0; i < values.length; i++){
            answer += values[i].number;
        }
        int count = 0;
        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) == '0'){
                count++;
            } else {
                break;
            }
        }
        answer = answer.substring(count, answer.length());
        return answer.length() > 0 ? answer : "0";
    }
    
    public class Value implements Comparable<Value>{
        public String number;
        
        public Value(String number){
            this.number = number;
        }
        @Override 
        public int compareTo(Value v){
            String temp1 = this.number + v.number;
            String temp2 = v.number + this.number;
            if(temp1.equals(temp2)){
                return 0;
            }
            return temp1.compareTo(temp2) > 0 ? -1 : 1; 
        }
    }
}