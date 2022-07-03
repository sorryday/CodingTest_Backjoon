import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class sugar {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) {
            bw.write("-1");
        }
        else if (N % 5 == 0) {
            bw.write(Integer.toString(N / 5));
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            bw.write(Integer.toString((N / 5) + 1));
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            bw.write(Integer.toString((N / 5) + 2));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}