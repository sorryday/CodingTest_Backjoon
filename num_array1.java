import java.io.*;
import java.util.*;

public class num_array1 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < (N - K) + 1 ; i++) {
			int temp = 0;
			for(int j = i; j < i + K; j++) {
				temp += num[j];
			}
			if(temp > result) {
				result = temp;
			}
		}

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}