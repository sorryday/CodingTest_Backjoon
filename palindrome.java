import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class palindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(Integer.toString(problem(input)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int problem(String input) {
        int len = input.length();

        for (int i = 0; i < len; i++) {
            if (isPal(input.substring(i))) {
                return len + i;
            }
        }

        return len;
    }
    static boolean isPal(String input) {
        int len = input.length();
        for (int i = 0; i < (len) / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
