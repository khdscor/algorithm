import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int n;
    static int[][] array;

    static int count = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }

        solution(0, 1, 0);
        System.out.println(count);
    }

    private static void solution(int row, int column, int direction) {
        if (row == n - 1 && column == n - 1) {
            count++;
        } else {
            if ((direction != 2) && (column < n - 1) && array[row][column + 1] == 0) {
                solution(row, column + 1, 0);
            }
            if ((direction != 0) && (row < n - 1) && array[row + 1][column] == 0) {
                solution(row + 1, column, 2);
            }
            if ((column < n - 1) && (row < n - 1) && (array[row + 1][column] == 0) && (
                array[row][column + 1] == 0) && (array[row + 1][column + 1] == 0)) {
                solution(row + 1, column + 1, 1);
            }
        }
    }
}