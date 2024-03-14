import java.util.Stack;

public class code2 {

    static String s = "";

    public static void main(String[] args) {
        if (isValid(s)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    static public boolean isValid(String s) {

        if (s == null || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++){

            if (s.charAt(i) == '}'){
                if (st.peek() != '{'){
                    return false;
                }
                st.pop();
            }
            else if (s.charAt(i) == ']'){
                if (st.peek() != '['){
                    return false;
                }
                st.pop();
            }
            else if (s.charAt(i) == ')'){
                if (st.peek() != '('){
                    return false;
                }
                st.pop();
            }
            else {
                st.push(s.charAt(i));
            }

        }
        return true;
    }
}
