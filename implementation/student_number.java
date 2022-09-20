package implementation;

import java.io.*;
import java.util.*;

public class student_number {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> studentList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(br.readLine());
            sb.reverse();
            studentList.add(sb.toString());
        }

        int result = 1;
        while (true) {
            Set<String> subStringList = new LinkedHashSet<>();
            for (int i = 0; i < result; i++) {
                for (int j = 0; j < N; j++) {
                    subStringList.add(studentList.get(j).substring(0, result));
                }
            }

            if (subStringList.size() == N) {
                break;
            }
            else {
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}