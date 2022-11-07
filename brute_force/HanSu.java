package brute_force;

import java.io.*;

public class HanSu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i <= 99) {
                result += 1;
                continue;
            }

            boolean flag = true;

            String NumToString = Integer.toString(i);
            int differentNum = (NumToString.charAt(0) - '0') - (NumToString.charAt(1) - '0');

            for (int j = 1; j < NumToString.length() - 1; j++) {
                int differentLoop = (NumToString.charAt(j) - '0') - (NumToString.charAt(j + 1) - '0');
                if ((differentLoop) != (differentNum)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}