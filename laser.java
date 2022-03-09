import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class laser {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String input = br.readLine();
      Stack<Character> st = new Stack<Character>();
      int cnt = 0;
      
      for(int i = 0; i < input.length(); i++) {
         if(input.charAt(i) == '(') {
            st.push(input.charAt(i));
         }

         if(input.charAt(i) == ')') {
            st.pop();
         
            if(input.charAt(i - 1) == '('){ 
              cnt += st.size();
            }

            else {
               cnt += 1;
            }
         }
      }
      System.out.print(cnt);
      br.close();
	}
}