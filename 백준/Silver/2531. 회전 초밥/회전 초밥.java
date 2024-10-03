import java.io.*;
import java.util.*;

public class Main {

    private static int result = 0;

    private static int n;
    private static int d;
    private static int k;
    private static int c;
    private static int[] arrays;
    private static Queue<Integer> queue = new LinkedList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);
        arrays = new int[n];
        for (int i = 0; i < k; i++) {
            arrays[i] = Integer.parseInt(br.readLine());
            queue.add(arrays[i]);
            map.put(arrays[i], map.getOrDefault(arrays[i], 0) + 1);
        }
        result = map.size() + (map.containsKey(c) ?  0 : 1);
        for (int i = k; i < n; i++) {
            // 첫번째 값 추출
            int firstValue = queue.poll();
            if(map.get(firstValue) > 1){
                map.put(firstValue, map.get(firstValue) - 1);
            } else {
                map.remove(firstValue);
            }
            // 새로운 값 추가
            arrays[i] = Integer.parseInt(br.readLine());
            queue.add(arrays[i]);
            map.put(arrays[i], map.getOrDefault(arrays[i], 0) + 1);
            // 결과 계산
            int count = map.size() + (map.containsKey(c) ?  0 : 1);
            result = Math.max(result, count);
        }
        for (int i = 0; i < k; i++) {
            // 첫번째 값 추출
            int firstValue = queue.poll();
            if(map.get(firstValue) > 1){
                map.put(firstValue, map.get(firstValue) - 1);
            } else {
                map.remove(firstValue);
            }
            // 새로운 값 추가
            queue.add(arrays[i]);
            map.put(arrays[i], map.getOrDefault(arrays[i], 0) + 1);
            // 결과 계산
            int count = map.size() + (map.containsKey(c) ?  0 : 1);
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}