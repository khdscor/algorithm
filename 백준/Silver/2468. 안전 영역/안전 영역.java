import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int[][] map;
    static int[][] visited;

    static int n;
    static int max = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = 0; i < max; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] <= i) {
                        visited[j][k] = 1;
                    } else {
                        visited[j][k] = 0;
                    }

                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k] == 0) {
                        solution(j, k);
                        temp++;
                    }
                }
            }
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }

    private static void solution(int y, int x) {
        visited[y][x] = 1;
        if (x - 1 >= 0 && visited[y][x - 1] == 0) {
            solution(y, x - 1);
        }
        if (x + 1 < n && visited[y][x + 1] == 0) {
            solution(y, x + 1);
        }
        if (y - 1 >= 0 && visited[y - 1][x] == 0) {
            solution(y - 1, x);
        }
        if (y + 1 < n && visited[y + 1][x] == 0) {
            solution(y + 1, x);
        }
    }
}