package kaohe.Demo;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(candidates.length==0 || target<0 || candidates==null){
            return lists;
        }
        List<Integer> list=new ArrayList<>();
        digui(0,candidates,target,list,lists);
        return lists;
    }
    public void digui(int start,int[] candidates,int target, List list,List lists){
        if(target==0){
            lists.add(new ArrayList<>(list));
        }
        if(target<0){
            return ;
        }
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            digui(i,candidates,target-candidates[i],list,lists);
            list.remove(list.size()-1);
        }
    }
}
