import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        int bridge_weight = 0;
        int time = 0;
        int index = 0;
        while(queue.size() > 0){
            time++;
            int truckWeight = queue.poll();
            bridge_weight -= truckWeight;
            if(index != truck_weights.length){
                if(bridge_weight + truck_weights[index] <= weight){
                    queue.add(truck_weights[index]);
                    bridge_weight += truck_weights[index];
                    index++;
                } else {
                    queue.add(0);
                }
            }
        }
        return time;
    }
    
//     public class Truck(){
//         public int time;
//         public int weight;
//         public Truck(int time, int weight){
//             this.time = time;
//             this.weight = weight;
//         }
//     }
}