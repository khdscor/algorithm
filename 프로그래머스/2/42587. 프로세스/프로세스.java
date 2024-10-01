import java.util.*;

class Solution {
    
     
    public Queue<Process> queues = new LinkedList<>();
    public PriorityQueue<Integer> priorityQueues = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] priorities, int location) {
        int answer = 0;
        for(int i = 0; i < priorities.length; i++){
            priorityQueues.add(priorities[i]);
            queues.add(new Process(i, priorities[i]));
        }
        boolean go = true;
        while(go && priorityQueues.size() > 0) {
            int priority = priorityQueues.poll();
            while(true){
                Process process = queues.poll();
                if(process.value == priority){
                    answer++;
                    if(process.index == location){
                        go = false;
                    }
                    break;
                } 
                queues.add(process);
            }
        }
        
        return answer;
    }
    
    public class Process {
        public int index;
        public int value;
        
        public Process(int index, int value){
            this.index = index;
            this.value= value;
        }
    }
}