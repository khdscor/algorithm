import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long c = Integer.parseInt(input[2]);
        long result = solution(a, b, c);
        System.out.println(result);
    }

    private static long solution(long a, long b, long c){
        if(b != 1){
            if(b % 2 == 0){
                long value = solution(a, b / 2, c);
                return (value * value) % c;
            } else {
                long value = solution(a, (b-1)/2, c);
                return (((value * value) % c) * (a % c) % c) % c;

            }
        } else {
            return a % c;
        }
    }
}