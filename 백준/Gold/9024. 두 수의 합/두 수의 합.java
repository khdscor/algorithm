import java.io.*;
import java.util.Arrays;

public class Main {

    static int result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int k = Integer.parseInt(input1[1]);
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(input2[i]);
            }
            Arrays.sort(values);
            result = Integer.MAX_VALUE;
            count = 0;
            for (int i = 0; i < n - 1; i++) {
                binarySearch(values, values[i], i + 1, n - 1, k);
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }

    private static void binarySearch(int[] arrays, int value, int left, int right, int k) {


        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((arrays[mid] + value) == k) {
                if(result  == 0){
                    count++;
                } else {
                    result = 0;
                    count = 1;
                }
                return ;
            }
            int temp = Math.abs(arrays[mid] + value - k);
            if (temp < result) {
                result = temp;
                count = 1;
            } else if (temp == result) {
                count++;
            }
            if ((arrays[mid] + value) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}