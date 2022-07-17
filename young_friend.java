import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class young_friend {
    static int N, M, L;
    static int[] bound;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        bound = new int[N + 1];
        bound[1] = 1;

        int result = 0;
        int flag = 1;

        while (true) {
            if (bound[flag] == M) {
                break;
            }
            if (bound[flag] % 2 == 1) {
                flag = flag + L;
            } else {
                flag = flag - L;
            }

            if (flag > N) {
                flag %= N;
            }
            else if(flag < 1){
                flag += N;
            }

            bound[flag] += 1;
            result += 1;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}