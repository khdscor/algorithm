import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] words = new int[26];
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            words[input.charAt(i) - 'A']++;
        }
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if(words[i] % 2 != 0){
                if(odd != -1 || input.length() % 2 == 0){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else {
                    odd = i;
                }
            }
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if(words[i] > 0){
                for (int j = 0; j < words[i] / 2; j++) {
                    result += (char)(i + 65);
                }
            }
        }

        String reverse = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            reverse += result.charAt(i);
        }
        String oddString = odd != -1 ? String.valueOf((char)(odd + 65)) : "";
        System.out.println(result + oddString + reverse);
    }
}