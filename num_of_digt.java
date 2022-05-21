import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class num_of_digt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 0;

        while (true) {
            num++;
            String s = Integer.toString(num);

            if (s.contains("666")) {
                cnt++;
            }

            if (cnt == N) {
                break;
            }
        }

        bw.write(Integer.toString(num));
        bw.flush();
        bw.close();
        br.close();
    }
}