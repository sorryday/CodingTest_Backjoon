import java.io.*;
import java.util.*;

public class warehouse {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxH = 0;
		int maxIndex = -1;
		int[] map = new int[1001];   // 기둥의 높이 값 저장 배열

		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = Integer.parseInt(st.nextToken()); // 횟수
		for(int i = 0; i < cnt; i++){
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			map[L] = H;

			if(map[L] > maxH) {
				maxH = map[L];
				maxIndex = L;
			}
		}

		int result = 0;
		int temp = 0;

		// 정방향으로 돌기
		for(int i = 0; i < maxIndex; i++) {
			if(map[i] > temp) {
				temp = map[i];
			}

			result += temp;
		}
		temp = 0;

		// 역방향 돌기 
		for(int i = map.length - 1; i > maxIndex; i--) {
			if(map[i] > temp) {
				temp = map[i];
			}

			result += temp;
		}
		result += maxH;

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}