import java.io.*;
import java.util.*;

public class Main {

    public static int[][] array;
    public static List<Virus> virus = new ArrayList<>();
    public static int n;
    public static int m;

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        array = new int[n][m];
        // 배열 값 입력
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(input2[j]);
                array[i][j] = value;
                if (value == 2) {
                    virus.add(new Virus(j, i));
                }
            }
        }
        // 감염 로직 진행
        process(0, 0, 0);
        System.out.println(result);
    }

    private static void process(int index, int x, int y) {
        // 벽을 3개 쌓았을 시
        if (index == 3) {
            // bfs로 감염 및 반환
            int count = spread();
            // 0인 곳의 개수를 비교
            result = Math.max(result, count);
        } else {
            // 벽을 쌓는 것을 완전 탐색으로 3개 쌓는다.
            for (int i = x; i < n; i++) {
                for (int j = y; j < m; j++) {
                    if (array[i][j] == 0) {
                        array[i][j] = 1;
                        process(index + 1, i, j + 1);
                        array[i][j] = 0;
                    }
                }
                y = 0;
            }
        }
    }

    private static int spread() {
        int[][] tempArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempArray[i][j] = array[i][j];
            }
        }
        for (Virus value : virus) {
            Queue<Virus> values = new LinkedList<>();
            values.add(value);
            while (values.size() > 0) {
                Virus temp = values.poll();
                if (temp.x + 1 < m && tempArray[temp.y][temp.x + 1] == 0) {
                    values.add(new Virus(temp.x + 1, temp.y));
                    tempArray[temp.y][temp.x + 1] = 2;
                }
                if (temp.x - 1 >= 0 && tempArray[temp.y][temp.x - 1] == 0) {
                    values.add(new Virus(temp.x - 1, temp.y));
                    tempArray[temp.y][temp.x - 1] = 2;
                }
                if (temp.y + 1 < n && tempArray[temp.y + 1][temp.x] == 0) {
                    values.add(new Virus(temp.x, temp.y + 1));
                    tempArray[temp.y + 1][temp.x] = 2;
                }
                if (temp.y - 1 >= 0 && tempArray[temp.y - 1][temp.x] == 0) {
                    values.add(new Virus(temp.x, temp.y - 1));
                    tempArray[temp.y - 1][temp.x] = 2;
                }
            }
        }

        // 0인 곳의 개수를 반환
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempArray[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static class Virus {
        public int x;
        public int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}