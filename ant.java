import java.io.*;
import java.util.*;

public class ant {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine()); // 이동할 시간	

		int xMove = t % (w * 2);  // w * 2만큼의 시간이 경과하면 제자리로 돌아온다
        int yMove = t % (h * 2);  // h * 2만큼의 시간이 경과하면 제자리로 돌아온다.
        
        boolean right = true;
        while(xMove-- > 0) {
            if(p == 0) {
				right = true;
			}
            if(p == w) {
				right = false;
			}
            
            if(right) {
				p++;
			}
            else { 
				p--;
			}
        }
        
        boolean up = true;
        while(yMove-- > 0) {
            if(q == 0) {
				up = true;
			}
            if(q == h) {
				up = false;
			}
            if(up) {
				q++;
			}
            else {
				q--;
			}
        }

		StringBuilder result = new StringBuilder();
		result.append(p + " " + q);
		bw.write(result.toString());
 		bw.flush();
		bw.close();
		br.close();
	}
}