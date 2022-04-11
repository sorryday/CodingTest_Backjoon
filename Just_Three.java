import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Just_Three {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<Integer> list = new ArrayList<>();

        int cnt = 0;

        list.add(input.charAt(0) - '0');

        for (int i = 1; i < input.length(); i++) {
            int c = input.charAt(i) - '0';
            if(c - (input.charAt(i - 1) - '0') == 1) {
                list.add(c);
            }

            else {
                if(list.size() == 3) {
                    cnt += 1;
                    list.clear();
                    list.add(c);
                }
                else if(list.size() >= 4){
                    list.clear();
                    list.add(c);
                }

                else {
                    list.clear();
                }
            }
        }

        if(list.size() == 3) {
            cnt += 1;
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}