import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static int n;
    private static int k;
    private static Integer[] arrays;
    private static Integer[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        // 센서 위치
        arrays = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrays[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arrays);
        if(k >= n){
            System.out.println(0);
        } else {
            // 센서 사이 간격
            distance = new Integer[n - 1];
            for (int i = 0; i < n - 1; i++) {
                distance[i] = arrays[i + 1] - arrays[i];
            }
            Arrays.sort(distance, Collections.reverseOrder());
            // 첫 센서, 마지막 센서의 값에서 집중국의 수 - 1 만큼 센서 사이 간격을 큰 순으로 줄인다.
            int result = arrays[arrays.length - 1] - arrays[0];
            for (int i = 0; i < k - 1; i++) {
                result -= distance[i];
            }
            System.out.println(result);
        }

    }

}