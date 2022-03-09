import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class stack_three {
   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      Stack<Character> st = new Stack<Character>();
      int cnt = Integer.parseInt(br.readLine());

      for(int i = 0; i < cnt; i++){
         String input = br.readLine();

         for(int j = 0; j < input.length(); j++){
            if(input.charAt(j) == '('){
               st.push('(');
            }

            else if (input.charAt(j) == ')'){
               if(st.isEmpty()){
                  st.push(')');
               }

               if(st.peek().equals('(')){
                  st.pop();
               } 
            }
         }

         if(st.isEmpty()){  
            System.out.println("YES");
         }
         else if (!st.isEmpty()){
            System.out.println("NO");
         }
         st.clear();
      }

      br.close();
   }
}