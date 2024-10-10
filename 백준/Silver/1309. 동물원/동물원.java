import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dP = new int[n+1][3];
        dP[1][0] = 1;
        dP[1][1] = 1;
        dP[1][2] = 1;

        for(int i = 2; i<= n ;i++){
            dP[i][0] = (dP[i-1][0] + dP[i-1][1] + dP[i-1][2])%9901;
            dP[i][1] = (dP[i-1][0] + dP[i-1][2])%9901;
            dP[i][2] = (dP[i-1][0] + dP[i-1][1])%9901;
        }
        System.out.println((dP[n][0]+dP[n][1]+dP[n][2])%9901);
    }
}