package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;

public class SpaceProbe {
    static int N, K;
    static int[][] inMatrix;
    static int resultTime = Integer.MAX_VALUE;
    static int[] printArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 인접행렬 값 초기화
        inMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워샬 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = 0; j < N; j++) {
                    if (j == i && j == k) continue;
                    inMatrix[i][j] = Math.min(inMatrix[i][k] + inMatrix[k][j], inMatrix[i][j]);
                }
            }
        }

        // 순열 함수
        printArr = new int[N];
        visited = new boolean[N];
        selectedSpace(0);

        // 결과
        bw.write(Integer.toString(resultTime));
        bw.flush();
        bw.close();
        br.close();
    }

    // 순열 함수
    private static void selectedSpace(int cnt) {
        if (cnt == N && printArr[0] == K) {
            int hap = 0;

            for (int i = 0; i < N - 1; i++) {
                hap += inMatrix[printArr[i]][printArr[i + 1]];
            }

            resultTime = Math.min(resultTime, hap);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            printArr[cnt] = i;
            selectedSpace(cnt + 1);
            visited[i] = false;
        }
    }
}
