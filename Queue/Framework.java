package Queue;
import java.util.LinkedList;
import java.util.Queue;
public class Framework {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>(); // ArrayDeque
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
