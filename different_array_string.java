import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class different_array_string {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        String input = br.readLine();

        int index = 1;
        int cnt = 1;

        for (int i = 0; i < input.length(); i++) {
            for (int k = 0; k <= input.length() - index; k++) {
                String temp = input.substring(k, cnt);
                set.add(temp);
                cnt += 1;
            }
            index += 1;
            cnt = index;
        }

        System.out.println(set.size());
    }
}