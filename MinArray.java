package kaohe.Demo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.min;

public class MinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段数字（以逗号隔开）：");
        String str = sc.nextLine();
        String[] Arr = str.split(",");
        int[] Nums = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            Nums[i] = Integer.parseInt(Arr[i]);
        }
        System.out.println("请输入s：");
        int s=sc.nextInt();
        int len=Min(s,Nums);
        System.out.println("最小长度是："+len);
    }

    public static int Min(int s, int[] nums) {
        int l=0,r=0,cur=0,res=0;
        int len=nums.length;
        while(r<len){
            cur+=nums[r];
            if(cur>=s){
                if(res==0)
                    res=r-l+1;
                else{
                    res=min(res,r-l+1);
                }
                cur-=nums[l];
                cur-=nums[r];
                l++;
                r--;
            }
            r++;
        }
        return res;
    }

}
