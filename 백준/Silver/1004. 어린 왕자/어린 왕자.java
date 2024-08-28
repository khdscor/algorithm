import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                String[] input2 = br.readLine().split(" ");
                int tempX = Integer.parseInt(input2[0]);
                int tempY = Integer.parseInt(input2[1]);
                int tempLength = Integer.parseInt(input2[2]);
                if(Math.sqrt(Math.pow(x1 - tempX, 2) + Math.pow(y1 - tempY, 2)) < tempLength){
                    count++;
                }
                if(Math.sqrt(Math.pow(x2 - tempX, 2) + Math.pow(y2 - tempY, 2)) < tempLength){
                    count++;
                }
                if(count == 1){
                    result++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}