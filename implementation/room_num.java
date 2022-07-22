package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class room_num {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<Character> list = new ArrayList<>();
        double[] cnt = new double[10];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            list.add(c);
        }

        for (int i = 0; i < list.size(); i++) {
            char c = input.charAt(i);
            int c_int = c - '0';
            cnt[c_int] += 1;
        }

        double temp = (cnt[6] + cnt[9]) / 2;
        Math.round(temp);
        cnt[6] = temp;
        cnt[9] = 0;

        double max = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
            }
        }

        bw.write(String.format("%.0f", max));
        bw.flush();
        bw.close();
        br.close();
    }
}
