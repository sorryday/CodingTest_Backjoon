package simulation;

import java.io.*;
import java.util.*;

class water_bottle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        while (true) {
            int temp = result + N;
            int cnt = 0;

            while (temp > 0) {
                if (temp % 2 != 0) {
                    cnt += 1;
                }
                temp /= 2;
            }

            if (cnt <= K) {
                break;
            }

            result += 1;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
