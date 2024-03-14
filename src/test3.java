import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '<' ){
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }

            st.push(str.charAt(i));



        }

        String reversedPassword = "";
        while (!st.isEmpty()){
            reversedPassword += st.pop().toString();
        }

        String pwd = "";

        for (int i = reversedPassword.length() - 1; i >= 0; i--){
            pwd += reversedPassword.substring(i, i+1);
        }

        if (pwd.length() < 8){
            System.out.println(pwd + ";false" );
            return;
        }

        boolean isAllBig = true;
        boolean isAllSmall = true;
        boolean isNoNum = true;
        boolean noAnotherChar = true;

        for (int i = 0; i < pwd.length(); i++){
            if (pwd.charAt(i) <= 'z' && pwd.charAt(i) >= 'a'){
                isAllBig = false;
            }

            if (pwd.charAt(i) <= 'Z' && pwd.charAt(i) >= 'A'){
                isAllSmall = false;
            }

            if (pwd.charAt(i) >= '0' && pwd.charAt(i) <= '9'){
                isNoNum = false;
            }

            if ((pwd.charAt(i) < 'a' || pwd.charAt(i) > 'z')
                    && (pwd.charAt(i) < 'A' || pwd.charAt(i) > 'Z')
                    && (pwd.charAt(i) < '0' || pwd.charAt(i) > '9')
            ){
                noAnotherChar = false;
            }
        }

        if (isNoNum || isAllBig || isAllSmall || noAnotherChar){
            System.out.println(pwd + ";false");
        }
        else {
            System.out.println(pwd + ";true");
        }

        return;


    }
}