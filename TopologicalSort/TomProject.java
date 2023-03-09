package TopologicalSort;

import java.io.*;
import java.util.*;

public class TomProject {
    static int N; // 학생수
    static int[] inDegree; // 진입 차수를 체크할 배열
    static List<Integer> list;
    static List<Integer>[] inList; // 인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            // 입력 초기화
            inList = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                inList[j] = new ArrayList<Integer>();
            }

            inDegree = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int from = j;
                int to = Integer.parseInt(st.nextToken());

                inList[from].add(to);
                inDegree[to] += 1;
            }

            // 학생들의 관계를 탐색할 위상 정렬 BFS
            list = new ArrayList<Integer>();
            nonTeamStudentBFS();

            // 결과 출력
            bw.write(Integer.toString(list.size()) + "\n");
        }

        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }

    // 위상정렬 BFS
    private static void nonTeamStudentBFS() {
        Queue<Integer> q = new ArrayDeque<Integer>();
        // 진입 차수가 0인 애들 q에 offer
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        // 큐가 빌 때까지
        while (!q.isEmpty()) {
            int poll = q.poll();
            list.add(poll);

            for (int i = 0; i < inList[poll].size(); i++) {
                if (inList[poll].get(i) != null && --inDegree[inList[poll].get(i)] == 0) {
                    q.add(inList[poll].get(i));
                }
            }
        }
    }
}