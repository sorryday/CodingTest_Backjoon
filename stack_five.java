import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class stack_five {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      String input = br.readLine();
      int cnt = Integer.parseInt(br.readLine());
  
      LinkedList<Character> arr = new LinkedList<Character>();

      for(int i = 0; i < input.length(); i++){
         arr.add(input.charAt(i)); 
      }

      ListIterator<Character> iter = arr.listIterator();
      while(iter.hasNext()) {
			iter.next();
		}

      for(int i = 0; i < cnt; i++){
         String cli = br.readLine();
         char c = cli.charAt(0);

         if(c == 'L'){
            if(iter.hasPrevious()){
               iter.previous();
            }
         }

         else if(c == 'D'){
            if(iter.hasNext()){
               iter.next();
            }
         }

         else if(c == 'B'){
            if(iter.hasPrevious()){
               iter.previous();
               iter.remove();
            }
         }

         else if(c == 'P'){
            char temp = cli.charAt(2);
            iter.add(temp);
         }
      }

      for(Character ch : arr){
         bw.write(ch);
      }

      bw.flush();
      bw.close();
      br.close();
   }
}