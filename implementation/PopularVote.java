package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PopularVote {
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int hap = 0;
            int max = 0;

            list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(br.readLine()));
                hap += list.get(j);

                max = Math.max(max, list.get(j));
            }

            // 최다 득표가 여러명일 경우
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (list.get(j) == max) {
                    cnt += 1;
                }
            }
            if (cnt > 1) {
                bw.write("no winner" + "\n");
                continue;
            }

            // 과반수 득표
            if (max > (hap / 2)) {
                int idx = list.indexOf(max) + 1;
                bw.write("majority winner" + " " +  idx + "\n");
                continue;
            }

            // 과반수 득표가 아닐 경우
            if (max <= (hap / 2)) {
                int idx = list.indexOf(max) + 1;
                bw.write("minority winner" + " " + idx + "\n");
                continue;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}