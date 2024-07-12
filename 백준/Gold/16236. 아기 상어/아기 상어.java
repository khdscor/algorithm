import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int n;

    static int[][] map;

    static boolean[][] visit;

    static int currentRow;
    static int currentColumn;

    static int result = 0;

    static int level = 2;

    static int count = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(input[j]);
                map[i][j] = temp;
                if (temp == 9) {
                    currentRow = i;
                    currentColumn = j;
                }
            }
        }
        solution();
        System.out.println(result);
    }

    public static void solution() {

        while (true) {
            int minLocation = bfs();
            if (minLocation == 400) {
                break;
            }
            result += minLocation;

            // 상어 레벨업
            count++;
            if (count == level) {
                level++;
                count = 0;
            }

            //visit 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visit[i][j] = false;
                }
            }
        }
    }

    public static int bfs() {
        int minLocation = 400;
        int tempRow = 400;
        int tempColumn = 400;
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(currentRow, currentColumn, 0));
        visit[currentRow][currentColumn] = true;
        map[currentRow][currentColumn] = 0;
        while (!queue.isEmpty()) {
            Location location = queue.poll();
            // 거리 확인
            if (map[location.row][location.column] > 0 && map[location.row][location.column] < level) {
                if (location.distance < minLocation) {
                    minLocation = location.distance;
                    tempRow = location.row;
                    tempColumn = location.column;
                } else if (location.distance == minLocation) {
                    if (location.row < tempRow) {
                        tempRow = location.row;
                        tempColumn = location.column;
                    } else if (location.row == tempRow) {
                        tempColumn = Math.min(location.column, tempColumn);
                    }
                }
            }
            //up
            if (location.row - 1 >= 0 && !visit[location.row - 1][location.column]
                && map[location.row - 1][location.column] <= level) {
                visit[location.row - 1][location.column] = true;
                queue.add(new Location(location.row - 1, location.column, location.distance + 1));
            }
            //right
            if (location.column + 1 < n && !visit[location.row][location.column + 1]
                && map[location.row][location.column + 1] <= level) {
                visit[location.row][location.column + 1] = true;
                queue.add(new Location(location.row, location.column + 1, location.distance + 1));
            }
            //left
            if (location.column - 1 >= 0 && !visit[location.row][location.column - 1]
                && map[location.row][location.column - 1] <= level) {
                visit[location.row][location.column - 1] = true;
                queue.add(new Location(location.row, location.column - 1, location.distance + 1));
            }
            //down
            if (location.row + 1 < n && !visit[location.row + 1][location.column]
                && map[location.row + 1][location.column] <= level) {
                visit[location.row + 1][location.column] = true;
                queue.add(new Location(location.row + 1, location.column, location.distance + 1));
            }
        }
        currentRow = tempRow;
        currentColumn = tempColumn;
        return minLocation;
    }

    private static class Location {

        public int row;
        public int column;
        public int distance;

        public Location(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }
}