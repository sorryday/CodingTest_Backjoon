package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NameCompatibility {
    static int[] engHeck = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first_name = br.readLine();
        String second_name = br.readLine();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < first_name.length(); i++) {
            sb.append(Character.toString(first_name.charAt(i)));
            sb.append(Character.toString(second_name.charAt(i)));
        }

        String full_name = sb.toString();
        List<Integer> name_num_list = new ArrayList<>();
        for (int i = 0; i < full_name.length(); i++) {
            name_num_list.add(engHeck[(full_name.charAt(i)) - 65]);
        }

        List<Integer> result_list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < name_num_list.size() - 1; i++) {
                int hap = name_num_list.get(i) + name_num_list.get(i + 1);
                if (hap >= 10) {
                    String hap_string = Integer.toString(hap);
                    result_list.add(hap_string.charAt(hap_string.length() - 1) - '0');
                }
                else {
                    result_list.add(hap);
                }
            }

            if (result_list.size() == 2) {
                break;
            }

            name_num_list.clear();
            for (int i = 0; i < result_list.size(); i++) {
                name_num_list.add(result_list.get(i));
            }
            result_list.clear();
        }

        bw.write(Integer.toString(result_list.get(0)) + Integer.toString(result_list.get(1)));
        bw.flush();
        bw.close();
        br.close();
    }
}