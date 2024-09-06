import java.io.*;
import java.util.*;

public class Main {

    public static char[][] array;
    public static List<Land> lands = new ArrayList<>();
    public static int n;
    public static int m;

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        array = new char[n][m];
        // 배열 값 입력
        for (int i = 0; i < n; i++) {
            String input2 = br.readLine();
            for (int j = 0; j < m; j++) {
                char value = input2.charAt(j);
                array[i][j] = value;
                if (value == 'L') {
                    lands.add(new Land(j, i, 0));
                }
            }
        }
        process();
        System.out.println(result);
    }

    private static void process(){
        Queue<Land> queue = new LinkedList<>();
        for (int i = 0; i < lands.size(); i++) {
            boolean[][] visit = new boolean[n][m];
            queue.add(lands.get(i));
            visit[lands.get(i).y][lands.get(i).x] = true;
            // bfs로 거리 측정
            while(!queue.isEmpty()){
                Land temp = queue.poll();
                // 거리 갱신
                result = Math.max(result, temp.distance);
                // 오른쪽으로 이동 가능한 경우
                if(temp.x + 1 < m && !visit[temp.y][temp.x + 1] && array[temp.y][temp.x + 1] == 'L'){
                    queue.add(new Land(temp.x + 1, temp.y, temp.distance + 1));
                    visit[temp.y][temp.x + 1] = true;
                }
                // 왼쪽으로 이동 가능한 경우
                if(temp.x - 1 >= 0 && !visit[temp.y][temp.x - 1] && array[temp.y][temp.x - 1] == 'L'){
                    queue.add(new Land(temp.x - 1, temp.y, temp.distance + 1));
                    visit[temp.y][temp.x - 1] = true;
                }
                // 아래로 이동 가능한 경우
                if(temp.y + 1 < n && !visit[temp.y + 1][temp.x] && array[temp.y + 1][temp.x] == 'L'){
                    queue.add(new Land(temp.x, temp.y + 1, temp.distance + 1));
                    visit[temp.y + 1][temp.x] = true;
                }
                // 위로 이동 가능한 경우
                if(temp.y - 1 >= 0 && !visit[temp.y - 1][temp.x] && array[temp.y - 1][temp.x] == 'L'){
                    queue.add(new Land(temp.x, temp.y - 1, temp.distance + 1));
                    visit[temp.y - 1][temp.x] = true;
                }
            }
        }
    }

    private static class Land {
        public int x;
        public int y;

        public int distance;

        public Land(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}