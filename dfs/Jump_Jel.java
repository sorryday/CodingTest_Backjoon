package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Jump_Jel {  // 점프왕 쩰리(small) - 16173
    static int[][] Grid;     // 값을 저장할 배열
    static boolean[][] visited;  // 방문했는지 판단하는 boolean 배열
    static int N = 0;           // 게임의 크기
    static String result;       // 결과 저장 String 객체
    static int[] dx = {1, -1, 0, 0};  // dx, dy : 탐색할 때 상하좌우로 한칸씩 이동하는 값 세팅
    static int[] dy = {0, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());  // 범위
        StringTokenizer st;

        Grid = new int[N][N];       // 경기판
        visited = new boolean[N][N];       // 방문했는지 판단하는 boolean

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                Grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);   // 맨 왼쪽부터 시작한다고 했으므로 인덱스인 0,0을 Arg로 시작

        if(result == null) {
            result = "Hing";
        }

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    static public void DFS(int Start_X, int Start_Y) {
        visited[Start_X][Start_Y] = true;
        int Jump_Value = Grid[Start_X][Start_Y];

        if(Jump_Value == -1) {    // 오른쪽 아래 끝에 도착했으면 HaruHaru를 입력하고 함수 종료
            result = "HaruHaru";
        }

        for (int i = 0; i <= 2; i = i + 2) {  // 오른쪽하고 아래만 움직일 수 있으므로 2번만 반복을 돌면됨, i == 0 : 아래, i == 1 오른쪽
            int xF = Start_X + (dx[i] * Jump_Value);   // Jump_Value를 곱해주는 이유는 그 값만큼을 점프하기 때문임
            int yF = Start_Y + (dy[i] * Jump_Value);

            if (xF >= N || yF >= N) {    // 배열의 범위를 넘어가면 도착하지 못 한 것이므로 넘김
                continue;
            }

            if (visited[xF][yF]) {
                continue;                           // 만약 방문했던 곳이면 넘김
            }

            DFS(xF, yF);                            // 자기자신 재귀호출
        }
    }
}