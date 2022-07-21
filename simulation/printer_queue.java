package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class printer_queue {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서가 queue에 몇 번째에 놓여 있는지
            int result = 0;

            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(new int[] {i, temp});
            }

            while (true) {
                int[] out = queue.remove();
                boolean flag = true;

                for (int[] output : queue) {
                    if (output[1] > out[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result += 1;
                    if (M == out[0]) {
                        break;
                    }
                }
                else {
                    queue.add(out);
                }
            }

            bw.write(Integer.toString(result) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
