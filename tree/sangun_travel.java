package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class sangun_travel {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // test case 시작
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = 0;
            int[][] map = new int[N + 1][N + 1];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                map[b][a] = 1;
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[j][k] == 1) {
                        if((!list.contains(j) || !list.contains(k))) {
                            list.add(j);
                            list.add(k);
                            result += 1;
                        }
                    }
                }
            }
            bw.write(Integer.toString(N - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}