import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
            int one = 1;
            int two = 2;
            int result = 3;
            for (int i = 3; i <= n; i++) {
                result = (one + two) % 15746;
                one = two % 15746;
                two = result % 15746;
            }
            System.out.println(result);
        }

    }
}