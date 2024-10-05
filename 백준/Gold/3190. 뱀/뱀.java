import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] array;
    private static Queue<Direction> queue = new LinkedList<>();
    private static int result = 0;

    // right, down, left, up
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        array = new int[n][n];
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            array[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] input = br.readLine().split(" ");
            queue.add(new Direction(Integer.parseInt(input[0]), input[1].charAt(0)));
        }
        solution();
        System.out.println(result);
    }

    private static void solution() {
        ArrayList<Tail> tails = new ArrayList<>();
        int x = 0;
        int y = 0;
        int time = 0;
        char direction = 'D';
        int i = 0;
        if (!queue.isEmpty()) {
            Direction temp = queue.poll();
            time = temp.second;
            direction = temp.direction;
        }
        go:
        while (true) {
            result++;
            x += dx[i];
            y += dy[i];
            // 몸통 길이 확장
            if (tails.size() > 0) {
                tails.add(new Tail(x - dx[i], y - dy[i]));
            }
            // 종료 여부 확인 : 벽에 부딛힐 경우
            if (x < 0 || x >= n || y < 0 || y >= n) {
                break go;
            }
            // 종료 여부 확인 : 꼬리에 부딛힐 경우
            for (int j = 0; j < tails.size(); j++) {
                if (x == tails.get(j).x && y == tails.get(j).y) {
                    break go;
                }
            }
            // 사과 발견
            if (array[y][x] == 1) {
                // 꼬리 추가
                if(tails.size() == 0){
                    tails.add(new Tail(x - dx[i], y - dy[i]));
                }
                array[y][x] = 0;
            } else {
                // 꼬리 이동
                if (tails.size() > 0) {
                    tails.remove(0);
                }
            }
            // 방향 전환의 시각이 되었다면 방향 전환
            if (result == time) {
                if (direction == 'D') {
                    i++;
                    if (i == 4) {
                        i = 0;
                    }
                } else {
                    i--;
                    if (i == -1) {
                        i = 3;
                    }
                }
                if (!queue.isEmpty()) {
                    Direction temp = queue.poll();
                    time = temp.second;
                    direction = temp.direction;
                }
            }
        }
    }

    private static class Direction {
        public int second;
        public char direction;

        public Direction(int second, char direction) {
            this.second = second;
            this.direction = direction;
        }
    }

    private static class Tail {
        public int x;
        public int y;

        public Tail(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}