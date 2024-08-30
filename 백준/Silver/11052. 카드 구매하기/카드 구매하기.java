import java.io.*;

public class Main {

    public static int[][] gear = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(input[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i / 2; j++) {
                array[i] = Math.max(array[j] + array[i - j], array[i]);
            }
        }
        System.out.println(array[n]);
    }
}