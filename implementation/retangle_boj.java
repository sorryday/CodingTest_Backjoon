package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class retangle_boj {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            // 점인 경우 : c
            if ( ((p1 == x2) && (q1 == y2)) || ((x1 == p2) && (q1 == y2)) ||
                    ((p1 == x2) && (y1 == q2)) || ((x1 == p2) && (y1 == q2)) ) {
                bw.write("c" + "\n");
            }

            // 공통 부분이 없는 경우 : d
            else if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                bw.write("d" + "\n");
            }

            // 선분 : b
            else if (p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) {
                bw.write("b" + "\n");
            }

            // 직사각형 : a
            else {
                bw.write("a" + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
