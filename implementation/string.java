package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class string {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int Aleng = A.length();

        int result = 0;
        if (A.length() == B.length()) {
            for (int i = 0; i < B.length(); i++) {
                if(A.charAt(i) != B.charAt(i)) {
                    result += 1;
                }
            }
            bw.write(Integer.toString(result));
        }
        else {
            for (int i = 0; i <= B.length() - A.length(); i++) {
                int temp = 0;

                for (int j = 0; j < A.length(); j++) {
                    if(A.charAt(j) != B.charAt(i + j)) {
                        temp += 1;
                    }
                }
                Aleng = Math.min(Aleng, temp);
            }
            bw.write(Integer.toString(Aleng));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}