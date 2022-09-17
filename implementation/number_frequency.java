package implementation;

import java.io.*;
import java.util.StringTokenizer;

public class number_frequency {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.toString(i + 1);
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            String output = arr[i];
            for (int j = 0; j < output.length(); j++) {
                if (output.charAt(j) - '0' == d) {
                    cnt += 1;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}