package TopologicalSort;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class ACMCraft {
    static int N, K, W; // N : 건물 개수, K : 규칙 개수, W : 이기기 위해 지어야 하는 건물
    static Map<Integer, Integer> buildingMap; // 건물을 짓기 위한 비용이 저장된 맵
    static List<Integer>[] inList; // 인접리스트
    static int[] inDegree; // 진입 차수 배열
    static int result = 0; // 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 비용을 맵에 저장
            buildingMap = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                buildingMap.put(i, Integer.parseInt(st.nextToken()));
            }

            // 인접 리스트 초기화
            inList = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                inList[i] = new ArrayList<>();
            }

            // 진입 차수 배열 초기화
            inDegree = new int[N + 1];

            // 인접 리스트 구성
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                inList[from].add(to);
                inDegree[to]++;
            }

            // 최종적으로 지어야 하는 건물 입력
            W = Integer.parseInt(br.readLine());

            // 위상정렬 함수 실행
            AcmTopologicalSort();

            // 결과를 버퍼에 출력
            bw.write(result + "\n");
            result = 0;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 위상 정렬 함수
    private static void AcmTopologicalSort() {
        Queue<Integer> q = new ArrayDeque<>();
        int[] tempTimeArr = new int[N + 1];

        // 진입 차수가 0인 노드를 모두 q에 offer
        // 이 떄 건물을 짓는 시간을 임시 배열에 대입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                tempTimeArr[i] = buildingMap.get(i);
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();

            // 꺼낸 노드가 최종적으로 필요한 건물이라면 건물을 짓는데 걸린 시간을 result에 대입
            if (poll == W) {
                result = Integer.max(result, tempTimeArr[poll]);
            }

            for (int i = 0; i < inList[poll].size(); i++) {
                int next = inList[poll].get(i);

                if (inList[poll].size() != 0) {
                    // 현재 노드(건물)를 건설하는 데 걸리는 시간 vs 이전 노드를 건설하는데 걸리는 시간 + 현재 노드(건물)를 건설하는 데 걸리는 시간
                    tempTimeArr[next] = Math.max(tempTimeArr[next], tempTimeArr[poll] + buildingMap.get(next));
                }

                // 다음 노드의 진입 차수가 0이라면 큐에 넣는다.
                if (--inDegree[next] == 0) {
                    q.add(next);
                }
            }

        }
    }
}