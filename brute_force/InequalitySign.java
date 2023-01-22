package brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class InequalitySign {
    static boolean[] visited;
    static int K;
    static List<String> s_list = new ArrayList<>();
    static String[] s_array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        s_array = new String[(2 * K) + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            s_array[(2 * i) - 1] = st.nextToken();
        }

        // 사용한 숫자를 표시하는 visited[]
        visited = new boolean[10];
        listBack(0);

        Collections.sort(s_list);
        bw.write(s_list.get(s_list.size() - 1) + "\n" +  s_list.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void listBack(int idx) {
        if (idx > s_array.length) {
            if (isCorrect(s_array)) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < s_array.length; i++) {
                    sb.append(s_array[i]);
                }
                s_list.add(sb.toString().replaceAll(">", "").replaceAll("<", ""));
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            s_array[idx] = Integer.toString(i);

            listBack(idx + 2);
            visited[i] = false;
        }
    }

    private static boolean isCorrect(String[] s_array) {
        for (int i = 0; i < s_array.length; i++) {
            if (s_array[i].equals(">")) {
                if (Integer.parseInt(s_array[i - 1]) < Integer.parseInt(s_array[i + 1])) {
                    return false;
                }
            } else if (s_array[i].equals("<")) {
                if (Integer.parseInt(s_array[i - 1]) > Integer.parseInt(s_array[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}

