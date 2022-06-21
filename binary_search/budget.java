package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class budget {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int counrty = Integer.parseInt(br.readLine());
        long[] budget_list = new long[counrty];
        long temp_result = 0;

        long min = 0;
        long mid = 0;
        long max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < counrty; i++) {
            budget_list[i] = Integer.parseInt(st.nextToken());
            temp_result += budget_list[i];

            if(max < budget_list[i]) max = budget_list[i];
        }

        long budget = Long.parseLong(br.readLine());

        if(temp_result <= budget) {
            Arrays.sort(budget_list);
            bw.write(Long.toString(budget_list[counrty - 1]));
        }
        else {
            max += 1;

            while (min < max) {
                mid = (min + max) / 2;
                long temp_hap = 0;

                for (int i = 0; i < counrty; i++) {
                    if(mid >= budget_list[i]) {
                        temp_hap += budget_list[i];
                    }
                    else {
                        temp_hap += mid;
                    }
                }

                if(temp_hap <= budget) {
                    min = mid + 1;
                }

                else {
                    max = mid;
                }
            }
            bw.write(Long.toString(min - 1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
