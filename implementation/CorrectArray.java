package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorrectArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> numList = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numList);

        int cnt = 0;
        int minCnt = 0;
        int loopStand = T < 5 ? 1 : T;

        for (int i = 0; i < loopStand; i++) {
            int standardNum = numList.get(i) + 4;

            for (int j = 0; j < T - i; j++) {
                int compareNum = numList.get(i + j);
                if (compareNum >= numList.get(i) && compareNum <= standardNum) {
                    cnt += 1;
                }
            }
            minCnt = Math.max(cnt, minCnt);
            cnt = 0;
        }

        bw.write(Integer.toString(5 - minCnt));
        bw.flush();
        br.close();
    }
}