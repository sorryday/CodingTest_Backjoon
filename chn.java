import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class chn {
	static boolean[] visited;
	static LinkedList<Integer>[] chn; // 촌수 저장 배열
	static int chn_result = -1; // 촌수 카운트
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine()); // 사람의 수
		visited = new boolean[cnt + 1];
		chn = new LinkedList[cnt + 1];

		for(int i = 1; i < cnt + 1; i++) {
			chn[i] = new LinkedList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		int chn_cnt = Integer.parseInt(br.readLine()); // 그래프 구성 반복횟수
		for(int i = 0; i < chn_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());

			chn[t1].add(t2); // 반대로 넣어주는 것! 왜냐하면 하나가 연결되면 다른 것도 연결됬다는 뜻
			chn[t2].add(t1);
		}

		dfs(n1, n2, 0);   // dfs 실행
		bw.write(Integer.toString(chn_result));
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int n1, int n2, int cnt) {
		if(n1 == n2) { // n1을 next로 바꿔가면서 n2랑 같아지면 서로 연결된 것
			chn_result = cnt;
			return;
		}

		visited[n1] = true;

		for(int i = 0; i < chn[n1].size(); i++) {
			int next = chn[n1].get(i);
			if(!visited[next]) {
				dfs(next, n2, cnt + 1);
			}
		}
	}
}