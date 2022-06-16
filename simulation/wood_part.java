package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class wood_part {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] list = new int[5];
        StringTokenizer st = new StringTokenizer(input);
        int flag = 0;

        for (int i = 0; i < 5; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            for (int i = 0; i < 4; i++) {
                if(list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    for (int j = 0; j < 5; j++) {
                        System.out.print(list[j] + " ");
                    }
                    System.out.println();
                }
            }

            for (int i = 0; i < 5; i++) {
                if(list[i] == i + 1) {
                    flag += 1;
                }
            }

            if(flag == 5) {
                break;
            }
            else {
                flag = 0;
            }
        }
    }
}