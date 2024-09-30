import java.io.*;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int m;
    private static int distance;
    private static int[] arrays;

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        distance = Integer.parseInt(input1[2]);
        int[] locations = new int[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            locations[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(locations);
        arrays = new int[n + 1];
        arrays[0] = n > 0 ? locations[0] : 0;
        arrays[n] = distance - (n > 0 ? locations[n - 1] : 0);
        for (int i = 1; i < n; i++) {
            arrays[i] = locations[i] - locations[i - 1];
        }
        search();
        System.out.println(result);
    }

    public static void search() {
        int left = 1;
        int right = 999;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (cal(mid) > m) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
    }

    public static int cal(int value) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += (arrays[i] - 1) / value;
        }
        return sum;
    }
}