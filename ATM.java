import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<Integer>();

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        
        for(int i = 0; i < cnt; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[list.size()];
        int result = 0;
        
        Collections.sort(list);
        dp[0] = list.get(0);

        for(int i = 1; i < list.size(); i++) {
            dp[i] = list.get(i) + dp[i - 1];
        }

        for(int i = 0; i < dp.length; i++) {
            result += dp[i];
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}