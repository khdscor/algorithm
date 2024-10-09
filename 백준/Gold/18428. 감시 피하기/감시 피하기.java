import java.io.*;
import java.util.*;

public class Main {

    private static char[][] array;

    private static int n;

    // left, right, down, up
    private static int[] dx = {1, -1, 0, 0};

    private static int[] dy = {0, 0, 1, -1};

    private static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = input[j].charAt(0);
            }
        }
        solution(0, 0, 0);
        System.out.println(result ? "YES" : "NO");
    }


    private static void solution(int index, int i, int j){
        if(index == 3){
            boolean temp = true;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    if(array[k][l] == 'T'){
                        if(oversight(k, l, 0)){
                            temp = false;
                        }
                        if(oversight(k, l, 1)){
                            temp = false;
                        }
                        if(oversight(k, l, 2)){
                            temp = false;
                        }
                        if(oversight(k, l, 3)){
                            temp = false;
                        }
                    }
                }
            }
            if(temp){
                result = true;
            }
        } else {
            for (int k = i; k < n; k++) {
                for (int l = j; l < n; l++) {
                    if(array[k][l] == 'X'){
                        array[k][l] = 'O';
                        solution(index + 1, k, l + 1);
                        array[k][l] = 'X';
                    }
                }
                j = 0;
            }
        }
    }

    private static boolean oversight(int i, int j, int d){
        // 벽에 부딛힐 경우
        if(i + dy[d] < 0 || j + dx[d] < 0 || i + dy[d] >= n || j + dx[d] >= n){
            return false;
        }
        // 장애물에 부딛힐 경우
        if(array[i + dy[d]][j + dx[d]] == 'O'){
            return false;
        }
        // 학생에 부딛힐 경우
        if(array[i + dy[d]][j + dx[d]] == 'S'){
            return true;
        }
        // 한칸 전진
        return oversight(i + dy[d], j + dx[d], d);
    }
}