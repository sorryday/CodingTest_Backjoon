package implementation;

import java.io.*;
import java.util.*;

public class word_split {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<String> stringList = new ArrayList<>();

        // 자를 수 있는 모든 경우의 수를 해보기
        for (int i = 1; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String tempString = new String();

                tempString += reverse_String_method(0, i, input);
                tempString += reverse_String_method(i, j, input);
                tempString += reverse_String_method(j, input.length(), input);

                stringList.add(tempString);
            }
        }

        Collections.sort(stringList);
        bw.write(stringList.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

    // 문자열 뒤집기
    private static String reverse_String_method(int i, int j, String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.substring(i, j));
        sb.reverse();
        return sb.toString();
    }
}