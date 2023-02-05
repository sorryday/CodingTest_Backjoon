package brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HighBuilding {
    static class Point {
        int x;
        long y;

        public Point(int x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> buildingPointList;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        buildingPointList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildingPointList.add(new Point(i + 1, Integer.parseInt(st.nextToken())));
        }

        // 리스트를 하나씩 돌면서 기준점 객체의 인덱스를 넘겨줌
        for (int i = 0; i < N; i++) {
            max = Math.max(max, (leftCnt(i) + rightCnt(i)));
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    // 왼쪽 탐색
    private static int leftCnt(int idx) {
        // 기준점 1
        Point p1 = buildingPointList.get(idx);
        int cnt = 0;

        for (int i = 0; i < idx; i++) {
            // 기준점 2
            Point p2 = buildingPointList.get(i);

            // 1차함수 만들기 : f(x) = ax + b;
            double a = (double) (p1.y - p2.y) / (p1.x - p2.x);
            double b = (double) p1.y - (a * p1.x);

            // 기준점 1과 기준점 2로 만든 함수의 y값 보다 그 사이에 있는 빌딩들의 높이 값이 작다면 기준점 2는 볼 수 있는 건물
            boolean flag = true;
            for (int j = i + 1; j <= idx - 1; j++) {
                if (a * buildingPointList.get(j).x + b <= buildingPointList.get(j).y) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt += 1;
            }
        }
        return cnt;
    }

    // 오른쪽 탐색
    private static int rightCnt(int idx) {
        // 기준점 1
        Point p1 = buildingPointList.get(idx);
        int cnt = 0;

        for (int i = idx + 1; i < buildingPointList.size(); i++) {
            // 기준점 2
            Point p2 = buildingPointList.get(i);

            // 1차함수 만들기 : f(x) = ax + b;
            double a = (double) (p1.y - p2.y) / (p1.x - p2.x);
            double b = (double) p1.y - (a * p1.x);

            // 기준점 1과 기준점 2로 만든 함수의 y값 보다 그 사이에 있는 빌딩들의 높이 값이 작다면 기준점 2는 볼 수 있는 건물
            boolean flag = true;
            for (int j = idx + 1; j <= i - 1; j++) {
                if (a * buildingPointList.get(j).x + b <= buildingPointList.get(j).y) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt += 1;
            }
        }
        return cnt;
    }
}