package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
    static class TopObject {
        int height;
        int idx;
        public TopObject(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    static Stack<TopObject> topStack = new Stack<TopObject>();
    static StringBuilder sb = new StringBuilder();
    static int topCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        topCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < topCnt; i++) {
            TopObject nextTop = new TopObject(Integer.parseInt(st.nextToken()), i + 1);

            if (topStack.isEmpty()) {
                sb.append("0" + " ");
                topStack.push(nextTop);
            } else {
                while (true) {
                    if (topStack.isEmpty()) {
                        sb.append("0" + " ");
                        topStack.push(nextTop);
                        break;
                    }

                    if (topStack.peek().height > nextTop.height) {
                        sb.append(topStack.peek().idx + " ");
                        topStack.push(nextTop);
                        break;
                    } else {
                        topStack.pop();
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}