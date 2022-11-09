import java.io.*;

public class PalindromeString {

    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input = br.readLine();
            int left = 0;
            int right = input.length() - 1;

            // 회문이면
            if (Palindrome(left, right)) {
                bw.write("0" + "\n");
                continue;
            }

            // 회문이 아니면
            if (NotPalindrome(left, right)) {
                bw.write("1" + "\n");
            } else {
                bw.write("2" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 회문인지 검사
    private static boolean Palindrome(int left, int right) {
        while(left <= right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 회문이 아닐때
    private static boolean NotPalindrome(int left, int right) {
        while(left <= right) {
            if(input.charAt(left) != input.charAt(right)) {
                boolean a = Palindrome(left + 1,right);
                boolean b = Palindrome(left,right - 1);

                if(a == false && b == false) {
                    return false;
                } else{
                    return true;
                }

            }
            left++;
            right--;
        }
        return true;
    }
}