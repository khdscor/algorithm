import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < n+1; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (t[j] + j == i) {
                    max = Math.max(dp[j] + p[j], max);
                }
            }
            for(int j= n; j>0; j--){
                max = Math.max(max, dp[j]);
            }
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}