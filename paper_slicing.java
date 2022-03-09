import java.io.*;
import java.util.*;

public class paper_slicing {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		ArrayList<Integer> ho = new ArrayList<Integer>();  // 가로 저장 
		ArrayList<Integer> ve = new ArrayList<Integer>();  // 세로 저장

		ho.add(Integer.parseInt(st.nextToken()));
		ve.add(Integer.parseInt(st.nextToken()));

		int cnt = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0; i < cnt; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);

			int num = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken()); // 자를 번호 줄

			if(num == 0) {  // 가로로 자르라고 한다면
				int point = 0;
				
				for(point = 0; target - ve.get(point) > 0; point++) {
					target -= ve.get(point);
				}
				int temp = ve.remove(point);
				ve.add(point, temp - target);
				ve.add(point, target);
			}

			else {  // 세로로 자르라고 한다면
				int point = 0;
				
				for(point = 0; target - ho.get(point) > 0; point++) {
					target -= ho.get(point);
				}
				int temp = ho.remove(point);
				ho.add(point, temp - target);
				ho.add(point, target);
			}
		}

		for(int i : ho) {
			for(int j : ve) {
				result = Math.max(i * j, result);
			}
		}

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}