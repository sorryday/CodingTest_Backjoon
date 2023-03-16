package UnionFind;

import java.io.*;

import java.util.StringTokenizer;

public class CycleGame {
    static int N; // 노드수
    static int M; // 간선 수
    static int[] parent; // 각 노드의 부모를 저장할 배열
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // make-Set
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        // 입력을 받을 때 마다 확인
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 유니온
            // 부모를 찾아봤을 때 (find) 부모가 같으면 사이클이 발생한 것
            if (find(x) == find(y)) {
                result = i + 1;
                break;
            } else {
                union(x, y);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 유니온
    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px > py) {
            parent[px] = py;
        } else if (px < py){
            parent[py] = px;
        }
    }

    // 부모를 찾는 find
    private static int find(int idx) {
        if (idx == parent[idx])
            return idx;

        return parent[idx] = find(parent[idx]);
    }
}

