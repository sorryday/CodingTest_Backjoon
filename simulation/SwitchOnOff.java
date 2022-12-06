package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class SwitchOnOff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchCnt = Integer.parseInt(br.readLine());
        int[] switchArr = new int[switchCnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            switch (sex) {
                case 1:
                    for (int i = switchNum; i <= switchCnt; i = i + switchNum) {
                        switchArr[i] = switchArr[i] == 0 ? 1 : 0;
                    }
                    break;

                case 2:
                    if (switchNum == 1 || switchNum == switchCnt) {
                        switchArr[switchNum] = switchArr[switchNum] == 0 ? 1 : 0;
                    } else if (switchArr[switchNum - 1] != switchArr[switchNum + 1]) {
                        switchArr[switchNum] = switchArr[switchNum] == 0 ? 1 : 0;
                        break;
                    } else {
                        int start = switchNum - 2;
                        int end = switchNum + 2;

                        while (true) {
                            if (start < 1 || end > switchCnt) {
                                break;
                            } else {
                                if (switchArr[start] != switchArr[end]) {
                                    break;
                                } else {
                                    start--;
                                    end++;
                                }
                            }
                        }

                        for (int i = start + 1; i <= end - 1; i++) {
                            switchArr[i] = switchArr[i] == 0 ? 1 : 0;
                        }
                    }
                    break;
            }
            --T;
        }

        for (int i = 1; i <= switchCnt; i++) {
            bw.write(Integer.toString(switchArr[i]) + " ");
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}