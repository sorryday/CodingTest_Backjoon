package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int result = 0;

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            friendDFS(0, i);
            visited[i] = false;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void friendDFS(int depth, int start) throws IOException {

        if (depth == 4) {
            result = 1;
            bw.write(Integer.toString(result));
            bw.flush();
            bw.close();
            br.close();

            System.exit(0);
        }

        for (int i = 0; i < list[start].size(); i++) {
            if (visited[list[start].get(i)]) continue;

            visited[list[start].get(i)] = true;
            friendDFS(depth + 1, list[start].get(i));
            visited[list[start].get(i)] = false;
        }
    }
}
