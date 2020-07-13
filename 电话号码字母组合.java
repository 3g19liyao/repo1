package kaohe.Demo;

import java.util.*;

public class Telephone {

    public static void main(String[] args) {
        System.out.println("请输入一个字符串（数字2--9）：");
        Scanner sc=new Scanner(System.in);
        String str;
        str=sc.nextLine();
        List<String> arr=letterCombinations(str);
        System.out.println("字母组合为：");
        System.out.println(arr);
    }


    private static List<String> letterCombinations(String digits) {
        String[] str = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> l = new ArrayList<>();
        int len=digits.length();
        if(len==0){
            return l;
        }
        char[] digits1=digits.toCharArray();
        String[] ch=Boom(digits1[0], str);
        l.addAll(Arrays.asList(ch));
        if(len==1){
            return l;
        }
        else{
            for(int i=1;i<len;i++){
                String[] st= Boom(digits1[i], str);
                String[] put=new String[l.size()];
                for(int j=0;j<l.size();j++){
                    put[j]=l.get(j);

                }
                l.clear();
                for(int m=0;m<put.length;m++){
                    for(int n=0;n<st.length;n++){
                        l.add(put[m]+st[n]);
                    }
                }
            }
        }
        return l;
    }
    public static String[] Boom(char s, String[] str){
        int num = s-'0';
        String Arr=str[num];
        return Arr.split("");
    }
}
