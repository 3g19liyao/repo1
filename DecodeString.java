package kaohe.Demo;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args){
        String s="3[a]2[bc]";
        String str=decodeString(s);
        System.out.println(str);
    }
    public static String decodeString(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Integer> numStack = new Stack<>();
        Stack <StringBuffer> strStack = new Stack<>();
        StringBuffer num = new StringBuffer();
        for (int i = 0, l = s.length(); i < l; i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                num.append(curr);
            }
            else if (curr == '[') {
                numStack.push(Integer.valueOf(num.toString()));
                strStack.push(result);
                result = new StringBuffer();
                num = new StringBuffer();
            }
            else if (curr == ']') {
                int count = numStack.pop();
                String str = result.toString();
                for (int loop = 1; loop < count; loop++) {
                    result.append(str);
                }
                result = strStack.pop().append(result);
            }
            else {
                result.append(curr);
            }
        }
        return result.toString();
    }
}
