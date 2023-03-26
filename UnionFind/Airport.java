package UnionFind;

import java.io.*;

public class Airport {
    static int G, P;
    static int[] paraent;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        // make -set
        paraent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            paraent[i] = i;
        }

        // 방문배열 초기화
        visited = new boolean[G + 1];

        // 도킹시키는 비행기 입력
        for (int i = 0; i < P; i++) {
            // 비행기 번호
            int idx = Integer.parseInt(br.readLine());

            int fIdx = Find(idx);
            if (fIdx == 0) {
                break;
            } else {
                Union(fIdx - 1, idx);
                result++;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 유니온
    private static void Union(int x, int y) {
        int px = Find(x);
        int py = Find(y);

        if (px > py) {
            paraent[px] = py;
        } else if (py > px) {
            paraent[py] = px;
        }
    }

    // 파인드
    private static int Find(int x) {
        if (paraent[x] == x) {
            return x;
        }

        return paraent[x] = Find(paraent[x]);
    }
}

