import java.io.*;

public class Main {

    static int n;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        solution(x, y, 0);
        System.out.println(count);
    }

    private static void solution(int[] arrayX, int[] arrayY, int index) {
        if (index == n) {
            count++;
            return;
        }
        for (int y = 0; y < n; y++) {
            int temp = 0;
            for (int k = 0; k < index; k++) {
                int valueX = arrayX[k] - index;
                int valueY = arrayY[k] - y;
                if (valueX == 0 || valueY == 0 || Math.abs(valueX) == Math.abs(valueY)) {
                    temp = 1;
                    break;
                }
            }
            if (temp == 1) {
                continue;
            }
            arrayX[index] = index;
            arrayY[index] = y;
            solution(arrayX, arrayY, index + 1);
        }
    }
}