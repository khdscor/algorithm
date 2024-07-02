import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrays = new int[10];
        int[] temp = new int[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = 1;
            temp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            arrays[0] = temp[1];
            if(arrays[0] > 1000000000){
                arrays[0] %= 1000000000;
            }
            for (int j = 1; j < 9; j++) {
                arrays[j] = temp[j-1]  + temp[j+1];
                if(arrays[j] > 1000000000){
                    arrays[j] %= 1000000000;
                }
            }
            arrays[9] = temp[8];
            if(arrays[9] > 1000000000){
                arrays[9] %= 1000000000;
            }
            for (int j = 0; j < 10; j++) {
                temp[j] = arrays[j];
            }
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += arrays[i];
        }
        System.out.println(result % 1000000000);
    }
}