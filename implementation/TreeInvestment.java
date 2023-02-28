package implementation;

import java.io.*;
import java.util.*;

// 백준 16235 나무 재테크
// Tip : 정렬 부분
// -> 일년이 지날 때마다 정렬을 시도하면 시간 초과 발생
public class TreeInvestment {
    static int N, M, K;
    static int[][] map;             // 나무가 자랄 수 있는 양분이 있는 map
    static int[][] foodArr;        // 줄 수 있는 양분이 저장되어 있는 map

    static class Tree {
        int x;
        int y;
        int age;
        boolean isDead;				// 나무가 죽었는지 확인하는 boolean flag

        public Tree(int x, int y, int age, boolean isDead) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.isDead = isDead;
        }
    }

    static List<Tree> liveTreeList = new ArrayList<>();  // 현재 살아있는 나무의 리스트
    static Queue<Integer> deadTreeQueue = new ArrayDeque<>();  // 죽어있는 나무의 큐

    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 초기 값 셋팅
        foodArr = new int[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                foodArr[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        // 나무의 초기 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int tx = Integer.parseInt(st.nextToken()) - 1;
            int ty = Integer.parseInt(st.nextToken()) - 1;
            int tAge = Integer.parseInt(st.nextToken());

            liveTreeList.add(new Tree(tx, ty, tAge, false));
        }

        while (K-- > 0) {
            // 봄
            springTree();
            // 여름
            summerTree();
            // 가을
            fallTree();
            // 겨울
            winterTree();
        }

        bw.write(Integer.toString(liveTreeList.size()));
        bw.flush();
        bw.close();
        br.close();
    }

    // 봄 함수
    private static void springTree() {

        for (int i = 0; i < liveTreeList.size(); i++) {
            Tree tree = liveTreeList.get(i);

            // 나무가 영양분을 섭취할 수 있다면
            if (map[tree.x][tree.y] >= tree.age) {
                map[tree.x][tree.y] -= tree.age;
                tree.age += 1;
                continue;
            }

            // 섭취할 수 없다면 dead 큐에 객체를 넘기는 것이 아니라
            deadTreeQueue.add(i);
        }
    }

    // 여름 함수
    private static void summerTree() {
        while (!deadTreeQueue.isEmpty()) {

            Tree tree = liveTreeList.get(deadTreeQueue.poll());

            int age = tree.age;
            map[tree.x][tree.y] += age / 2;

            tree.isDead = true;
        }
    }

    // 가을 함수
    private static void fallTree() {
        // 새로운 나무가 저장될 리스트
        List<Tree> newTreeList = new ArrayList<>();

        for (int i = 0; i < liveTreeList.size(); i++) {
            Tree tree = liveTreeList.get(i);

            if (!tree.isDead) {
                int x = tree.x;
                int y = tree.y;

                if (tree.age % 5 == 0) {

                    for (int j = 0; j < 8; j++) {
                        int xf = x + dx[j];
                        int yf = y + dy[j];

                        if (xf >= 0 && xf < N && yf >= 0 && yf < N) {
                            newTreeList.add(new Tree(xf, yf, 1, false));
                        }
                    }
                }
            }
        }

        // 새로운 나무가 나이가 적으므로 먼저 처리되어야 한다.
        for (Tree tree : liveTreeList) {
            if (!tree.isDead) {
                newTreeList.add(tree);
            }
        }

        liveTreeList = newTreeList;
    }

    // 겨울 함수
    private static void winterTree() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += foodArr[i][j];
            }
        }
    }
}