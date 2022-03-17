import java.io.*;
import java.util.StringTokenizer;

public class Max_different {
    static int[] nums;
    static boolean[] visited;
    static int[] selected;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        visited = new boolean[n];
        selected = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int count) {
        if(count == n) {
            result = Math.max(getResult(), result);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[count] = nums[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    public static int getResult(){
        int sum = 0;
        for(int i = 0; i < n - 1; i++){
            sum += Math.abs(selected[i] - selected[i + 1]);
        }
        return sum;
    }
}