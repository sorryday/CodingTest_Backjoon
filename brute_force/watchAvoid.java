package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class watchAvoid {
    static int N;
    static boolean[][] visited;
    static char [][] map;

    static class TeacherPoint {
        int x;  // row
        int y;  // column

        public TeacherPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 선생의 위치를 담을 리스트
    static List<TeacherPoint> teacherPointList = new ArrayList<>();
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 선생님은 T, 학생은 S, 장애물은 O
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        // map에 정보 담기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'T') {
                    teacherPointList.add(new TeacherPoint(i, j));
                }
            }
        }

        obstacleBackTracking(3);

        bw.write("NO");
        bw.flush();
        bw.close();
        br.close();
    }

    // 장애물을 놓는 함수
    // obstacleCnt : 남아있는 장애물 수
    private static void obstacleBackTracking(int obstacleCnt) throws Exception {
        if (obstacleCnt == 0) {
            searchStart();
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == 'X'){
                        visited[i][j] = true;
                        map[i][j] = 'O';

                        obstacleBackTracking(obstacleCnt - 1);

                        visited[i][j] = false;
                        map[i][j] = 'X';
                    }
                }
            }
        }
    }

    // 장애물을 놓은 후 선생이 있는 위치부터 탐색을 시작하는 함수
    private static void searchStart() throws Exception {
        int isNotSeeCnt = 0;   // 학생을 보지 못한 선생의 수
        for (int i = 0; i < teacherPointList.size(); i++) {
            TeacherPoint searchPoint = teacherPointList.get(i);

            // 선생의 양옆 위아래를 탐색했을 때 학생을 보지 못했다면 isNotSeeCnt를 하나 증가시켜줌
            if (rowSearch(searchPoint) && columnSearch(searchPoint)) {
                isNotSeeCnt += 1;
            }
        }

        // 모든 학생이 감시로부터 피한 것
        if (isNotSeeCnt == teacherPointList.size()) {
            bw.write("YES");
            bw.flush();
            bw.close();
            br.close();

            System.exit(0);
        }
    }

    // 선생의 위치에서 row를 탐색하는 함수 ( row를 탐색한다는건 열 값이 움직인다.)
    private static boolean rowSearch(TeacherPoint searchPoint) throws Exception {
        // 현재 선생님의 컬럼값 위치에서 0까지 탐색
        for (int j = searchPoint.y - 1; j >= 0; j--) {

            // 학생을 발견한다면
            if (map[searchPoint.x][j] == 'S') {
                return false;   // 학생을 발견했다.
            } else if (map[searchPoint.x][j] == 'O') { // 장애물을 발견 했다면
                break;
            }
        }

        // 현재 선생님의 컬럼값부터 N - 1 까지탐색
        for (int j = searchPoint.y + 1; j < N; j++) {

            // 학생을 발견한다면
            if (map[searchPoint.x][j] == 'S') {
                return false;  // 학생을 발견했다.
            } else if (map[searchPoint.x][j] == 'O') { // 장애물을 발견 했다면
                break;
            }
        }

        return true; // 학생을 발견하지 못햇다
    }

    // 선생의 위치에서 Column을 탐색하는 함수(
    private static boolean columnSearch(TeacherPoint searchPoint) throws Exception {

        // 0부터 현재 선생님의 컬럼값 이전까지 탐색
        for (int j = searchPoint.x - 1; j >= 0; j--) {

            // 학생을 발견한다면
            if (map[j][searchPoint.y] == 'S') {
                return false; // 학생을 발견하지 못햇다
            } else if (map[j][searchPoint.y] == 'O') { // 장애물을 발견 했다면
                break;
            }
        }

        // 0부터 현재 선생님의 컬럼값 이전까지 탐색
        for (int j = searchPoint.x + 1; j < N; j++) {

            // 학생을 발견한다면
            if (map[j][searchPoint.y] == 'S') {
                return false; // 학생을 발견하지 못햇다
            } else if (map[j][searchPoint.y] == 'O') { // 장애물을 발견 했다면
                break;
            }
        }

        return true; // 학생을 발견하지 못햇다
    }
}
