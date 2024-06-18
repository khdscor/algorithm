import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = Integer.MAX_VALUE;
        int count = 0;
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int[] bottom = new int[n/2];
        int[] top = new int[n/2];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(i % 2 == 0){
                bottom[i/2] = temp;
            } else {
                top[i/2] = temp;
            }
        }
        Arrays.sort(bottom);
        Arrays.sort(top);
        for (int i = 1; i <= h; i++) {
            int count1 = solutionBottom(i, bottom);
            int count2 = solutionTop(i, h, top);
            if(count1 + count2 < result){
                result = count1 + count2;
                count = 1;
            } else if(count1 + count2 == result){
                count++;
            }
        }
        System.out.println(result + " " + count);
    }

    private static int solutionBottom(int i, int[] bottom){
        int left = 0;
        int right = bottom.length - 1;
        int mid;
        int result = -1;
        while(left <= right){
            mid = (left + right) / 2;
            if(bottom[mid] < i){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(result < 0){
            return bottom.length;
        }
        return bottom.length - result - 1;
    }

    private static int solutionTop(int i, int h, int[] top){
        int left = 0;
        int right = top.length - 1;
        int mid;
        int result = -1;
        while(left <= right){
            mid = (left + right) / 2;
            if(h - top[mid] >= i){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(result < 0){
            return top.length;
        }
        return top.length - result - 1;
    }
}