import java.util.*;

class Solution {
    
    public int answer = 0;
    public int solution(int[] citations) {
        Arrays.sort(citations);
        binarySearch(citations);
        return answer;
    }
    
    public void binarySearch(int[] citations){
        int left = 0;
        int right = 10000;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(binartSearch2(citations, mid)){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
    }
    
    public boolean binartSearch2(int[] citations, int value){
        boolean v = false;
        int left = 0;
        int right = citations.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(citations[mid] >= value){
                if(citations.length - mid >= value && mid <= value){
                    return true;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}