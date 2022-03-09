import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bunhahap {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int hap = Integer.parseInt(br.readLine()); // 분해합
        int result = Integer.MAX_VALUE;
        
        for(int i = 1; i < hap; i++) {
            String temp = Integer.toString(i);
            int temp_int = 0;               // 자리수의 합

            for(int j = 0; j < temp.length(); j++) {
                temp_int += temp.charAt(j) - '0';
            }

            if(hap == i + temp_int) {
                result = Math.min(result, i);
            }
        }

        if(result == Integer.MAX_VALUE) {
            bw.write(Integer.toString(0));
        }

        else {
            bw.write(Integer.toString(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
