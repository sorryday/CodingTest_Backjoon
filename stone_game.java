import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class stone_game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 1 || N == 3) {
            bw.write("SK");
        }
        else if(N == 2) {
            bw.write("CY");
        }
        else {
            if(N % 2 == 1) {
                bw.write("SK");
            }
            else {
                bw.write("CY");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}