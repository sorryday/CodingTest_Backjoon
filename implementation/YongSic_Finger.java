package implementation;

import java.io.*;

public class YongSic_Finger {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long hurt = Long.parseLong(br.readLine());
        long num = Long.parseLong(br.readLine());
        long result;

        if(hurt == 1) {
            result = (long)(num * 8);
        } else if(hurt == 2) {
            result = (long)(1 + (num / 2) * 8 + (num % 2) * 6);
        } else if(hurt == 3) {
            result = (long)(2 + (num / 2) * 8 + (num % 2) * 4);
        } else if(hurt == 4) {
            result = (long)(3 + (num / 2) * 8 + (num % 2) * 2);
        } else {
            result = (long)(4 + num * 8);
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}