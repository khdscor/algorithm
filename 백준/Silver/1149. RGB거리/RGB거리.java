import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] result = new int[3];
    int[] temp = new int[3];
    for (int i = 0; i < 3; i++) {
      result[i] = -1;
      temp[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        temp[j] = sc.nextInt();
        if (i == 0) {
          result[j] = temp[j];
          continue;
        }
        if (j == 0) {
          temp[j] = temp[j] + Math.min(result[1], result[2]);
          continue;
        }
        if (j == 1) {
          temp[j] = temp[j] + Math.min(result[0], result[2]);
          continue;
        }
        if (j == 2) {
          temp[j] = temp[j] + Math.min(result[0], result[1]);
          continue;
        }
      }
      for (int j = 0; j < 3; j++) {
        result[j] = temp[j];
      }
    }
    int min = Math.min(result[0], result[1]);
    min = Math.min(min, result[2]);
    System.out.println(min);
  }
}