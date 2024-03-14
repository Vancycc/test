//import java.util.*;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//
//        int num = in.nextInt();
//        String s = in.next();
//
//        int len = s.length();
//
//        int[][] dp = new int[len][len];
//
//        s.toLowerCase();
//
//        String target = "aeiouAEIOU";
//
//        List<Character> targetList = new ArrayList<>();
//        for (int i = 0; i < 10; i++){
//            targetList.add(target.charAt(i));
//        }
//
//        int count = 0;
//        int maxLen = 0;
//        for (int i = 0; i < len; i++){
//            count = 0;
//            if (!targetList.contains(s.charAt(i))){
//                continue;
//            }
//            for (int j = i + 1; j < len; j++){
//                if (count > num){
//                    break;
//                }
//
//                if (!targetList.contains(s.charAt(j))){
//                    count++;
//                    continue;
//                }
//
//                if (count == num && targetList.contains(s.charAt(j))){
//                    maxLen = Math.max(maxLen, j - i + 1);
//                }
//            }
//        }
//
//        System.out.println(maxLen);
//
//
////        for (int i = 0; i < len; i++){
////            for (int j = i; j < len; j++){
////                if (i == j){
////                    if (targetList.contains(s.charAt(j))){
////                        dp[i][j] = 1;
////                    }else {
////                        break;
////                    }
////                }
////
////
////                if (targetList.contains(s.charAt(j)) && ){
////                    dp[i][j] = 1;
////                }
////                else {
////                    co
////                }
////            }
////        }
//
//
//
//    }
//}

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int num = in.nextInt();
        String s = in.next();

        int len = s.length();

//        int[][] dp = new int[len][len];

        // s.toLowerCase();

        String target = "aeiouAEIOU";

        List<Character> targetList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            targetList.add(target.charAt(i));
        }

        int count = 0;
        int maxLen = 0;
        int left = 0, right = 0;
//                right = num + left + 1;

        while (right < len) {

            while (!targetList.contains(left)){
                left++;
            }
            if (right < left){
                right = left;
                while (right < len && count < num){
                    if (targetList.contains(right)){
                        count++;
                    }
//                    count++;
                    right++;
                }
            }

            if (targetList.contains(right) && count == num){
                maxLen = Math.max(right - left + 1, maxLen);
            }else {
                count++;
            }


            while (count > num && left <= right){
                left++;
                if (targetList.contains(left - 1)){
                    count--;
                }
            }

            right++;

//            if (targetList.contains(right)){
//                count++;
//            }
        }



//        for (int i = 0; i < len; i++) {
//            count = 0;
//            if (!targetList.contains(s.charAt(i))) {
//                continue;
//            }
//            out: for (int j = i; j < len; j++) {
//                if (count > num) {
//                    break;
//                }
//
//                if (!targetList.contains(s.charAt(j))) {
//                    count++;
//                    continue;
//                }
//
//                if (count == num && targetList.contains(s.charAt(j))) {
//                    maxLen = Math.max(maxLen, j - i + 1);
//                    // System.out.println(maxLen + " " + s.substring(i, j + 1) + " ");
//                    // return;
//                }
//            }


        System.out.print(maxLen);

    }
}