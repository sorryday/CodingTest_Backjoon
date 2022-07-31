package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class chicken_deli {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;  // 치킨집의 최대 개수
    static int result; // 결과 값
    static int[][] map;
    static boolean[] open;

    static List<Point> chicken = new ArrayList<>();
    static List<Point> house = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                }
                else if(map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
        chicken(0, 0);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void chicken(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, dist);
                    }
                }
                res += temp;
            }
            result = Math.min(res, result);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            chicken(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}
