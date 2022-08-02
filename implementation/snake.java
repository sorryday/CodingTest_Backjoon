package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.TimeoutException;

class snake {

    static int[][] map;
    static Map<Integer, String> move = new HashMap<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int d = 0; // 방향

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 보드 크기
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine()); // 사과의 개수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            move.put(time, dir);
        }

        int result = 0;
        int px = 0;  // 뱀의 현재 위치
        int py = 0;  // 뱀의 현재 위치

        Queue<Integer> body = new LinkedList<>();
        body.add(0);

        while (true) {
            int xf = px + dx[d];  // 머리 한칸 이동
            int yf = py + dy[d];  // 머리 한칸 이동
            result += 1;

            // 머리가 벽에 닿았을 떄
            if (xf < 0 || yf < 0 || xf > N - 1 || yf > N - 1) {
                break;
            }

            // 머리가 몸에 닿았을 떄
            if(body.contains(yf * N + xf)) {
                break;
            }

            if (map[yf][xf] == 1) {
                map[yf][xf] = 0;
                body.add(yf * N + xf);
            }
            else {
                body.add(yf * N + xf);  // 머리를 집어넣고
                body.poll();   // 꼬리를 뺀다.
            }

            // 방향 전환
            if (move.containsKey(result)) {
                String TempDir = move.get(result);
                if (TempDir.equals("D")) {
                    d += 1;
                    if(d == 4) {  // 인덱스가 마지막보다 하나 크다면
                        d = 0;  // 0으로 초기화
                    }
                } else {
                    d -= 1;
                    if (d == -1) {
                        d = 3;
                    }
                }
            }

            px = xf;
            py = yf;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}