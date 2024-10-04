import java.io.*;
import java.util.*;

public class Main {

    private static Singer[] ararys;
    private static Queue<Integer> queue = new LinkedList<>();

    private static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ararys = new Singer[n + 1];
        for (int i = 1; i <= n; i++) {
            ararys[i] = new Singer();
        }
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int length = Integer.parseInt(temp[0]) + 1;
            for (int j = 1; j < length; j++) {
                if (j + 1 < length) {
                    ararys[Integer.parseInt(temp[j + 1])].preCount++;
                    ararys[Integer.parseInt(temp[j])].nextNumber.add(Integer.parseInt(temp[j + 1]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        if(solution()){
            System.out.println(0);
        } else {
            bw.flush();
        }
    }

    private static boolean solution() throws IOException {
        int count = 0;
        while (queue.size() > 0) {
            if(count > ararys.length){
                return true;
            }
            int num = queue.poll();
            count++;
            if(ararys[num].preCount <= 0){
                bw.write(num + "\n");
                count = 0;
                for (int i = 0; i < ararys[num].nextNumber.size(); i++) {
                    ararys[ararys[num].nextNumber.get(i)].preCount--;
                }
            } else {
                queue.add(num);
            }
        }
        return false;
    }

    private static class Singer {

        public int preCount;
        public ArrayList<Integer> nextNumber;

        public Singer() {
            this.preCount = 0;
            nextNumber = new ArrayList<>();
        }
    }
}