package kaohe.Demo;

import java.math.BigDecimal;
import java.util.*;

public class CoinChange {
    public static void main(String[] args){
        int[] coins=new int[]{186,419,83,408};
        int s=coinChange(coins,6249);
        System.out.println(s);
    }
    public static int coinChange(int[] coins, int amount) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(coins);
        huiSu(coins, 0, amount, list, 0);
        if(list.isEmpty())
            return -1;
        int min=list.get(0);
        for(Integer i:list){
            min=(min<i)?min:i;
        }
        return min;
    }

    public static void huiSu(int[] nums,int n,int target,List list,int s){
        if(n==target){
            list.add(s);
            return ;
        }
        if(n>target)
            return ;
        for(int i=nums.length-1;i>=0;i--){
            if(Long.valueOf(n+nums[i])>0){
                if((target-n)%nums[i]==0){
                    huiSu(nums,target,target,list,s+((target-n)/nums[i]));
                }else{
                    huiSu(nums,n+nums[i],target,list,s+1);
                }
            }
        }
    }
}
