import java.io.*;
import java.util.*;

public class group {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if(str.equals("add")) {
                list.add(Integer.parseInt(st.nextToken()));
			}
            
			if(str.equals("remove")) {
                list.remove(Integer.valueOf(Integer.parseInt(st.nextToken())));
			}
            
			if(str.equals("check")) {
				int input = Integer.parseInt(st.nextToken());

				if(list.contains(input)) {
					bw.write(String.valueOf(1)+"\n");
				}
				else {
					bw.write(String.valueOf(0)+"\n");
				}
			}
            
			if(str.equals("toggle")) {
				int input = Integer.parseInt(st.nextToken());

				if(list.contains(input)) {
					list.remove(Integer.valueOf(input));
				}
				else {
					list.add(input);
				}
			}
            
			if(str.equals("all")) {
				list.clear();

				for(int j = 1; j <= 20; j++) {
					list.add(j);
				}
			}
            
			if(str.equals("empty")) {
				list.clear();
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}