package graphOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class connection_element {
    static int [][] num;  // 인접행렬
    static int result = 0;  // 연결 요소 개수
    static int N, M; // 정점, 간선의 개수
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수

        num = new int [N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            num[t1][t2] = 1;
            num[t2][t1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int startNode) {
        if(visited[startNode]) {
            return;
        }

        else {
            visited[startNode] = true;
            for (int i = 1; i <= N; i++) {
                if (num[startNode][i] == 1 && visited[i] == false) {
                    dfs(i);
                }
            }
        }

    }
}

