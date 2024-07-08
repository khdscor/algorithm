import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int k;
    static Things[] array;
    static long[] maxValue = new long[10000000];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        k = Integer.parseInt(input1[1]);
        array = new Things[n];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            array[i] = new Things(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));
        }
        Arrays.sort(array);

        solution();
        long result = 0;

        for (int i = 1; i <= k; i++) {
            result = Math.max(result, maxValue[i]);
        }
        System.out.println(result);
    }

    private static void solution() {
        int index = 1;
        for (int i = 0; i < n; i++) {
            Things things = array[i];
            for (int j = index; j >= 0; j--) {
                maxValue[things.weight + j] = Math.max(things.value + maxValue[j], maxValue[things.weight + j]);
            }
            index += things.weight;
        }
    }

    private static class Things implements Comparable<Things> {

        public int weight;
        public int value;

        @Override
        public int compareTo(Things t) {
            return this.weight - t.weight;
        }

        public Things(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}