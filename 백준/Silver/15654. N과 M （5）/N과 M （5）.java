import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static int[] array;
    static boolean[] visit;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        array = new int[n];
        visit = new boolean[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(array);
        solution(0, "");
        bw.flush();
    }

    private static void solution(int count, String result) throws IOException {
        if(count == m){
            bw.write(result + "\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                visit[i] = true;
                solution(count + 1, result + array[i] + " ");
                visit[i] =false;
            }

        }
    }
}