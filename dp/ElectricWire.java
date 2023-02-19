package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ElectricWire {
    static class Line {
        int A;
        int B;

        public Line(int a, int b) {
            A = a;
            B = b;
        }
    }

    static List<Line> lineList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lineList.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.A - o2.A;
            }
        });

        int[] dp = new int[T];

        for (int i = 0; i < T; i++) {
            Line line_i = lineList.get(i);
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                Line line_j = lineList.get(j);

                if (line_j.B < line_i.B) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
        bw.write(Integer.toString(T - dp[T - 1]));

        bw.flush();
        bw.close();
        br.close();
    }
}
