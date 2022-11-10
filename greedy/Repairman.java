package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Repairman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> locationList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            locationList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(locationList);

        int cnt = 1;
        double range = locationList.get(0) - 0.5;
        for (int i = 0; i < locationList.size(); i++) {
            if (range + L < locationList.get(i)) {
                cnt++;
                range = locationList.get(i) - 0.5;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}