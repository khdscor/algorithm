import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Integer> cards = new ArrayList<>();
    static int[] set;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        String[] input3 = br.readLine().split(" ");

        m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);
        set = new int[m];
        for (int i = 0; i < m; i++) {
            cards.add(Integer.parseInt(input2[i]));
            set[i] = -1;
        }
        Collections.sort(cards);
        for (int i = 0; i < k; i++) {
            int value = Integer.parseInt(input3[i]);
            int index = binarySearch(value);
            int resultIndex = find(index);
            union(resultIndex);
            bw.write(cards.get(resultIndex) + "\n");
        }
        bw.flush();
    }

    private static int find(int n) {
        if(set[n] < 0){
            return n;
        }
        return find(set[n]);
    }

    private static void union(int n){
        if(n + 1 < m){
            set[n] = n + 1;
        }
    }

    private static int binarySearch(int value) {
        int left = 0;
        int right = cards.size() - 1;
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (cards.get(mid) > value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}