import java.util.*;

public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String S = in.next();
        String L = in.next();

        int lastIdx = 0;

        int left = 0, right = 0;

        while (left < S.length() && right < L.length()){
            if (S.charAt(left) == L.charAt(right)){
                lastIdx = right;
                left++;
                right++;
            }
            else {
                right++;
            }
        }

        if (left == S.length() && S.charAt(left - 1) == L.charAt(right - 1)){
            System.out.println(lastIdx);
        }
        else {
            System.out.println("-1");
        }

//        System.out.println(lastIdx);
        return;
    }
}
