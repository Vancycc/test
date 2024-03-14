import java.util.HashSet;

public class code1 {

    static int[] nums = new int[]{2,1,5,6,4,0,-1};

    public static void main(String[] args) {

        int ans = longestConsecutive(nums);

        System.out.println(ans);

    }

    static public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i : nums) {
            hset.add(i);
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int len = max - min + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = i + min;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 0 ; i < len - 1; i++){
            if (hset.contains(arr[i] + 1)){
                dp[i+1] = dp[i] + 1;
            }
            else {
                dp[i+1] = 0;
            }
        }
        int ans = 0;
        for (int i : dp){
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
