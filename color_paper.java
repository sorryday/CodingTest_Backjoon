import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class color_paper {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine()); // 색종이 개수
		int[][] pan = new int[1001][1001];

		for(int i = 1; i <= cnt; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken()), top = Integer.parseInt(st.nextToken());

			// 배열을 90도로 돌려서 생각하기 (일반적인 배열이 됨, 높이랑 너비랑 바꿔서 생각)
			for(int j = x; j < x + bottom; j++) {
				for(int k = y; k < y + top; k++) {
					pan[j][k] = i;
				}
			}
		}

		// 원소 개수 구하기
		for(int q = 1; q <= cnt; q++) {
			int count = 0;

			for(int j = 0; j < 1001; j++) {
				for(int k = 0; k < 1001; k++) {
					if(pan[j][k] == q) {
						count += 1;
					}	
				}
			}
			bw.write(count + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}