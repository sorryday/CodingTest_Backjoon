package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ants {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx_1 = Integer.parseInt(st.nextToken());
        int idx_2 = Integer.parseInt(st.nextToken());

        String first = br.readLine();
        String second = br.readLine();

        StringBuffer sb = new StringBuffer(first);
        first = sb.reverse().toString();

        String[] ants = (first + second).split("");
        int[] dir = new int[ants.length];
        for (int i = 0; i < idx_1 + idx_2; i++) {
            if (i < idx_1) {
                dir[i] = 1;
            } else {
                dir[i] = 2;
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            for (int i = 0; i < idx_1 + idx_2 - 1; i++) {
                if (dir[i] == 1 && dir[i + 1] == 2) {
                    String temp = ants[i + 1];
                    ants[i + 1] = ants[i];
                    ants[i] = temp;

                    int tempIdx = dir[i];
                    dir[i] = dir[i + 1];
                    dir[i + 1] = tempIdx;

                    i++;
                }
            }
        }

        for (int i = 0; i < ants.length; i++) {
            bw.write(ants[i]);
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
