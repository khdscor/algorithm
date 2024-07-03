import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 666;
        for (int i = 1; i < n;) {
            result++;
            if(solution(String.valueOf(result))){
                i++;
            }
        }
        System.out.println(result);
    }

    private static boolean solution(String value){
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '6'){
                count++;
                if(count == 3){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}