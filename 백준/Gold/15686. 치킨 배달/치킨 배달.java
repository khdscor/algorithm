import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] arrays;

    static int n;

    static int m;

    static int count = 0;
    static int result = Integer.MAX_VALUE;

    static ArrayList<Chicken> chickens = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        arrays = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(input2[j]);
                arrays[i][j] = temp;
                if(temp == 2){
                    chickens.add(new Chicken(i, j, true));
                    count++;
                }
            }
        }

        solution(0, 0);

        System.out.println(result);

    }

    private static void solution(int index, int next){
        if((count - m) == index){
            // 거리 측정 알고리즘
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arrays[i][j] == 1){
                        sum += distance(i, j);
                    }
                }
            }
            result = Math.min(result, sum);
        } else {
            for (int i = next; i < chickens.size(); i++) {
                chickens.get(i).open = false;
                solution(index + 1, i + 1);
                chickens.get(i).open = true;
            }
        }
    }

    private static int distance(int x, int y){
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < chickens.size(); i++) {
            if(chickens.get(i).open){
                value = Math.min(value, Math.abs(x - chickens.get(i).x) + Math.abs(y - chickens.get(i).y));
            }
        }
        return value;
    }

    private static class Chicken {
        public int x;
        public int y;

        public boolean open;

        public Chicken(int x, int y, boolean open) {
            this.x = x;
            this.y = y;
            this.open = open;
        }
    }
}