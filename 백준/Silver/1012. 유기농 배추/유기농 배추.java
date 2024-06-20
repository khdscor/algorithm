import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    static int x;
    static int y;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            String[] input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            int[][] map = new int[y][x];
            for (int i = 0; i < Integer.parseInt(input[2]); i++) {
                String[] input2 = br.readLine().split(" ");
                map[Integer.parseInt(input2[1])][Integer.parseInt(input2[0])] = 1;
            }
            bw.write(solution(map) + "\n");
        }
        bw.flush();
    }

    static private int solution(int[][] map){
        Queue<Cabbage> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(map[i][j] == 1){
                    result++;
                    queue.add(new Cabbage(j, i));
                    map[i][j] = 0;
                    while(!queue.isEmpty()){
                        Cabbage cabbage = queue.poll();
                        if(cabbage.y + 1 < y && map[cabbage.y + 1][cabbage.x] == 1){
                            queue.add(new Cabbage(cabbage.x, cabbage.y + 1));
                            map[cabbage.y + 1][cabbage.x] = 0;
                        }
                        if(cabbage.y - 1 >= 0 && map[cabbage.y - 1][cabbage.x] == 1){
                            queue.add(new Cabbage(cabbage.x, cabbage.y - 1));
                            map[cabbage.y - 1][cabbage.x] = 0;
                        }
                        if(cabbage.x + 1 < x && map[cabbage.y][cabbage.x + 1] == 1){
                            queue.add(new Cabbage(cabbage.x + 1, cabbage.y));
                            map[cabbage.y][cabbage.x + 1] = 0;
                        }
                        if(cabbage.x - 1 >= 0 && map[cabbage.y][cabbage.x - 1] == 1){
                            queue.add(new Cabbage(cabbage.x - 1, cabbage.y));
                            map[cabbage.y][cabbage.x - 1] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }

    static private class Cabbage {
        public int x;
        public int y;

        public Cabbage(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}