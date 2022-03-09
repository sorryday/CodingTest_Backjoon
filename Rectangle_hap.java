import java.io.*;
import java.util.*;

public class Rectangle_hap {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] map = new int[101][101];
		String str;
		StringTokenizer st;
		int result = 0;

		for(int i = 1; i <= 4; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int k = x1; k < x2; k++) {
				for(int j = y1; j < y2; j++) {
					map[k][j] = i;
				}
			}
		}

		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j] != 0) {
					result += 1;
				}
			}
		}

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}