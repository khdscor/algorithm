import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static List<Info>[] values;

    private static int distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n + 1];
        values = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);
            values[start].add(new Info(end, distance));
        }
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        search(start);
        System.out.println(distance[end]);
    }

    private static void search(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.add(new Info(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (distance[info.number] < info.distance) {
                continue;
            }
            for (Info value : values[info.number]){
                if (distance[value.number] > info.distance + value.distance) {
                    distance[value.number] = info.distance + value.distance;
                    pq.add(new Info(value.number, distance[value.number]));
                }
            }
        }
    }

    private static class Info {
        public int number;
        public int distance;

        public Info(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }
}