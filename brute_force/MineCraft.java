package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class MineCraft {
    static int N, M, B;
    static int[][] map;

    static class mineCraftObject {
        int time;
        int height;

        public mineCraftObject(int time, int height) {
            this.time = time;
            this.height = height;
        }
    }
    // 탐색을 하면서 시간과 높이를 저장할 객체 List
    static List<mineCraftObject> mineCraftObjectList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int max = 0;  // 최소 블록 높이
        int min = 0;  // 최대 블록 높이

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0 && j == 0) {
                    max = min = map[i][j];
                } else {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    } else if (min > map[i][j]) {
                        min = map[i][j];
                    }
                }
            }
        }

        for (int i = min; i <= max; i++) { // i 높이로 맞춘다고 생각하고 반복문을 돈다.
            mineCraft(i);
        }

        // 탐색을 끝낸 후 시간에 대하여 오름차순 정렬 ( 만약 시간이 같다면 높이로 정렬 )
        Collections.sort(mineCraftObjectList, new Comparator<mineCraftObject>() {
            @Override
            public int compare(mineCraftObject o1, mineCraftObject o2) {
                if (o1.time == o2.time) {
                    return o2.height - o1.height; // 시간이 같다면 높이를 내림차순으로 정렬
                }
                return o1.time - o2.time;
            }
        });

        bw.write(Integer.toString(mineCraftObjectList.get(0).time) + " " + Integer.toString(mineCraftObjectList.get(0).height));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mineCraft(int i) {
        int timeTemp = 0;
        int bag = B;

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                int standardHeight = map[j][k] - i; // 현재 탐색하고 있는 map의 자리가 i 높이가 되기위해
                // 채워야 하는지, 빼야하는지를 알 수 있게 하기 위한 값
                if (standardHeight > 0) {  // 현재 위치의 블럭 높이가 i보다 높으므로 빼야한다.
                    int absHeight = Math.abs(standardHeight);
                    timeTemp += (2 * absHeight);
                    bag += absHeight;
                } else if (standardHeight < 0) { // 현재 위치의 블럭 높이가 i보다 낮으므로 더해야 한다.
                    int absHeight = Math.abs(standardHeight);
                    timeTemp += Math.abs(absHeight);
                    bag -= Math.abs(absHeight);
                }
            }
        }

        // 탐색을 끝내고 난 후 가방에 있는 블록의 개수가 0보다 크거나 같아야함 (음수면 블럭을 안쓴게 된 것!!)
        if (bag >= 0) {
            mineCraftObjectList.add(new mineCraftObject(timeTemp, i));
        }
    }
}