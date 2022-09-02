package implementation;

import java.io.*;
import java.util.*;

public class num_game {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.MIN_VALUE;
        int num = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] cardList = new int[5];
            for (int j = 0; j < 5; j++) {
                cardList[j] = Integer.parseInt(st.nextToken());
            }

            int returnValue = firstMax(cardList);
            if (result <= returnValue) {
                result = returnValue;
                num = i + 1;
            }
        }

        bw.write(Integer.toString(num));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int firstMax(int[] cardList) {
        int max = Integer.MIN_VALUE;

        int length = cardList.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    String s = Integer.toString(cardList[i] + cardList[j] + cardList[k]);
                    max = Math.max(max, s.charAt(s.length() - 1) - '0');
                }
            }
        }
        return max;
    }
}