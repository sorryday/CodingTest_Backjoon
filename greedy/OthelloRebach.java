package greedy;

import java.io.*;

public class OthelloRebach {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int length = Integer.parseInt(br.readLine());
            String first = br.readLine();
            String second = br.readLine();

            int W_Count = 0;
            int B_Count = 0;
            int ans = 0;

            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    if (first.charAt(j) == 'W') {
                        W_Count++;
                    } else {
                        B_Count++;
                    }
                }
            }
            ans += Math.min(W_Count, B_Count) + Math.abs(W_Count - B_Count);
            bw.write(Integer.toString(ans) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}