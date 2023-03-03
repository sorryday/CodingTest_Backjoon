import java.io.*;
import java.util.*;
import java.lang.*;

public class AppleTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int oddFlag = 0; // 해당 값이 홀수인지 판단하는 flag

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            sum += t;

            if (t % 2 == 1) {
                oddFlag += 1;
            }
        }

        // sum의 합이 3의 배수여야하고 홀수의 개수가 sum을 3으로 나눈 몫이 되야한다.
        if (oddFlag <= sum / 3 && (sum % 3) == 0) {
            bw.write("YES");
        }  else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}