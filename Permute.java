package kaohe.Demo;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> lists=permute(nums);
        System.out.println(lists);
    }
    public static List<List<Integer>> permute(int[] nums) {

         List<List<Integer>> lists=new ArrayList<>();
         List<Integer> list=new ArrayList<>();
         List<Integer> num=new ArrayList<>();
         for(int i=0;i<nums.length;i++){
             num.add(nums[i]);
         }
         digui(num,list,lists);
         return lists;
    }
    public static void digui(List num,List list,List lists){
        //System.out.println(list);
        for(int j=0;j<list.size();j++){
            if(num.contains(list.get(j))){
                num.remove(list.get(j));
            }
        }
        if(num.size()==0){
            lists.add(new ArrayList<>(list));
        }
        for(int i=0;i<num.size();i++){
            list.add((Integer) num.get(i));
            digui(new ArrayList(num),list,lists);
            list.remove(list.size()-1);
        }
    }
}
