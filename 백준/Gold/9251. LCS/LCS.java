import java.io.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        dp = new int[second.length()][first.length()];
        for (int i = 0; i < first.length(); i++) {
            if (second.charAt(0) == first.charAt(i) || (i > 0 && dp[0][i - 1] == 1)) {
                dp[0][i] = 1;
            }
        }

        for (int j = 1; j < second.length(); j++) {
            for (int i = 0; i < first.length(); i++) {
                if (second.charAt(j) == first.charAt(i)) {
                    if (i == 0) {
                        dp[j][i] = 1;
                    } else {
                        dp[j][i] = dp[j - 1][i - 1] + 1;
                    }
                } else {
                    if (i == 0) {
                        dp[j][i] = dp[j - 1][i];
                    } else {
                        dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                    }
                }
            }
        }
        System.out.println(dp[second.length() - 1][first.length() - 1]);
    }

}