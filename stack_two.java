import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stack_two {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int cnt = Integer.parseInt(br.readLine());

      for(int i = 0; i < cnt; i++){
         String input = br.readLine();
         String[] input_array = input.split(" ");
         
         for(int j = 0; j < input_array.length; j++){
            StringBuffer sb = new StringBuffer(input_array[j]);
            String re_string = sb.reverse().toString();
            System.out.print(re_string + " ");
         }

         System.out.println();
      }

      br.close();
   }
}