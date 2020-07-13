package kaohe.Demo;

import java.util.*;

public class Search {
    public static void main(String[] args){
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCB";
        boolean boo=exist(board,word);
        System.out.println(boo);
    }
    public static boolean exist(char[][] board, String word) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char c=board[i][j];
                if(hm.containsKey(c)){
                    hm.put(c,hm.get(c)+1);
                }
                else{
                    hm.put(c,1);
                }
            }
        }
        char[] ch=word.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            char s=ch[i];
            if(hm.containsKey(s) && hm.get(s)>0){
                hm.put(s,hm.get(s)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
