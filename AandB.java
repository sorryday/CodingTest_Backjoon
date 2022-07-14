import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class AandB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());

        while(s.length() < t.length()) {
            if(t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            }
            else if(t.charAt(t.length() - 1) == 'B'){
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if(s.toString().equals(t.toString())) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}