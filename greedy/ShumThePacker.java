package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShumThePacker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if (N == 0) {
            bw.write("0");
        } else {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            int weight = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > M) {
                    continue;
                }

                if (weight + list.get(i) <= M) {
                    weight += list.get(i);
                } else {
                    cnt += 1;
                    weight = list.get(i);
                }
            }
            bw.write(Integer.toString(cnt + 1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
