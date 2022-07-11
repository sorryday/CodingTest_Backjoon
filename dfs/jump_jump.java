package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class jump_jump {
    static int rockCnt = 0;
    static int[] rock;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rockCnt = Integer.parseInt(br.readLine());
        rock = new int[rockCnt + 1];
        visited = new boolean[rockCnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= rockCnt; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
        }

        int location = Integer.parseInt(br.readLine());
        visited[location] = true;
        cnt += 1;

        dfs(location);

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int lo) {
        if (!visited[lo]) {
            visited[lo] = true;
        }

        int LeftLo = lo - rock[lo];
        int RightLo = lo + rock[lo];

        if (LeftLo <= rockCnt  && LeftLo >= 1 && !visited[LeftLo]) {
            cnt += 1;
            dfs(LeftLo);
        }
        if (RightLo <= rockCnt && RightLo >= 1 && !visited[RightLo]) {
            cnt += 1;
            dfs(RightLo);
        }
    }
}
