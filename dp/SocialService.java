package dp;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SocialService {
    static int N;
    static List<Integer>[] inList; // 인접리스트
    static int result = Integer.MAX_VALUE;
    static int[][] dp;  // dp[k][2] = r -> k노드가 얼리어답터이거나 얼리어답터가 아닐때 최소 얼리어답터 수 r
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        inList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            inList[i] = new ArrayList<>();
        }

        // 입력값으로 인접리스트 만들기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            inList[from].add(to);
            inList[to].add(from);
        }

        // dp 초기화
        dp = new int[N + 1][2]; // 0 : 얼리X, 1: 얼리O

        // 방문배열 초기화
        visited = new boolean[N + 1];

        // 인접리스트의 DFS, 루트 노드부터 시작
        snsDFS(1);

        // 결과 출력
        bw.write(Integer.toString(Math.min(dp[1][0], dp[1][1])));
        bw.flush();
        bw.close();
        br.close();
    }

    // 인접리스트의 DFS
    private static void snsDFS(int idx) {

        // 방문 처리
        visited[idx] = true;

        // 얼리어답터가 아닌 경우는 0, 얼리어답터가 맞는 경우는 1
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for (int i = 0; i < inList[idx].size(); i++) {
            if (inList[idx].get(i) != null && !visited[inList[idx].get(i)]) {
                snsDFS(inList[idx].get(i));

                // 만약 현재 노드가 얼리어 답터가 아니라면 나와 연결된 모든 노드가 얼리어 답터여야 한다.
                dp[idx][0] += dp[inList[idx].get(i)][1];

                // 현재 노드가 얼리어답터라면 나랑 연결된 노드가 얼리어답터일 수도 있고 아닐 수도 있다.
                dp[idx][1] += Math.min(dp[inList[idx].get(i)][1], dp[inList[idx].get(i)][0]);
            }
        }
    }
}