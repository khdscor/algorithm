import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    static long max = -1;
    static String maxResult = "";
    static long min = Long.MAX_VALUE;

    static String minResult = "";

    static int n;

    static String[] input;

    static ArrayList<Integer> temp = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for (int i = 0; i <= 9; i++) {
            temp.add(i);
            solution(i, 0);
            temp.remove(0);
        }
        System.out.println(maxResult);
        System.out.println(minResult);

    }

    static private void solution(int prev, int index){
        if(index == n){
            String value = "";
            for (int i = 0; i <= index; i++) {
                value += temp.get(i);
            }
            if(max < Long.parseLong(value)){
                max = Long.parseLong(value);
                maxResult = value;
            }
            if(min > Long.parseLong(value)){
                min = Long.parseLong(value);
                minResult = value;
            }
        }
        else {
            for (int i = 0; i <= 9; i++) {
                if (input[index].equals("<") && (prev < i) && !temp.contains(i)){
                    temp.add(i);
                    solution(i, index + 1);
                    temp.remove(index + 1);
                }
                if(input[index].equals(">") && (prev > i) && !temp.contains(i)){
                    temp.add(i);
                    solution(i, index + 1);
                    temp.remove(index + 1);
                }
            }
        }
    }
}