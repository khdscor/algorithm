import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while(index < progresses.length){
            int days = (100 - progresses[index]) / speeds[index] + ((100 - progresses[index]) % speeds[index] > 0 ? 1 : 0);
            int count = 1;
            int nextIndex = index + 1; 
            boolean process = true;
            for(int i = index + 1; i < progresses.length; i++){
                progresses[i] += speeds[i] * days;
                if(process && progresses[i] >= 100){
                   nextIndex++;
                    count++;
                    continue;
                } 
                process = false;
            }
            index = nextIndex;
            result.add(count);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}