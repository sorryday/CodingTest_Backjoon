import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class stack_six {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      Queue<Integer> qu = new LinkedList<Integer>();
      int cnt = Integer.parseInt(br.readLine());

      int last = 0;

      for(int i = 0; i < cnt; i++){
         String input = br.readLine();
         
         if(input.contains("push")){
            String[] t_string = input.split(" ");
            int t_int = Integer.parseInt(t_string[1]);
            qu.add(t_int);
            last = t_int;
         }

         else if(input.equals("pop")){
            if(qu.isEmpty()){
               System.out.println(-1);
            }
            else{
               System.out.println(qu.poll());
            }
         }

         else if(input.equals("size")){
            System.out.println(qu.size());
         }

         else if(input.equals("empty")){
            if(qu.isEmpty()){
               System.out.println(1);
            }
            else{
               System.out.println(0);
            }
         }

         else if(input.equals("front")){
            if(qu.isEmpty()){
               System.out.println(-1); 
            }
            else{
               System.out.println(qu.peek());
            }
         }

         else if(input.equals("back")){
            if(qu.isEmpty()){
               System.out.println(-1);
            }
            else{
               System.out.println(last);
            }
         }
      }

      br.close();
   }
}