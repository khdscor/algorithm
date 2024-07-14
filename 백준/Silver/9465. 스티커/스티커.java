import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int result = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] values = new int[2][n];
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    values[i][j] = Integer.parseInt(input[j]);
                }
            }
            int[] storage = new int[3];
            //dp
            for (int i = 0; i < n; i++) {
                int temp1 = storage[0];
                int temp2 = storage[1];
                int temp3 = storage[2];
                storage[0] = Math.max(temp2, temp3);
                storage[1] = Math.max(temp1, temp3) + values[1][i];
                storage[2] = Math.max(temp1, temp2) + values[0][i];
            }
            result = Math.max(storage[1], storage[2]);
            bw.write(result + "\n");
        }
        bw.flush();
    }
}