package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class link_start {
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited; // 팀을 나누기 위한 boolean 배열
    static int N;
    static BufferedWriter bw;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // map의 크기
        map = new int[N][N];
        visited = new boolean[N];  // true : 스타트팀, false : 링크팀

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setTeam(0, 1);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 팀원을 셋팅하는 함수
    // idx : 스타트 팀원을 고를 인덱스
    // depth : 스타트팀의 인원의 수
    private static void setTeam(int idx, int depth) throws Exception {
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
            }

            if (depth <= N / 2) {
                statsHap();
            } else {
                return;
            }

            setTeam(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    // 능력치 합을 최소가 되는 것을 찾는 함수
    private static void statsHap() throws Exception {
        int startTeamHap = 0;
        int linkTeamHap = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 스타트팀 합
                if (visited[i] && visited[j]) {
                    startTeamHap += map[i][j];
                }

                // 링크팀 합
                if (!visited[i] && !visited[j]) {
                    linkTeamHap += map[i][j];
                }
            }
        }

        if (startTeamHap == linkTeamHap) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();

            System.exit(0);
        } else {
            result = Math.min(result, Math.abs(startTeamHap - linkTeamHap));
        }
    }
}