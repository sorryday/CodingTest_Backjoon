package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PipeMan {
    static int N; // 지도의 행 수
    static int M; // 지도의 열 수

    static int result = 0;
    static boolean[] visited; // 방문 배열 DFS
    static boolean[] isCycled; //
    static List<Integer>[] inList; // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력을 받아 변수 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접리스트 만들기
        inList = new ArrayList[N * M];
        for (int i = 0; i < N * M; i++) {
            inList[i] = new ArrayList<>();
        }

        // 인접 리스트 초기화
        // 배열의 하나의 값 당 가질 수 있는 방향은 하나밖에 없으므로 인접 리스트 구성이 가능
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (input.charAt(j)) {
                    case 'U':
                        inList[idx].add(idx - M);
                        break;

                    case 'D':
                        inList[idx].add(idx + M);
                        break;

                    case 'L':
                        inList[idx].add(idx - 1);
                        break;

                    case 'R':
                        inList[idx].add(idx + 1);
                        break;
                }
                idx++;
            }
        }

        // 방문배열 초기화
        visited = new boolean[N * M];
        isCycled = new boolean[N * M];

        // DFS 함수 실행
        for (int i = 0; i < N * M; i++) {
            if (!isCycled[i]) {
                pipeDFS(i);
            }
        }

        //결과 출력
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // DFS 함수
    private static void pipeDFS(int idx) {
        // 이미 방문한 노드라면
        if (visited[idx]) {
            // 방문은 했는데 처리를 안해준 노드라면
            if (!isCycled[inList[idx].get(0)]) {
                isCycled[idx] = true;
                result++;
            }
            return;
        }

        // 내 다음 노드가 이미 처리된 노드라면
        if (isCycled[inList[idx].get(0)]) {
            return;
        }

        // 지금 현재 노드 방문처리
        visited[idx] = true;

        // 다음 노드로 DFS
        pipeDFS(inList[idx].get(0));

        // 위의 DFS를 빠져 나왔다는건 사이클을 만나서 빠져 나왔다는 것!
        isCycled[idx] = true;
    }
}
