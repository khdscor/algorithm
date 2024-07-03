import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        if( n >= 1023){
            result = -1;
        } else if(n <= 1011){
            for (int i = 0; i < n;) {
                result++;
                if(solution(String.valueOf(result))){
                    i++;
                }
            }
        } else {
            result = solution2(n);
        }

        System.out.println(result);

    }

    private static boolean solution(String value){
        for (int i = 0; i < value.length() - 1; i++) {
            if(value.charAt(i) <= value.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

    private static long solution2(int n){
        if(n == 1012){
            return 876543210;
        } else if(n == 1013){
            return 976543210;
        } else if(n == 1014){
            return 986543210;
        } else if(n == 1015){
            return 987543210;
        } else if(n == 1016){
            return 987643210;
        } else if(n == 1017){
            return 987653210;
        } else if(n == 1018){
            return 987654210;
        } else if(n == 1019){
            return 987654310;
        } else if(n == 1020){
            return 987654320;
        } else if(n == 1021){
            return 987654321;
        } else if(n == 1022){
            return 9876543210L;
        }
        return -1;
    }
}