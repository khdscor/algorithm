import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

class Main {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] values = new String[n];
            for (int i = 0; i < n; i++) {
                values[i] = br.readLine();
            }
            Arrays.sort(values, (String a, String b) -> b.length() - a.length());
            // 정수들 중 가장 긴 길이
            int maxSize = values[0].length();
            // 일관성 구하는 함수 실행
            String result = process(values, maxSize) ? "YES" : "NO";

            bw.write(result + "\n");
        }

        bw.flush();

    }

    // 일관성 구하는 함수
    private static boolean process(String[] numbers, int maxSize) {
        HashSet<String> sets = new HashSet<>();
        // 1. values 값을 정수화하여 sets에 저장
        for (int i = 0; i < numbers.length; i++) {
            sets.add(numbers[i]);
        }
        // 2. values / 10 을 반복하며 sets에 동일한 값이 있는지 비교
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (!numbers[j].isEmpty()) {
                    numbers[j] = numbers[j].substring(0, numbers[j].length() - 1);
                }
                // 동일한 값이  존재하면 일관성 없는 목록
                if (sets.contains(numbers[j])) {
                    return false;
                }
            }
        }
        // 3. 위 반복문에서 걸리지 않았으면 일관성 있는 목록
        return true;
    }
}