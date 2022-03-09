import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class beer_walk {
	static int n = 0, sx = 0, sy = 0, dx = 0, dy = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for(int j = 0; j < t; j++) {   
			n = Integer.parseInt(br.readLine());  // 편의점 개수
			List<int[]> list = new ArrayList<>();

			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if(i == 0) {   // sx ,sy : 상근이네 집 좌표
					sx = x;
					sy = y;
				}
				else if(i == n + 1) { // dx, dy : 페스티벌 좌표
					dx = x;
					dy = y;
				}
				else {
					list.add(new int[]{x, y});  // 편의점 좌표
				}
			}
			
			bw.write(bfs(list)? "happy\n" : "sad\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];

		q.add(new int[] {sx, sy});

		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0], py = pos[1];

			if(Math.abs(px - dx) + Math.abs(py - dy) <= 1000) { // 편의점을 안거치고 20병 만으로 도착
				return true;
			}
			
			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					int nx = list.get(i)[0], ny = list.get(i)[1];
					int dis = Math.abs(px - nx) + Math.abs(py - ny);
					if(dis <= 1000) {
						visited[i] = true;
						q.add(new int[]{nx, ny});
					}
				}
			}
		}
		return false;
	}
}