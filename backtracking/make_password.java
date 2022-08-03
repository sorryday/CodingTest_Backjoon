package backtracking;

import java.io.*;
import java.util.*;

class make_password {
    static char[] list; // 알파벳의 경우의 수
    static char[] code; // 결과 배열

    static int L;
    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());  // 뽑아야 하는 수
        C = Integer.parseInt(st.nextToken());  // 주어지는 알파벳 수

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        combi(0, 0);

        br.close();
    }

    private static void combi(int x, int idx) throws IOException {  // C개 중에서 L개를 뽑기

        if (idx == L) {
            if (isValid()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            combi(i + 1, idx + 1);
        }
    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}