import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) ==')'){
                if(queue.size() == 0){
                    return false;
                }
                queue.poll();
                continue;
            }
            queue.add(s.charAt(i));
        }
        return queue.size() > 0 ? false : true;
    }
}