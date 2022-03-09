import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack_one {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      Stack<Integer> st = new Stack<>();
      int cnt = Integer.parseInt(br.readLine());

      for(int i = 0; i < cnt; i++){
         String temp = br.readLine();

         if(temp.contains("push")){
            String spt[] = temp.split(" ");
				st.push(Integer.parseInt(spt[1]));
         }

         else if(temp.equals("pop")){
            if(st.isEmpty()){
               bw.write(-1 + "\n");
            }
            else {
               bw.write(st.pop() + "\n");
            }
         }

         else if(temp.equals("size")){
            bw.write(st.size() + "\n");
         }

         else if(temp.equals("empty")){
            if(st.isEmpty()){
               bw.write(1 + "\n");
            }

            else{
               bw.write(0 + "\n");
            }
         }

         else if (temp.equals("top")){
            if(st.isEmpty()){
               bw.write(-1 + "\n");
            }

            else{
               bw.write(st.peek() + "\n");
            }
         }
      }

      bw.flush();
      bw.close();
      br.close();
   }
}