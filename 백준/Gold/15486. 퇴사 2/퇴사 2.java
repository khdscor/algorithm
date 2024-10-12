import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];
        long[] money = new long[n + 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < n; i++) {
            // 상담을 안할 경우
            money[i + 1] = Math.max(money[i + 1], money[i]);
            // 상담을 할 경우
            if(i + array[i][0] <= n){
                money[i + array[i][0]] = Math.max(money[i + array[i][0]], money[i] + array[i][1]);
            }
        }

        System.out.println(money[n]);
    }
}