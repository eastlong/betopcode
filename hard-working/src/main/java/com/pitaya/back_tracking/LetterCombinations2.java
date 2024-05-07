package com.pitaya.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date 2024/05/07 22:07:00
 **/
public class LetterCombinations2 {
    //设置全局列表存储最后的结果
    List<String> result = new ArrayList<>();
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backTracking(digits, numString, 0);

        return result;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder temp = new StringBuilder();

    /**
     *
     * @param digits 如：23
     * @param numString
     * @param startIndex 当前层遍历的开始索引
     */
    public void backTracking(String digits, String[] numString, int startIndex) {
        // 遍历到头了，如：23， startIndex=2,这实际是已经到头了（超过最后一个元素，如果是最后一个元素，还有处理过程），2之后不可能有长度为2 的结果了
        if (startIndex == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String str = numString[digits.charAt(startIndex) - '0']; // 比如第一步，走到2，digits.charAt(startIndex)=‘2’ '2'-'0' = 2;可以找numString[2]对应的字符串abc
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, startIndex + 1);
            // 剔除末尾继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations2 combination = new LetterCombinations2();
        List<String> strings = combination.letterCombinations("23");
        System.out.println(strings.toString());
    }

}
