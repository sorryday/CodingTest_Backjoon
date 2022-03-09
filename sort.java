import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sort {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int arr_n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < arr_n; i++) {
            arr.add(Integer.parseInt(st.nextToken())); 
        }

        int S = Integer.parseInt(br.readLine());

        int moveCnt = 0, changeIdx = 0;
        while (moveCnt < S && changeIdx < arr_n - 1) {
            int maxNum = arr.get(changeIdx);
            int maxIdx = -1;

            int idx = changeIdx + 1;
            int count = 1;
            while (moveCnt + count <= S && idx < arr_n) {
                int num = arr.get(idx);
                if (num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count += 1;
                idx += 1;
            }

            if (maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx += 1;
        }

        for(int j = 0; j < arr.size(); j++) {
           System.out.print(arr.get(j) + " ");
        }

        br.close();
    }
}