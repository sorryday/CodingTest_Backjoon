import java.io.*;
import java.util.*;

public class FileSortting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> extensionList = new TreeMap<>();
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] splitString = input.split("\\.");

            if (extensionList.isEmpty()) {
                extensionList.put(splitString[1], 1);
            } else {
                if (extensionList.containsKey(splitString[1])) {
                    extensionList.put(splitString[1], extensionList.get(splitString[1]) + 1);
                    flag = true;
                }

                if (!flag) {
                    extensionList.put(splitString[1], 1);
                }
                flag = false;
            }
        }

        Iterator<Map.Entry<String, Integer>> itr = extensionList.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}