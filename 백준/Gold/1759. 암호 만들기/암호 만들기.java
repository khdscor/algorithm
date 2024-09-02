import java.io.*;
import java.util.Arrays;

public class Main {

    public static char[] array;
    public static int l;
    public static int c;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        l = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);
        array = new char[c];
        for (int i = 0; i < c; i++) {
            array[i] = input2[i].charAt(0);
        }
        Arrays.sort(array);
        process(0, "", 0);
        bw.flush();
    }

    public static void process(int index, String value, int num) throws IOException {
        if (l == index) {
            // 조건 만족 여부 확인
            if (validate(value)) {
                // 결과 값 저장
                bw.write(value + "\n");
            }
        } else {
            for (int i = num; i < c; i++) {
                process(index + 1, value + array[i], i + 1);
            }
        }
    }

    private static boolean validate(String value) {
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == 'a' || value.charAt(i) == 'e' || value.charAt(i) == 'i' || value.charAt(i) == 'o' || value.charAt(i) == 'u') {
                count++;
            }
        }
        if (count >= 1 && l - count >= 2) {
            return true;
        }
        return false;
    }
}