import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] array;
    private static int[][] result;
    //left, right, down, up
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 가로 길이
        m = Integer.parseInt(input[0]);
        // 세로 길이
        n = Integer.parseInt(input[1]);
        //  미로 
        array = new int[n][m];
        // 위치별 최소 벽 뚫기 개수
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input2 = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(input2.charAt(j)));
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        search(0, 0);
        System.out.println(result[n - 1][m - 1]);
    }

    private static void search(int x, int y) {
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        pq.add(new Info(x, y, 0));
        result[y][x] = 0;
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (result[info.y][info.x] < info.count) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                if (info.x + dx[i] < m && info.x + dx[i] >= 0 && info.y + dy[i] < n && info.y + dy[i] >= 0) {
                    int block = array[info.y + dy[i]][info.x + dx[i]];
                    if (result[info.y + dy[i]][info.x + dx[i]] > info.count + block) {
                        result[info.y + dy[i]][info.x + dx[i]] = info.count + block;
                        pq.add(new Info(info.x + dx[i], info.y + dy[i], info.count + block));
                    }
                }
            }
        }
    }


    private static class Info {
        public int x;

        public int y;
        public int count;

        public Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}