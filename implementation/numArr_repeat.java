package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class numArr_repeat {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        int d_temp = 0;
        for (int i = 0; i < A.length(); i++) {
            d_temp += Math.pow(A.charAt(i) - '0', P);
        }
        list.add(Integer.parseInt(A));
        list.add(d_temp);

        int i = 1;
        while (true) {
            String int_temp = Integer.toString(list.get(i));
            int temp_int = 0;

            for (int q = 0; q < int_temp.length(); q++) {
                temp_int += Math.pow(int_temp.charAt(q) - '0', P);
            }

            if(list.contains(temp_int)) {
                int index = list.indexOf(temp_int);
                bw.write(Integer.toString(index));
                break;
            }
            else {
                list.add(temp_int);
                i += 1;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}