package kaohe.Demo;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.sort;

public class LetterDystopy {
    public static void main(String[] args){
        Collection<String> str=new ArrayList<>();
        System.out.println("请输入若干个字符串（输入-1结束）");
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        while(!ss.equals("-1")){
            str.add(ss);
            ss=sc.nextLine();
        }
        System.out.println(str);
        String[] str1=str.toArray(new String[str.size()]);
        List<List<String>> l=groupAnagrams(str1);
        System.out.println(l);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String s:strs){
            char [] ch=s.toCharArray();
            Arrays.sort(ch);
            String k= String.valueOf(ch);
            if(hm.containsKey(k)){
                hm.get(k).add(s);
            }
            else{
                List<String> arr=new ArrayList<>();
                arr.add(s);
                hm.put(k,arr);
            }
        }
        List<List<String>> Arr=new ArrayList<>(hm.values());
        return Arr;
    }
}
