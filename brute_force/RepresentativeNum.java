package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RepresentativeNum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> idxList = new ArrayList<>();
        int old = Integer.MAX_VALUE;
        for (int i = 0; i < numList.size(); i++) {
            int first = numList.get(i);
            int sum = 0;

            for (int j = 0; j < numList.size(); j++) {
                int second = numList.get(j);
                sum += Math.abs(first - second);
            }

            if (old > sum) {
                idxList.clear();
                idxList.add(numList.get(i));
                old = sum;
            } else if (old == sum) {
                idxList.add(numList.get(i));
            }
        }

        Collections.sort(idxList);
        bw.write(Integer.toString(idxList.get(0)));
        bw.flush();
        bw.close();
        br.close();
    }
}
