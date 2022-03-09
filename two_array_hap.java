import java.io.*;
import java.util.*;

public class two_array_hap {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		// 2차원 배열 초기화
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		int cnt = Integer.parseInt(br.readLine());  // 횟수
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int j = x1 - 1; j <= x2 - 1; j++) {
				for(int k = y1 - 1; k <= y2 - 1; k++) {
					result += map[j][k];
				}
			}
			bw.write(Integer.toString(result) + "\n");
			result = 0;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}