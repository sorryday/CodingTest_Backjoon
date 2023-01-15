package implementation;

import java.io.*;
import java.util.*;

public class SortWord {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] inputArr = br.readLine().toCharArray();
            int idx_1 = -1;
            int idx_2 = 0;

            for (int i = inputArr.length - 1; i > 0; i--) {
                if (inputArr[i - 1] < inputArr[i]) {
                    idx_1 = i - 1;
                    break;
                }
            }

//            입력으로 주어진 단어로 만들 수 있는 단어를 사전 순으로 정렬했을 때,
//            가장 먼저오는 문자열이 입력으로 주어진 문자열과 같을 때를 말한다.
            if (idx_1 == -1) {
                for (int i = 0; i < inputArr.length; i++) {
                    bw.write(inputArr[i]);
                }
                bw.write("\n");
            } else {
                for (int i = inputArr.length - 1; i >= 0; i--) {
                    if (inputArr[idx_1] < inputArr[i]) {
                        idx_2 = i;
                        break;
                    }
                }
                char temp = inputArr[idx_1];
                inputArr[idx_1] = inputArr[idx_2];
                inputArr[idx_2] = temp;

                Arrays.sort(inputArr, idx_1 + 1, inputArr.length);
                for (int i = 0; i < inputArr.length; i++) {
                    bw.write(Character.toString(inputArr[i]));
                }

                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
