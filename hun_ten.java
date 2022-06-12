import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hun_ten {
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] col = input.split(":");

        int result = LCD(col);
        bw.write(Integer.toString(Integer.parseInt(col[0]) / result) + ":" + Integer.toString(Integer.parseInt(col[1]) / result));
        bw.flush();
        bw.close();
        br.close();
    }

    static int LCD(String[] col) {
        int temp, n;
        int num1 = Integer.parseInt(col[0]);
        int num2 = Integer.parseInt(col[1]);

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        while(num2 != 0) {
            n = num1 % num2;
            num1 = num2;
            num2 = n;
        }
        return num1;
    }
}