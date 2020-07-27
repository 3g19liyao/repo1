package kaohe.Demo;

public class CanPartition {
    public static void main(String[] args){
        int[] nums=new int[]{1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums){
        int num=0;
        for(int n:nums){
            num+=n;
        }
        if(num%2!=0){
            return false;
        }
        int len=nums.length;
        int target=num/2;
        boolean[][] dp=new boolean[len+1][target+1];
        for(int i=0;i<len+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<len+1;i++){
            for(int j=1;j<=target;j++){
                if(j<nums[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
            if(dp[i][target]==true)
                return true;
        }
        return dp[len][target];
    }
}
