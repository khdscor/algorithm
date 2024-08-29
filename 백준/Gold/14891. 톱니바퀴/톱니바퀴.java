import java.io.*;

public class Main {

    public static int[][] gear = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();
        String input4 = br.readLine();
        for (int i = 0; i < 8; i++) {
            gear[0][i] = Integer.parseInt(String.valueOf(input1.charAt(i)));
            gear[1][i] = Integer.parseInt(String.valueOf(input2.charAt(i)));
            gear[2][i] = Integer.parseInt(String.valueOf(input3.charAt(i)));
            gear[3][i] = Integer.parseInt(String.valueOf(input4.charAt(i)));
        }
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int gearNum = Integer.parseInt(input[0]);
            int direction = Integer.parseInt(input[1]);
            // 톱니 회전, from = -1, 0 , 1 연속 재귀 호출 시 이전 톱니의 영향을 도는 것인지 확인(-1 : 우측 톱니의 영향, 0 : 영향 x, 1 : 좌측 톱니의 영향)
            process(gearNum - 1, direction, 0);
        }
        // 결과 출력
        int result = gear[0][0] + gear[1][0] * 2 + gear[2][0] * 4 + gear[3][0] * 8;
        System.out.println(result);
    }


    private static void process(int gearNum, int direction, int from) {
        // 좌측 톱니가 회전할 수 있는 경우
        if (from != 1 && gearNum - 1 >= 0 && (gear[gearNum][6] != gear[gearNum - 1][2])) {
            process(gearNum - 1, direction * (-1), -1);
        }
        // 우측 톱니가 회전할 수 있는 경우
        if (from != -1 && gearNum + 1 < 4 && (gear[gearNum][2] != gear[gearNum + 1][6])) {
            process(gearNum + 1, direction * (-1), 1);
        }
        if (direction == 1) {
            // 방향이 시계방향인 경우
            rotation(gearNum);
        } else {
            // 반시계 방향인 경우
            reverseRotation(gearNum);
        }
    }

    private static void rotation(int gearNum) {
        int firstValue = gear[gearNum][7];
        for (int i = 6; i >= 0; i--) {
            gear[gearNum][i + 1] = gear[gearNum][i];
        }
        gear[gearNum][0] = firstValue;
    }

    private static void reverseRotation(int gearNum) {
        int firstValue = gear[gearNum][0];
        for (int i = 0; i < 7; i++) {
            gear[gearNum][i] = gear[gearNum][i + 1];
        }
        gear[gearNum][7] = firstValue;
    }
}