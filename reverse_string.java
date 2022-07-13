import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class reverse_string {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "0");
        StringTokenizer st2 = new StringTokenizer(input, "1");

        bw.write(Integer.toString(Math.min(st.countTokens(), st2.countTokens())));
        bw.flush();
        bw.close();
        br.close();
    }
}