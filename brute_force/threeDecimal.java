package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class threeDecimal {
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        visited = new boolean[1001];      // 소수를 저장할 visited 배열(false가 소수)
        decimalSetting();                       // 에라토스테네스의 체 함수

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            boolean isNotFlag = false;
            boolean isCorrectFlag = false;

            for (int j = 2; j < input; j++) {
                if (isCorrectFlag) continue;
                for (int k = 2; k < input; k++) {
                    if (isCorrectFlag) continue;
                    for (int l = 2; l < input; l++) {
                        if (isCorrectFlag) continue;

                        if (!visited[j] && !visited[k] && !visited[l]) {
                            int sum = j + k + l;
                            if (sum == input) {
                                List<Integer> list = new ArrayList<>();
                                list.add(j);
                                list.add(k);
                                list.add(l);

                                Collections.sort(list);

                                bw.write(list.get(0) + " " + list.get(1) + " " + list.get(2) +"\n");
                                isNotFlag = true;
                                isCorrectFlag = true;
                            }
                        }
                    }
                }
            }

            if (!isNotFlag) {
                bw.write("0" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void decimalSetting() {
        for (int i = 2; i < 1001; i++) {
            if(!visited[i]) {
                for (int j = i * i; j < 1001; j += i) {
                    visited[j] = true;
                }
            }
        }
    }
}