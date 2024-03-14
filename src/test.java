import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        long startTime=System.currentTimeMillis();   //获取开始时间

        for (int i = 0; i < n ; i++){
            String s = in.next();
            if ((s.charAt(0) < '0' || s.charAt(0) > '9') && s.charAt(0) != '-'){
                break;
            }
            int num = Integer.parseInt(s);
            if (num % 5 == 0){
                list1.add(num);
                continue;
            }
            else if (num % 3 == 0){
                list2.add(num);
            }
            else{
                list3.add(num);
            }
        }


        in.close();

        int sum1 = 0, sum2 = 0;

        for (int i : list1){
            sum1 += i;
        }

        for (int i : list2){
            sum2 += i;
        }

        String ans = isEqual(sum1, sum2, list3) ? "true" : "false";

        System.out.print(ans);



//        doSomeThing();  //测试的代码段
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");



    }

    static boolean isEqual(int sum1, int sum2, List<Integer> list){
        int sum3 = 0;
        for (int i : list){
            sum3 += i;
        }
        if (sum1 == sum2 && sum3 == 0){
            return true;
        }

        for (int i = list.size() - 1; i >= 0; i--){
            if (list.get(i) == 0){
                continue;
            }
            int record1 = list.get(i);
            list.set(i, 0);
            for (int j = i - 1; j >= 0; j--){
                if (list.get(j) == 0){
                    continue;
                }
                int record2 = list.get(j);
                list.set(j, 0);
                if (isEqual(sum1 + record1, sum2 + record2, list) || isEqual(sum1 + record2, sum2 + record1, list)){
                    return true;
                }
                list.set(j, record2);
                if (isEqual(sum1 + record1, sum2, list) || isEqual(sum1, sum2 + record1, list)){
                    return true;
                }

            }
            list.set(i, record1);
        }

        return false;
    }

}