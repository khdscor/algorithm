import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    static Building[] buildings;

    static int[] result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        buildings = new Building[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            buildings[i] = new Building();
        }
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            buildings[i].time = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j++) {
                buildings[i].inCount++;
                buildings[Integer.parseInt(input[j])].outBuilding.add(i);
            }
        }
        solution();
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    static private void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(buildings[i].inCount == 0) {
                queue.add(i);
                result[i] = buildings[i].time;
            }
        }

        while(!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 0; i < buildings[num].outBuilding.size(); i++) {
                int temp = buildings[num].outBuilding.get(i);
                buildings[temp].inCount--;
                result[temp] = Math.max(result[temp], buildings[temp].time + result[num]);
                if(buildings[temp].inCount == 0){
                    queue.add(temp);
                }
            }
        }
    }

    static private class Building {

        public int time;

        public int inCount = 0;

        public ArrayList<Integer> outBuilding = new ArrayList<>();

        public Building() {
        }
    }
}