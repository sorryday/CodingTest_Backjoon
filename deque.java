import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class deque {
   public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     Deque<Integer> dq = new LinkedList<Integer>();
     int cnt = Integer.parseInt(br.readLine());

     for(int i = 0; i < cnt; i++) {
      String input = br.readLine();
      String[] input_arr = input.split(" ");

      switch(input_arr[0]) {
         case "push_front" :
            int t1 = Integer.parseInt(input_arr[1]);
            dq.addFirst(t1);
         break;

         case "push_back" :
            int t2 = Integer.parseInt(input_arr[1]);
            dq.addLast(t2);
         break;

         case "pop_front" :
            if(dq.isEmpty()) {
               System.out.println(-1);
            }
            else {
               System.out.println(dq.removeFirst());
            }
         break;

         case "pop_back" :
            if(dq.isEmpty()) {
               System.out.println(-1);
            }
            else {
               System.out.println(dq.removeLast());
            }
         break;

         case "size" :
            System.out.println(dq.size());
         break;

         case "empty" :
            if(dq.isEmpty()){
               System.out.println(1);
            }
            else {
               System.out.println(0);
            }
         break;

         case "front" :
            if(dq.isEmpty()){
               System.out.println(-1);
            }
            else {
               System.out.println(dq.getFirst());
            }
         break;

         case "back" :
            if(dq.isEmpty()){
               System.out.println(-1);
            }
            else {
               System.out.println(dq.getLast());
            }
         break;
      }
     }

     br.close();
   }
}