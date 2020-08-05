package LiKou;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args){
        String s="catsandog";
        List<String> stringList=new ArrayList<>();
        stringList.add("cats");
        stringList.add("sand");
        stringList.add("cat");
        stringList.add("and");
        stringList.add("dog");
        boolean b=wordBreak(s,stringList);
        System.out.println(b);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //public static boolean find(String string,List<String> list){

    //}
}
