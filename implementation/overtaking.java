package implementation;

import java.io.*;
import java.util.*;

public class overtaking {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        List<String> inputCar = new ArrayList<>();
        List<String> outputCar = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            inputCar.add(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            outputCar.add(br.readLine());
        }

        for (int i = 0; i < inputCar.size(); i++) {
            if (!inputCar.get(i).equals(outputCar.get(i))) {
                int index = inputCar.indexOf(outputCar.get(i));
                String s = inputCar.get(index);

                inputCar.remove(s);
                inputCar.add(i, s);
                cnt += 1;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}