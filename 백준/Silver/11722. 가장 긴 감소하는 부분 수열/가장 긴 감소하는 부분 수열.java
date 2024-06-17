import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int n;

    static int[] value;

    static int[] count;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(input[i]);
        }
        if( n == 1){
            System.out.println(1);
        } else {
            count = new int[n];
            for (int i = 0; i < n; i++) {
                count[i] = 1;
            }
            solution();
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, count[i]);
            }
            System.out.println(result);
        }
    }

    private static void solution(){

        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if(value[j] > value[i] && temp < count[j]){
                    temp = count[j];
                }
            }
            count[i] += temp;
        }
    }
}