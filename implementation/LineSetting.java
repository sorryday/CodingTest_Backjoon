package implementation;

import java.io.*;

public class LineSetting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        int s = 0;
        for(int i = 0; i < T - 1; i++) {
            s += arr[i].compareTo(arr[i + 1]) > 0 ? 1 : -1;
        }
        if(s == T - 1) {
            bw.write("DECREASING");
        } else if(s == 1 - T) {
            bw.write("INCREASING");
        } else {
            bw.write("NEITHER");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}