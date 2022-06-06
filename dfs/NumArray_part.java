package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class NumArray_part {
    static int N;
    static int S;
    static int cnt = 0;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        if(S == 0) {
            bw.write(Integer.toString(cnt - 1));
        }
        else {
            bw.write(Integer.toString(cnt));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int location, int value) {
        if(location == N) {
            if(value == S) {
                cnt += 1;
            }
            return;
        }

        dfs(location + 1, value + list.get(location));
        dfs(location + 1, value);
    }
}