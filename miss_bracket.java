import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class miss_bracket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < input.length; i++) {

            if(input[i].contains("+")) {
                String[] temp = input[i].split("\\+");
                int t_int = 0;
                for (int j = 0; j < temp.length; j++) {
                    t_int += Integer.parseInt(temp[j]);
                }
                if(i == 0) {
                    result += t_int;
                }
                else {
                    result -= t_int;
                }
            }

            else {
                if(i == 0) {
                    result += Integer.parseInt(input[i]);
                }
                else {
                    result -= Integer.parseInt(input[i]);
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}