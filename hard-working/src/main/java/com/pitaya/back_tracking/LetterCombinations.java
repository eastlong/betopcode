package com.pitaya.back_tracking;

import java.util.*;

/**
 * @Description:
 * @Date 2024/05/07 09:08:00
 **/
public class LetterCombinations {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> res = new ArrayList<String>(); // 存放结果
    StringBuffer buffer = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        //解决快速寻找数组中所有存在目标字母的方法: Map加回溯
        if (digits.length() == 0)  return res;
        backtrack( digits, 0);
        return res;
    }

    /**
     * 回溯
     * @param digits 输入的数字字符串
     * @param index
     */
    public void backtrack(String digits, int index) {
        if (index == digits.length()) res.add(buffer.toString());
        else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                buffer.append(letters.charAt(i));
                backtrack( digits, index+1);
                buffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations combinations = new LetterCombinations();
        List<String> strings = combinations.letterCombinations(digits);
        System.out.println(strings.toString());
    }
}

/**
 *
 */
