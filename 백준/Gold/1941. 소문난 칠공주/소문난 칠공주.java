import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    private static char[][] arrays = new char[5][5];
    private static boolean[][] visit = new boolean[5][5];

    private static HashSet<String> resultSet = new HashSet<>();

    private static preLocation[] locations = new preLocation[7];
    private static int result = 0;

    // left, right, up, down
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                arrays[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visit[i][j] = true;
                solution(j, i, 1, 0);
            }
        }
        System.out.println(result);
    }

    private static void solution(int x, int y, int index, int s) {
        locations[index - 1] = new preLocation(x, y);
        if(arrays[y][x] == 'S'){
            s++;
        }
        if(index == 7){
            if(s >= 4){
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if(visit[i][j]){
                            temp.append(i);
                            temp.append(j);
                        }
                    }
                }
                if(!resultSet.contains(temp.toString())){
                    result++;
                    resultSet.add(temp.toString());
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if(y + dy[i] < 5 && y + dy[i] >= 0 && x + dx[i] < 5 && x + dx[i] >= 0 && !visit[y + dy[i]][x + dx[i]]){
                    visit[y + dy[i]][x + dx[i]] = true;
                    solution(x + dx[i], y + dy[i], index + 1, s);
                    visit[y + dy[i]][x + dx[i]] = false;
                }
            }
            for (int i = 0; i < index - 1; i++) {
                for (int j = 0; j < 4; j++) {
                    if (locations[i].y + dy[j] < 5 && locations[i].y + dy[j] >= 0 && locations[i].x + dx[j] < 5 && locations[i].x + dx[j] >= 0 && !visit[locations[i].y + dy[j]][locations[i].x + dx[j]]) {
                        visit[locations[i].y + dy[j]][locations[i].x + dx[j]] = true;
                        solution(locations[i].x + dx[j], locations[i].y + dy[j], index + 1, s);
                        visit[locations[i].y + dy[j]][locations[i].x + dx[j]] = false;
                    }
                }
            }
        }
    }

    private static class preLocation {
        public int x;
        public int y;

        public preLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}