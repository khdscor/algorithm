import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        System.out.println(Math.round(binarySearch(x, y, c) * 1000) / 1000.0);
    }

    private static double binarySearch(double x, double y, double c) {
        double left = 0.0;
        double right = Math.min(x, y);
        double result = 0.0;
        int count = 0;
        while (left <= right) {
            count++;
            if(count >= 1000000){
                break;
            }
            double mid = Math.round(((left + right) / 2) * 100000) / 100000.0;
            double temp = (Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2))) * (mid - (c * mid) / Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2))) / mid;
            if (temp < c) {
                right = mid - 0.000001;
                result = mid;
            } else if (temp > c) {
                left = mid + 0.000001;
            } 
        }
        return result;
    }
}