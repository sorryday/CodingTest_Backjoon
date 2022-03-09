import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack_four {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      Stack<Integer> st = new Stack<Integer>();

      int cnt = Integer.parseInt(br.readLine());
      int first = 0;

      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < cnt; i++){
         int temp = Integer.parseInt(br.readLine());

         if(st.isEmpty() || first < temp){
            for(int j = first + 1; j <= temp; j++){
               st.push(j);
               sb.append("+");   
            }
            
            first = temp;
         }         

         if(st.peek().equals(temp)){
            st.pop();
            sb.append("-");
         }

         else if(!st.peek().equals(temp)) {
            System.out.println("NO");
            System.exit(0);
         }
      }
      
      String t_String = sb.toString();
      for(int k = 0; k < t_String.length(); k++){
         bw.write(t_String.charAt(k) + "\n");
      }

      bw.flush();
      bw.close();
      br.close();
   }
}