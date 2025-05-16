package Stack;
import java.util.*;
public class Simplify_Path {
    static String simplify(String A){
        Stack<String> st = new Stack<String>();
        String res = "";
        res += "/";
        int len_A = A.length();
        for (int i = 0; i < len_A; i++){
            StringBuilder dir = new StringBuilder();
            while (i < len_A && A.charAt(i) == '/'){
                i++;
            }
            while (i < len_A && A.charAt(i) != '/'){
                dir.append(A.charAt(i));
                i++;
            }
            if (dir.toString().equals("..")){
                if (!st.empty()){
                    st.pop();
                }
            }
            else if (dir.toString().equals(".")){
                continue;
            }
            else if (!dir.isEmpty()){
                st.push(dir.toString());

            }
        }
        Stack<String> st1 = new Stack<String>();
        while (!st.empty()){
            st1.push(st.pop());
        }
        while (!st1.empty()){
            if (st1.size() != 1){
                res += (st1.pop() + "/");
            }
            else {
                res += st1.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = new String("/a/./b/../../c/");
        System.out.println(simplify(str));
    }
}
