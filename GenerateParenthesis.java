package kaohe.Demo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args){
        int n=3;
        List<String> strings=generateParenthesis(n);
        System.out.println(strings);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        String str="(";
        huiSu(str,list,n);
        return list;
    }
    public static void huiSu(String str,List list,int n){
        int a=0,b=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                a++;
            else
                b++;
        }
        if(a==n && b==n){
            list.add(str);
        }
        else if(a>b && a<n){
            StringBuffer sb=new StringBuffer(str);
            huiSu(sb.append("(").toString(),list,n);
            sb=sb.deleteCharAt(sb.length()-1);
            huiSu(sb.append(")").toString(),list,n);
        }
        else if(a==n){
            StringBuffer s=new StringBuffer(str);
            huiSu(s.append(")").toString(),list,n);
        }
        else{
            StringBuffer s=new StringBuffer(str);
            huiSu(s.append("(").toString(),list,n);
        }
    }
}
