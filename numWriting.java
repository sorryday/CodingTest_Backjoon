import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

class numWriting {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long cnt = Long.parseLong(br.readLine());
        long result = 0;

        for (long i = 1; i <= cnt; i *= 10) {
            result += cnt - i + 1;
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}