package implementation;

import java.io.*;
import java.util.StringTokenizer;

public class NBA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t, nTime, time, t_a, t_b, s;
        boolean chk;

        s = time = t_a = t_b = 0;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            chk = st.nextToken().equals("1") ? true : false;

            String str = st.nextToken();
            nTime = (str.charAt(0)-'0')*600;
            nTime += (str.charAt(1)-'0')*60;
            nTime += (str.charAt(3)-'0')*10;
            nTime += str.charAt(4)-'0';

            if (s > 0) {
                t_a += nTime - time;
            }
            if (s < 0) {
                t_b += nTime - time;
            }

            s += chk ? 1 : -1;
            time = nTime;
        }

        if (s > 0) {
            t_a += 2880 - time;
        }
        if (s < 0) {
            t_b += 2880 - time;
        }
        System.out.printf("%02d:%02d\n%02d:%02d\n",t_a/60,t_a%60,t_b/60,t_b%60);
    }
}